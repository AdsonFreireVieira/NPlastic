package com.NPlastic.controllers;

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
    public ResponseEntity<Produto> criarProduto(@RequestBody Produto produto) {

        return ResponseEntity.ok(service.criarProduto(produto));


    }
    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizaProduto(@RequestBody Produto produto,
                                                           @PathVariable int id){
        produto.setId_Produto(id);

        if(produto != null) {
            return ResponseEntity.ok().body(service.AtualizaProduto(produto));
        }
        return ResponseEntity.notFound().build();

    }
    @GetMapping
    public ResponseEntity <List<Produto>> listarProduto(){

        return ResponseEntity.ok().body(service.listarProdutos());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Produto>buscarPorId(@PathVariable int id){

        return ResponseEntity.ok().body(service.buscarPorId(id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String>deletarProduto(@PathVariable int id){

        return ResponseEntity.ok().body(service.deletarProduto(id));
    }
}
