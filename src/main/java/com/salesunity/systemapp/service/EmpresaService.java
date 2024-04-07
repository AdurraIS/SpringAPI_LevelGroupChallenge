package com.salesunity.systemapp.service;

import com.salesunity.systemapp.dto.EmpresaDTO;
import com.salesunity.systemapp.dto.ItemDTO;
import com.salesunity.systemapp.model.Empresa;
import com.salesunity.systemapp.repository.EmpresaRepository;
import com.salesunity.systemapp.repository.PedidoRepository;
import com.salesunity.systemapp.repository.ProdutoRepository;
import com.salesunity.systemapp.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class EmpresaService {

    private final EmpresaRepository empresaRepository;
    private final ProdutoRepository produtoRepository;
    private final UsuarioRepository usuarioRepository;
    private final PedidoRepository pedidoRepository;

    @Autowired
    public EmpresaService(EmpresaRepository empresaRepository, ProdutoRepository produtoRepository, UsuarioRepository usuarioRepository, PedidoRepository pedidoRepository) {
        this.empresaRepository = empresaRepository;
        this.produtoRepository = produtoRepository;
        this.usuarioRepository = usuarioRepository;
        this.pedidoRepository = pedidoRepository;
    }

    public Page<EmpresaDTO> getAllPaginable(Pageable pageable){
        return empresaRepository.findAll(pageable).map(EmpresaDTO::new);
    }
    public EmpresaDTO findById(Long id){
        return new EmpresaDTO(empresaRepository.findById(id).orElseThrow());

    }
    public EmpresaDTO saveEmpresa(EmpresaDTO empresaDTO){
        Empresa empresa = new Empresa();
        return new EmpresaDTO(empresaRepository.save(dtoToObject(empresa,empresaDTO)));
    }
    public void deleteEmpresa(Long id){
        this.findById(id);
        empresaRepository.deleteById(id);
    }
    public void updateEmpresa(EmpresaDTO empresaDTO){
        Empresa empresa = empresaRepository.findById(empresaDTO.getId()).orElseThrow();
        empresaRepository.save(dtoToObject(empresa, empresaDTO));
    }
    public Empresa dtoToObject(Empresa empresa, EmpresaDTO empresaDTO){
        empresa.setName(empresaDTO.getName());
        empresa.setCnpj(empresaDTO.getCnpj());
        empresa.setType(empresaDTO.getType());
        empresa.setEmail(empresaDTO.getEmail());
        if(empresaDTO.getProdutos() != null){
            empresa.setProdutos(produtoRepository.findAllById(empresaDTO.getProdutos()));
        }
        if(empresaDTO.getUsuarios() != null){
            empresa.setUsuarios(usuarioRepository.findAllById(empresaDTO.getUsuarios()));
        }
        if(empresaDTO.getVendas() != null){
            empresa.setVendas(pedidoRepository.findAllById(empresaDTO.getVendas()));
        }
        return empresa;
    }

}
