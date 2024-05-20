package com.salesunity.systemapp.service;

import com.salesunity.systemapp.dto.EmpresaDTO;
import com.salesunity.systemapp.exceptions.EmpresaNotFound;
import com.salesunity.systemapp.model.Empresa;
import com.salesunity.systemapp.repository.EmpresaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;



@Service
public class EmpresaService {

    private final EmpresaRepository empresaRepository;

    @Autowired
    public EmpresaService(EmpresaRepository empresaRepository){
        this.empresaRepository = empresaRepository;
    }

    public Page<EmpresaDTO> getAllPaginable(Pageable pageable){
        return empresaRepository.findAll(pageable).map(EmpresaDTO::new);
    }
    public EmpresaDTO findById(Long id){
        return new EmpresaDTO(empresaRepository.findById(id).orElseThrow(EmpresaNotFound::new));

    }
    @Transactional
    public EmpresaDTO saveEmpresa(EmpresaDTO empresaDTO){
        Empresa empresa = new Empresa();
        return new EmpresaDTO(empresaRepository.save(dtoToObject(empresa,empresaDTO)));
    }
    public void deleteEmpresa(Long id){
        this.findById(id);
        empresaRepository.deleteById(id);
    }
    @Transactional
    public void updateEmpresa(EmpresaDTO empresaDTO){
        Empresa empresa = empresaRepository.findById(empresaDTO.getId()).orElseThrow(EmpresaNotFound::new);
        empresaRepository.save(dtoToObject(empresa, empresaDTO));
    }
    public Empresa dtoToObject(Empresa empresa, EmpresaDTO empresaDTO){
        empresa.setName(empresaDTO.getName());
        empresa.setCnpj(empresaDTO.getCnpj());
        empresa.setType(empresaDTO.getType());
        empresa.setEmail(empresaDTO.getEmail());
        return empresa;
    }

}
