package com.salesunity.systemapp.exceptions;

public class EmpresaCreationFailed extends RuntimeException{

    public EmpresaCreationFailed() {
        super("Criação da empresa falhou!");
    }

    public EmpresaCreationFailed(String message) {
        super(message);
    }
}
