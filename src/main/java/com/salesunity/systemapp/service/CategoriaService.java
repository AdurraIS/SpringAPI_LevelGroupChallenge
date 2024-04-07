package com.salesunity.systemapp.service;

import com.salesunity.systemapp.dto.CategoriaDTO;
import com.salesunity.systemapp.model.Categoria;
import com.salesunity.systemapp.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    @Autowired
    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public List<CategoriaDTO> findAll(){
        return categoriaRepository.findAll().stream().map(CategoriaDTO::new).toList();
    }
    public CategoriaDTO findById(Long id){
        return new CategoriaDTO(categoriaRepository.findById(id).orElseThrow());
    }
    public CategoriaDTO saveCategoria(CategoriaDTO categoriaDTO){
        Categoria categoria = new Categoria();
        return new CategoriaDTO(categoriaRepository.save(dtoToObject(categoria,categoriaDTO)));
    }
    public void deleteCategoria(Long id){
        this.findById(id);
        categoriaRepository.deleteById(id);
    }
    public void updateCategoria(CategoriaDTO newCategoriaDTO){
        Categoria categoria = categoriaRepository.findById(newCategoriaDTO.getId()).orElseThrow();
        categoriaRepository.save(dtoToObject(categoria,newCategoriaDTO));
    }
    public Categoria dtoToObject(Categoria categoria, CategoriaDTO categoriaDTO){
        categoria.setName(categoriaDTO.getName());
        return categoria;
    }
}
