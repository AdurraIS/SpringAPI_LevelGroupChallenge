package com.salesunity.systemapp.service;

import com.salesunity.systemapp.dto.EmpresaDTO;
import com.salesunity.systemapp.dto.PedidoDTO;
import com.salesunity.systemapp.model.Empresa;
import com.salesunity.systemapp.model.Pedido;
import com.salesunity.systemapp.repository.EmpresaRepository;
import com.salesunity.systemapp.repository.ItemRepository;
import com.salesunity.systemapp.repository.PedidoRepository;
import com.salesunity.systemapp.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

    private final UsuarioRepository usuarioRepository;
    private final EmpresaRepository empresaRepository;
    private final ItemRepository itemRepository;
    private final PedidoRepository pedidoRepository;

    @Autowired
    public PedidoService(UsuarioRepository usuarioRepository, EmpresaRepository empresaRepository, ItemRepository itemRepository, PedidoRepository pedidoRepository) {
        this.usuarioRepository = usuarioRepository;
        this.empresaRepository = empresaRepository;
        this.itemRepository = itemRepository;
        this.pedidoRepository = pedidoRepository;
    }

    public Page<PedidoDTO> getAllPaginable(Pageable pageable){
        return pedidoRepository.findAll(pageable).map(PedidoDTO::new);
    }

    public PedidoDTO findById(Long id){
        return new PedidoDTO(pedidoRepository.findById(id).orElseThrow());
    }

    public PedidoDTO savePedido(PedidoDTO pedidoDTO){
        Pedido pedido = new Pedido();
        return new PedidoDTO(pedidoRepository.save(dtoToObject(pedido,pedidoDTO)));
    }
    public void deletePedido(Long id){
        PedidoDTO pedidoDTO = this.findById(id);
        pedidoRepository.deleteById(id);
    }
    public void updatePedido(PedidoDTO newPedidoDTO){
        Pedido pedido = pedidoRepository.findById(newPedidoDTO.getId()).orElseThrow();
        pedidoRepository.save(dtoToObject(pedido,newPedidoDTO));
    }
    public Pedido dtoToObject(Pedido pedido,PedidoDTO pedidoDTO){
        pedido.setId(pedidoDTO.getId());
        pedido.setItems(itemRepository.findAllById(pedidoDTO.getItems()));
        pedido.setFornecedor(empresaRepository.findById(pedidoDTO.getFornecedor()).orElseThrow());
        pedido.setComprador(usuarioRepository.findById(pedidoDTO.getComprador()).orElseThrow());
        pedido.setConcluido(pedidoDTO.getConcluido());
        return pedido;
    }

}
