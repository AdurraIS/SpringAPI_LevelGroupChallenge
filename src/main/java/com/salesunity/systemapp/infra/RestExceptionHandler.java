package com.salesunity.systemapp.infra;

import com.salesunity.systemapp.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserNotFound.class)
    private ResponseEntity<String> userNotFound(UserNotFound exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
    }
    @ExceptionHandler(EmpresaNotFound.class)
    private ResponseEntity<String> empresaNotFound(EmpresaNotFound exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Empresa not found");
    }
    @ExceptionHandler(CategoriaNotFound.class)
    private ResponseEntity<String> categoriaNotFound(CategoriaNotFound exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Categoria not found");
    }
    @ExceptionHandler(ItemNotFound.class)
    private ResponseEntity<String> itemNotFound(ItemNotFound exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item not found");
    }
    @ExceptionHandler(ProdutoNotFound.class)
    private ResponseEntity<String> produtoNotFound(ProdutoNotFound exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto not found");
    }
    @ExceptionHandler(PedidoNotFound.class)
    private ResponseEntity<String> pedidoNotFound(PedidoNotFound exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pedido not found");
    }
    @ExceptionHandler(TipoProdutoNotFound.class)
    private ResponseEntity<String> tipoProdutoNotFound(TipoProdutoNotFound exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tipo Produto not found");
    }

}
