package com.NPlastic.controllers;

import com.NPlastic.dto.dtoEndereco.EnderecoResponse;
import com.NPlastic.service.ServiceEndereco.ServiceEnderecoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/enderecos")
public class EnderecoControllers {

    @Autowired
    private ServiceEnderecoImpl service;

    @PostMapping
    public ResponseEntity<EnderecoResponse> criarEndereco(@RequestBody EnderecoResponse enderecoResponse){

        if(enderecoResponse != null){
                            service.CriarEndereco(enderecoResponse);

            return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}").buildAndExpand(enderecoResponse.getId()).toUri()).body(enderecoResponse);

        }else {
            return ResponseEntity.notFound().build();
        }

    }
    @PutMapping("/{id}")
    public ResponseEntity<EnderecoResponse> atualizarEnderco(@RequestBody EnderecoResponse enderecoResponse , @PathVariable int id) {

        enderecoResponse.setId(id);

        if (enderecoResponse != null) {

            return ResponseEntity.ok().body(service.atualizarEndereco(enderecoResponse));
        } else {

            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping
    public ResponseEntity <List<EnderecoResponse>> listarEndereco(){

        return ResponseEntity.ok().body(service.listarEndereco());

        }

     @GetMapping("/{id}")
    public ResponseEntity<EnderecoResponse> buscarPorId(@PathVariable int id){

        return ResponseEntity.ok().body(service.BuscarPorId(id));
     }

     @DeleteMapping("/{id}")
    public void deletar(@PathVariable int id){
        service.deletarEndereco(id);
     }


}
