package com.salesunity.systemapp.exceptions;

public class EmpresaNotFound extends RuntimeException{

    public EmpresaNotFound() {
        super("Empresa não encontrada!");
    }

    public EmpresaNotFound(String message) {
        super(message);
    }
}
