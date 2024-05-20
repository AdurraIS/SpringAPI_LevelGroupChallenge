package com.salesunity.systemapp.exceptions;

public class TipoProdutoNotFound extends RuntimeException{

    public TipoProdutoNotFound() {
        super("Tipo Produto não encontrado!");
    }

    public TipoProdutoNotFound(String message) {
        super(message);
    }
}
