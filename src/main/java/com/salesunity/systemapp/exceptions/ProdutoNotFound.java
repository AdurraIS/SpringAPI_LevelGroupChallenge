package com.salesunity.systemapp.exceptions;

public class ProdutoNotFound extends RuntimeException{

    public ProdutoNotFound() {
        super("Produto não encontrado!");
    }

    public ProdutoNotFound(String message) {
        super(message);
    }
}
