package com.NPlastic.controllers;

import com.NPlastic.Dto.ProdutosDto.ProdutoRequest;
import com.NPlastic.Dto.ProdutosDto.ProdutoResponse;
import com.NPlastic.Entity.Produto;
import com.NPlastic.service.serviceProduto.ServiceProdutoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoControllers {

    @Autowired
    private ServiceProdutoImpl service;

    @PostMapping
    public ResponseEntity<ProdutoResponse> criarProduto(@RequestBody ProdutoRequest produto) {

        return ResponseEntity.ok(service.criarProduto(produto));


    }
    @PutMapping("/{id}")
    public ResponseEntity<ProdutoResponse> atualizaProduto(@RequestBody ProdutoRequest produtoRequest,
                                                           @PathVariable int id){
        produtoRequest.setId_Produto(id);

        if(produtoRequest != null) {
            return ResponseEntity.ok().body(service.AtualizaProduto(produtoRequest));
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
