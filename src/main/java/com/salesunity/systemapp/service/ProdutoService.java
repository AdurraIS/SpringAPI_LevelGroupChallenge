package com.salesunity.systemapp.service;

import com.salesunity.systemapp.dto.EmpresaDTO;
import com.salesunity.systemapp.dto.ProdutoDTO;
import com.salesunity.systemapp.model.Empresa;
import com.salesunity.systemapp.model.Produto;
import com.salesunity.systemapp.repository.CategoriaRepository;
import com.salesunity.systemapp.repository.EmpresaRepository;
import com.salesunity.systemapp.repository.ProdutoRepository;
import com.salesunity.systemapp.repository.TipoProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    private final EmpresaRepository empresaRepository;
    private final TipoProdutoRepository tipoProdutoRepository;
    private final CategoriaRepository categoriaRepository;
    private final ProdutoRepository produtoRepository;
    @Autowired
    public ProdutoService(EmpresaRepository empresaRepository, TipoProdutoRepository tipoProdutoRepository, CategoriaRepository categoriaRepository, ProdutoRepository produtoRepository) {
        this.empresaRepository = empresaRepository;
        this.tipoProdutoRepository = tipoProdutoRepository;
        this.categoriaRepository = categoriaRepository;
        this.produtoRepository = produtoRepository;
    }

    public Page<ProdutoDTO> getAllPaginable(Pageable pageable){
        return produtoRepository.findAll(pageable).map(ProdutoDTO::new);
    }
    public ProdutoDTO findById(Long id){
        return new ProdutoDTO(produtoRepository.findById(id).orElseThrow());

    }
    public ProdutoDTO saveProduto(ProdutoDTO produtoDTO){
        Produto produto = new Produto();
        return new ProdutoDTO(produtoRepository.save(dtoToObject(produto,produtoDTO)));
    }
    public void deleteProduto(Long id){
        this.findById(id);
        produtoRepository.deleteById(id);
    }
    public void updateProduto(ProdutoDTO newProdutoDTO){
        Produto produto = produtoRepository.findById(newProdutoDTO.getId()).orElseThrow();
        produtoRepository.save(dtoToObject(produto,newProdutoDTO));
    }
    public Produto dtoToObject(Produto produto, ProdutoDTO produtoDTO){
        produto.setId(produtoDTO.getId());
        produto.setProductType(tipoProdutoRepository.findById(produtoDTO.getProductType_id()).orElseThrow());
        produto.setCategory(categoriaRepository.findById(produtoDTO.getCategory_id()).orElseThrow());
        produto.setDescription(produtoDTO.getDescription());
        produto.setEmpresa(empresaRepository.findById(produtoDTO.getEmpresa_id()).orElseThrow());
        produto.setPrice(produtoDTO.getPrice());

        return produto;
    }
}
