package com.salesunity.systemapp.exceptions;

public class ItemNotFound extends RuntimeException{

    public ItemNotFound() {
        super("Item não encontrado!");
    }

    public ItemNotFound(String message) {
        super(message);
    }
}
