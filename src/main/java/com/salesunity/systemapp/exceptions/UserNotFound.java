package com.salesunity.systemapp.exceptions;

public class UserNotFound extends RuntimeException{

    public UserNotFound() {
        super("Usuario não encontrado!");
    }

    public UserNotFound(String message) {
        super(message);
    }
}
