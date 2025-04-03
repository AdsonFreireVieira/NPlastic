package com.NPlastic.controllers;

import com.NPlastic.dto.dtoProduto.ProdutoResponse;
import com.NPlastic.service.serviceProduto.ServiceProdutoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoControllers {

    @Autowired
    private ServiceProdutoImpl service;

    @PostMapping
    public ResponseEntity<ProdutoResponse> criarProduto(@RequestBody ProdutoResponse produtoResponse){

        ProdutoResponse response = service.criarProduto(produtoResponse);

        if(response != null){
            return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(produtoResponse.getId_Produto())
                    .toUri()).body(response);

        }
        return  ResponseEntity.notFound().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<ProdutoResponse> atualizaProduto(@RequestBody ProdutoResponse produtoResponse,
                                                           @PathVariable int id){
        produtoResponse.setId_Produto(id);

        if(produtoResponse != null) {
            return ResponseEntity.ok().body(service.AtualizaProduto(produtoResponse));
        }
        return ResponseEntity.notFound().build();

    }
    @GetMapping
    public ResponseEntity <List<ProdutoResponse>> listarProduto(){

        return ResponseEntity.ok().body(service.listarProdutos());
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponse>buscarPorId(@PathVariable int id){

        return ResponseEntity.ok().body(service.buscarPorId(id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String>deletarProduto(@PathVariable int id){

        return ResponseEntity.ok().body(service.deletarProduto(id));
    }
}













