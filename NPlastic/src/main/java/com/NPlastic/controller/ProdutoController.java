package com.NPlastic.controller;

import com.NPlastic.dto.produtoDto.produtoRequest;
import com.NPlastic.dto.produtoDto.produtoResponse;
import com.NPlastic.services.produtoService.produtoServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    private final produtoServiceImpl produtoService;

    public ProdutoController(produtoServiceImpl produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping
    public ResponseEntity<produtoResponse> criarProduto(@RequestBody produtoRequest produtoRequest){

        return ResponseEntity.status(HttpStatus.OK).body(produtoService.cadastrarNovo(produtoRequest));

    }
    @PutMapping("/{id}")
    ResponseEntity<produtoResponse> alterar(@RequestBody produtoRequest produtoRequest , @PathVariable int id){

        produtoResponse produtoResponse = produtoService.alterarPedido(produtoRequest,id);

        return ResponseEntity.status(HttpStatus.OK).body(produtoResponse);
    }
    @GetMapping("{id}")
    ResponseEntity<produtoResponse> buscarPorId(@PathVariable int id){

    return ResponseEntity.status(HttpStatus.OK).body(produtoService.buscarPorId(id).orElseThrow(()-> new RuntimeException("Nao Encontrado")));

    }
    @DeleteMapping("/{id}")
    ResponseEntity<String> deletar(@PathVariable int id){

        return ResponseEntity.status(HttpStatus.OK).body(produtoService.deletar(id));
    }

    @GetMapping
    ResponseEntity <List<produtoResponse>> listarProduto(){

        return ResponseEntity.status(HttpStatus.OK).body(produtoService.listarProduto());
    }


}
