package com.salesunity.systemapp.service;

import com.salesunity.systemapp.dto.TipoProdutoDTO;
import com.salesunity.systemapp.model.TipoProduto;
import com.salesunity.systemapp.repository.TipoProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoProdutoService {

    private final TipoProdutoRepository tipoProdutoRepository;

    @Autowired
    public TipoProdutoService(TipoProdutoRepository tipoProdutoRepository) {
        this.tipoProdutoRepository = tipoProdutoRepository;
    }

    public List<TipoProdutoDTO> findAll(){
        return tipoProdutoRepository.findAll().stream().map(TipoProdutoDTO::new).toList();
    }
    public TipoProdutoDTO findById(Long id){
        return new TipoProdutoDTO(tipoProdutoRepository.findById(id).orElseThrow());
    }
    public TipoProdutoDTO saveTipoProduto(TipoProdutoDTO tipoProdutoDTO){
        TipoProduto tipoProduto = new TipoProduto();
        return new TipoProdutoDTO(tipoProdutoRepository.save(dtoToObject(tipoProduto,tipoProdutoDTO)));
    }
    public void deleteTipoProduto(Long id){
        this.findById(id);
        tipoProdutoRepository.deleteById(id);
    }
    public void updateTipoProduto(TipoProdutoDTO newTipoProdutoDTO){
        TipoProduto tipoProduto = tipoProdutoRepository.findById(newTipoProdutoDTO.getId()).orElseThrow();
        tipoProdutoRepository.save(dtoToObject(tipoProduto,newTipoProdutoDTO));
    }
    public TipoProduto dtoToObject(TipoProduto tipoProduto, TipoProdutoDTO tipoProdutoDTO){
        tipoProduto.setName(tipoProdutoDTO.getName());
        return tipoProduto;
    }
}
