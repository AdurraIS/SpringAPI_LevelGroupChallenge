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
        Item item = new Item();
        return new ItemDTO(itemRepository.save(dtoToObject(item,itemDTO)));
    }
    public void deleteItem(Long id){
        this.findById(id);
        itemRepository.deleteById(id);
    }
    public void updateItem(ItemDTO newItemDTO){
        Item item = itemRepository.findById(newItemDTO.getId()).orElseThrow();
        itemRepository.save(dtoToObject(item,newItemDTO));
    }
    public Item dtoToObject(Item item,ItemDTO itemDTO){
        item.setId(itemDTO.getId());
        item.setPedido(pedidoRepository.findById(itemDTO.getPedido_id()).orElseThrow());
        item.setProduto(produtoRepository.findById(itemDTO.getProduto_id()).orElseThrow());
        item.setQuantidade(itemDTO.getQuantidade());
        item.setValorTotal(item.getQuantidade() * item.getProduto().getPrice());
        return item;
    }
}
