package com.NPlastic.controller;

import com.NPlastic.dto.producaoextrusao.ProducaoExtrusaoRequest;
import com.NPlastic.dto.producaoextrusao.ProducaoExtrusaoResponse;
import com.NPlastic.entity.ProducaoExtrusao;
import com.NPlastic.services.producaoextrusao.ProducaoExtrusaoImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/extrusao")
public class ExtrusaoController {


    private final ProducaoExtrusaoImpl producaoService;

    public ExtrusaoController(ProducaoExtrusaoImpl producaoService) {
        this.producaoService = producaoService;
    }

    @PostMapping
    ResponseEntity<ProducaoExtrusaoResponse> criarPedidoExtrusao(@RequestBody ProducaoExtrusaoRequest request) {

        if (request != null) {
            ProducaoExtrusaoResponse response = producaoService.criarProdutoExtrusao(request);


            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

    }
    @GetMapping
    ResponseEntity <List<ProducaoExtrusaoResponse>> listarExtrusao(){

        return  ResponseEntity.ok(producaoService.listarProducaoExtrusao());
    }

    @PutMapping("/{id}")
    ResponseEntity<ProducaoExtrusaoResponse> atualizarProducaoExtrusao(@PathVariable int id , @RequestBody ProducaoExtrusaoRequest request) {

        if (request != null) {
            ProducaoExtrusaoResponse response = producaoService.atualizarProdutoExtrusao(id, request);

            return ResponseEntity.status(HttpStatus.OK).build();
        }
        return ResponseEntity.notFound().build();
    }
    @GetMapping("/{id}")
    ResponseEntity<ProducaoExtrusaoResponse> buscarPorId(@PathVariable int id){

            ProducaoExtrusaoResponse response = producaoService.buscarPorId(id);

    return ResponseEntity.ok(response);
    }
    @DeleteMapping("/{id}")

    String deletar(@PathVariable  int id){

        String response = producaoService.deletarProducaoExtrusao(id);

        if(!response.isEmpty()){
            return "Removido";
           }
        return "Nao Localizado";
    }

}