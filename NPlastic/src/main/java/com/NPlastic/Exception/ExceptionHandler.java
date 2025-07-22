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

    @org.springframework.web.bind.annotation.ExceptionHandler(NPlasticException.class)
    public ResponseEntity<String> handleErroGeral(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Erro interno do servidor: " + ex.getMessage());
    }

}
