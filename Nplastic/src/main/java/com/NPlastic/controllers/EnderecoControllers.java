package com.NPlastic.controllers;

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
    public ResponseEntity<Endereco> criarEndereco(@RequestBody Endereco endereco){

        if(endereco != null){
                            service.CriarEndereco(endereco);

            return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}").buildAndExpand(endereco.getId()).toUri()).body(endereco);

        }else {
            return ResponseEntity.notFound().build();
        }

    }
    @PutMapping("/{id}")
    public ResponseEntity<Endereco> atualizarEnderco(@RequestBody Endereco endereco , @PathVariable int id) {

        endereco.setId(id);

        if (endereco != null) {

            return ResponseEntity.ok().body(service.atualizarEndereco(endereco));
        } else {

            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping
    public ResponseEntity <List<Endereco>> listarEndereco(){

        return ResponseEntity.ok().body(service.listarEndereco());

        }

     @GetMapping("/{id}")
    public ResponseEntity<Endereco> buscarPorId(@PathVariable int id){

        return ResponseEntity.ok().body(service.BuscarPorId(id));
     }

     @DeleteMapping("/{id}")
    public void deletar(@PathVariable int id){
        service.deletarEndereco(id);
     }


}
