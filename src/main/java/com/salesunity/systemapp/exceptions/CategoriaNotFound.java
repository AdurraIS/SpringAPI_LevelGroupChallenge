package com.salesunity.systemapp.exceptions;

public class CategoriaNotFound extends RuntimeException{

    public CategoriaNotFound() {
        super("Categoria não encontrada!");
    }

    public CategoriaNotFound(String message) {
        super(message);
    }
}
