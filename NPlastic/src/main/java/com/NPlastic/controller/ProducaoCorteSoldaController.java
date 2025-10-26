package com.NPlastic.controller;

import com.NPlastic.dto.producaocortesolda.ProducaoCorteeSoldaRequest;
import com.NPlastic.dto.producaocortesolda.ProducaoCorteeSoldaResponse;
import com.NPlastic.entity.ProducaoCorteSolda;
import com.NPlastic.services.producaocortesolda.ProducaoCorteSoldaI;
import com.NPlastic.services.producaocortesolda.ProducaoCorteSoldaImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/CorteSolda")
public class ProducaoCorteSoldaController {

    private final ProducaoCorteSoldaImpl service;

    public ProducaoCorteSoldaController(ProducaoCorteSoldaImpl service) {
        this.service = service;
    }

    @PostMapping
    ResponseEntity<ProducaoCorteeSoldaResponse> criarProducaoCorteSolda(@RequestBody ProducaoCorteeSoldaRequest request) {

        if (request != null) {

            service.criarProducaoCorteSolda(request);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }

        return ResponseEntity.badRequest().build();
    }

    @GetMapping
    ResponseEntity<ProducaoCorteeSoldaResponse> listarCorteSolda() {

        return ResponseEntity.ok((ProducaoCorteeSoldaResponse) service.listarProdutoCorteSolda());
    }

    @PutMapping("/{id}")
    ResponseEntity<ProducaoCorteeSoldaResponse> atualizarProducaoCorteSolda
            (@RequestParam int id, @RequestBody ProducaoCorteeSoldaRequest request) {

        if (request != null) {
            return ResponseEntity.ok(service.atualizarProducaoCorteSolda(id, request).orElseThrow(() -> new RuntimeException("Nao Localizado")));

        }
        return ResponseEntity.notFound().build();
    }
    @GetMapping("/{id}")
    ResponseEntity<ProducaoCorteeSoldaResponse> buscarPorid(@RequestParam int id){

        return  ResponseEntity.ok(service.buscarProducaoCorteSolda(id));
    }
    @DeleteMapping("/{id}")

    String deletarProducao (@RequestParam int id){

        ProducaoCorteeSoldaResponse producaoCorteeSoldaResponse = service.buscarProducaoCorteSolda(id);

        if (producaoCorteeSoldaResponse != null){

            return "Deletado";
        }
        return "Nao Localizado";

    }

}