package com.salesunity.systemapp.controller;

import com.salesunity.systemapp.dto.TipoProdutoDTO;
import com.salesunity.systemapp.service.TipoProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/v1/tipoprodutos")
public class TipoProdutoController {
    @Autowired
    private TipoProdutoService tipoProdutoService;

    @GetMapping
    public ResponseEntity<List<TipoProdutoDTO>> getAllTipoProduto(){
        return ResponseEntity.ok(tipoProdutoService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<TipoProdutoDTO> getTipoProdutoById(@PathVariable Long id){
        return ResponseEntity.ok(tipoProdutoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<TipoProdutoDTO> createTipoProduto(@RequestBody TipoProdutoDTO tipoProdutoDTO){
        return ResponseEntity.ok(tipoProdutoService.saveTipoProduto(tipoProdutoDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTipoProduto(@PathVariable Long id){
        tipoProdutoService.deleteTipoProduto(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<Void> updateTipoProduto(@RequestBody TipoProdutoDTO tipoProdutoDTO){
        tipoProdutoService.updateTipoProduto(tipoProdutoDTO);
        return ResponseEntity.noContent().build();
    }
}
