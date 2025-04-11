package com.NPlastic.controllers;

import com.NPlastic.Dto.EnderecoDto.EnderecoRequest;
import com.NPlastic.Dto.EnderecoDto.EnderecoResponse;
import com.NPlastic.Entity.Endereco;
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
    public ResponseEntity<EnderecoResponse> criarEndereco(@RequestBody EnderecoRequest enderecoRequest){

        if(enderecoRequest != null){

            return ResponseEntity.ok().body(service.CriarEndereco(enderecoRequest));

        }else {
            return ResponseEntity.notFound().build();
        }

    }
    @PutMapping("/{id}")
    public ResponseEntity<EnderecoResponse> atualizarEnderco(@RequestBody EnderecoRequest enderecoRequest , @PathVariable int id) {

        enderecoRequest.setId(id);

        if (enderecoRequest != null) {

            return ResponseEntity.ok().body(service.atualizarEndereco(enderecoRequest));
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
