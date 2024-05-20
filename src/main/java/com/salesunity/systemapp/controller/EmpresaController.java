package com.salesunity.systemapp.controller;

import com.salesunity.systemapp.dto.EmpresaCreate.EmpresaCreateDTO;
import com.salesunity.systemapp.dto.EmpresaDTO;
import com.salesunity.systemapp.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/api/v1/empresas")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @GetMapping
    public ResponseEntity<Page<EmpresaDTO>> getPaginableEmpresas(@RequestParam(name = "page", defaultValue = "0") int page,
                                                     @RequestParam(name = "size", defaultValue = "10") int size){
        PageRequest pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(empresaService.getAllPaginable(pageable));
    }
    @GetMapping("/{id}")
    public ResponseEntity<EmpresaDTO> getEmpresaById(@PathVariable Long id){
        return ResponseEntity.ok(empresaService.findById(id));
    }

    @PostMapping
    public ResponseEntity<EmpresaCreateDTO> createEmpresa(@RequestBody EmpresaCreateDTO empresaDTO){
        return ResponseEntity.ok(empresaService.saveEmpresa(empresaDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmpresa(@PathVariable Long id){
        empresaService.deleteEmpresa(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<Void> updateEmpresa(@RequestBody EmpresaDTO empresaDTO){
        empresaService.updateEmpresa(empresaDTO);
        return ResponseEntity.noContent().build();
    }


}
