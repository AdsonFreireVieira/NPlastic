package com.NPlastic.controller;

import com.NPlastic.dto.estoquedto.EstoqueRequest;
import com.NPlastic.dto.estoquedto.EstoqueResponse;
import com.NPlastic.services.producaoestoque.EstoqueServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Estoque")
public class EstoqueController {

    private final EstoqueServiceImpl service;

    public EstoqueController(EstoqueServiceImpl service) {
        this.service = service;
    }

    @PostMapping
    ResponseEntity<EstoqueResponse> criarEstoque(@RequestBody EstoqueRequest request) {

        if (request != null) {
            service.criarEstoque(request);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/{id}")
    ResponseEntity<EstoqueResponse> atualizarEstoque(@PathVariable int id, @RequestBody EstoqueRequest request) {

        request.setId(id);
        service.atualizarEstoque(id, request);
        return ResponseEntity.status(HttpStatus.OK).build();

    }

    @GetMapping
    ResponseEntity<List<EstoqueResponse>> listarEstoque() {

      return   ResponseEntity.ok(service.listarEstoque());
    }
    @GetMapping("/{id}")
    ResponseEntity<EstoqueResponse> buscarPorId(@PathVariable int id){

        EstoqueResponse response = service.buscarPorId(id);

        return ResponseEntity.ok(response);

             }

}
