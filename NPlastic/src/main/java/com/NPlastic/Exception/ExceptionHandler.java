package com.NPlastic.Exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(NPlasticException.class)
    public ResponseEntity<String> handleErroNaoEncotrado(NPlasticException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

  @org.springframework.web.bind.annotation.ExceptionHandler(ProdutoException.class)
    public ResponseEntity<String> handleProdutoNaoEncontrado(NPlasticException ex){

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
  }

}
