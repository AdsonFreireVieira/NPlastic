package com.NPlastic.controller;

import com.NPlastic.dto.produtodto.ProdutosRequest;
import com.NPlastic.dto.produtodto.ProdutosResponse;
import com.NPlastic.services.produtoservice.ProdutoServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Produto")
public class ProdutoController {

    private final ProdutoServiceImpl service;

    public ProdutoController(ProdutoServiceImpl service) {
        this.service = service;
    }

    @PostMapping()
    ResponseEntity<ProdutosResponse> criar(@RequestBody ProdutosRequest request){

        if(request != null){
            service.criarProduto(request);
                return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        return ResponseEntity.badRequest().build();
    }
    @GetMapping
    ResponseEntity <List<ProdutosResponse>> listarPedido(){

        return ResponseEntity.ok(service.listarProdutos());

    }
    @PutMapping("/{id}")
    ResponseEntity<ProdutosResponse> atualizarProduto(@RequestParam int id , @RequestBody ProdutosRequest request){

        request.setId(id);

          service.atualizarProduto(id, request);

        return ResponseEntity.status(HttpStatus.OK).build();

    }
    @GetMapping("/{id}")
    ResponseEntity<ProdutosResponse> bucarPorid(@RequestParam int id){

        ProdutosResponse produtosResponse = service.buscarPorId(id);

        return ResponseEntity.ok(produtosResponse);
    }
  @DeleteMapping("/{id}")
     String deletarProduto(@RequestParam int id){

        ProdutosResponse produtosResponse = service.buscarPorId(id);

        if(produtosResponse != null){

            service.deletarProduto(id);
            return "Deletado";
        }
        return "Nao Localizado";
  }
}
