package com.salesunity.systemapp.exceptions;

public class PedidoNotFound extends RuntimeException{

    public PedidoNotFound() {
        super("Pedido não encontrado!");
    }

    public PedidoNotFound(String message) {
        super(message);
    }
}
