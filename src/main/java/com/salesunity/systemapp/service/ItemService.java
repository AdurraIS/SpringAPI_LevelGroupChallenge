package com.salesunity.systemapp.service;

import com.salesunity.systemapp.dto.ItemDTO;
import com.salesunity.systemapp.model.Item;
import com.salesunity.systemapp.repository.ItemRepository;
import com.salesunity.systemapp.repository.PedidoRepository;
import com.salesunity.systemapp.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    private final ItemRepository itemRepository;
    private final PedidoRepository pedidoRepository;
    private final ProdutoRepository produtoRepository;


    public ItemService(ItemRepository itemRepository, PedidoRepository pedidoRepository, ProdutoRepository produtoRepository) {
        this.itemRepository = itemRepository;
        this.pedidoRepository = pedidoRepository;
        this.produtoRepository = produtoRepository;
    }

    public ItemDTO findById(Long id){
        return new ItemDTO(itemRepository.findById(id).orElseThrow());
    }
    public ItemDTO saveItem(ItemDTO itemDTO){
        return new ItemDTO(itemRepository.save(dtoToObject(itemDTO)));
    }
    public void deleteItem(Long id){
        this.findById(id);
        itemRepository.deleteById(id);
    }
    public void updateItem(ItemDTO newItemDTO){
        findById(newItemDTO.getId());
        itemRepository.save(dtoToObject(newItemDTO));
    }
    public Item dtoToObject(ItemDTO itemDTO){
        Item item = new Item();
        item.setId(itemDTO.getId());
        item.setPedido(pedidoRepository.findById(itemDTO.getPedido_id()).orElseThrow());
        item.setProduto(produtoRepository.findById(itemDTO.getProduto_id()).orElseThrow());
        item.setQuantidade(itemDTO.getQuantidade());
        item.setValorTotal(item.getQuantidade() * item.getProduto().getPrice());
        return item;
    }
}
