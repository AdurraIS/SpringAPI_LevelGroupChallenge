package com.salesunity.systemapp.service;

import com.salesunity.systemapp.dto.ItemDTO;
import com.salesunity.systemapp.dto.PedidoDTO;
import com.salesunity.systemapp.model.Item;
import com.salesunity.systemapp.model.Pedido;
import com.salesunity.systemapp.repository.EmpresaRepository;
import com.salesunity.systemapp.repository.ItemRepository;
import com.salesunity.systemapp.repository.PedidoRepository;
import com.salesunity.systemapp.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
    public Page<PedidoDTO> getAllPaginableByComprador(Pageable pageable, Long id){
        return pedidoRepository.findByCompradorId(pageable, id).map(PedidoDTO::new);
    }
    public PedidoDTO findById(Long id){
        return new PedidoDTO(pedidoRepository.findById(id).orElseThrow());
    }

    @Transactional
    public PedidoDTO savePedido(PedidoDTO pedidoDTO){
        Pedido pedido = new Pedido();

        List<Item> itemsPedido = new ArrayList<>();

        // verifica se o ID da empresa existe
        if (pedidoDTO.getFornecedor().getId() != null) {
            // busca a empresa no banco, se ele existir, coloca no pedido o fornecedor
            pedido.setFornecedor(empresaRepository.findById(pedidoDTO.getFornecedor().getId()).orElseThrow());
        }

        // verifica se o ID do usuario existe
        if (pedidoDTO.getComprador().getId() != null) {
            // busca o usuario no banco, se ele existir, coloca no pedido o comprador
            pedido.setComprador(usuarioRepository.findById(pedidoDTO.getComprador().getId()).orElseThrow());
        }

        // verifica se o Items não está vazio
        if(pedidoDTO.getItems() != null){
            // loop pelos items do DTO
            for (ItemDTO itemDTO : pedidoDTO.getItems()) {
                // verifica se o ID do item existe
                if (itemDTO.getId() != null) {
                    // busca o item no banco, se ele existir, adiciona à lista de items pedido
                    itemRepository.findById(itemDTO.getId()).ifPresent(itemsPedido::add);
                }
            }
        }

        pedido = dtoToObject(pedido,pedidoDTO);
        pedido.setItems(itemsPedido);

        return new PedidoDTO(pedidoRepository.save(pedido));
    }
    public void deletePedido(Long id){
        findById(id);
        pedidoRepository.deleteById(id);
    }
    @Transactional
    public void updatePedido(PedidoDTO newPedidoDTO){
        Pedido pedido = pedidoRepository.findById(newPedidoDTO.getId()).orElseThrow();
        pedidoRepository.save(dtoToObject(pedido,newPedidoDTO));
    }
    public Pedido dtoToObject(Pedido pedido,PedidoDTO pedidoDTO){
        pedido.setId(pedidoDTO.getId());
        pedido.setConcluido(pedidoDTO.getConcluido());
        return pedido;
    }

}
