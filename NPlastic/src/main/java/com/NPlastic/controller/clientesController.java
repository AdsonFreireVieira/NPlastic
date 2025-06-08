package com.NPlastic.controller;

import com.NPlastic.Entity.Clientes;
import com.NPlastic.dto.clientesDto.clientesRequest;
import com.NPlastic.dto.clientesDto.clientesResponse;
import com.NPlastic.services.clienteService.clienteServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static jdk.internal.org.jline.reader.impl.LineReaderImpl.CompletionType.List;

@RestController
@RequestMapping("/clientes")
public class clientesController {

    private final clienteServiceImpl clienteService;

    public clientesController(clienteServiceImpl clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public ResponseEntity<clientesResponse> criarNovo(@RequestBody clientesRequest clientesRequest){

        if( clientesRequest != null){

            return  ResponseEntity.ok().body(clienteService.novoCliente(clientesRequest));
        }
        return  ResponseEntity.notFound().build();


    }
    @PutMapping
    public ResponseEntity<clientesResponse> alterarCliente(@RequestBody clientesRequest clientesRequest , @PathVariable int id ){

        clientesRequest.setId(id);

        if(clientesRequest != null){

            return  ResponseEntity.ok().body(clienteService.alterarCliente(clientesRequest));

        }

        return  ResponseEntity.notFound().build();

    }

    @GetMapping("/{id}")
    public Optional<clientesResponse> buscarporId(int id){

        return ResponseEntity.ok().body(clienteService.buscarPorId(id)).getBody();

    }

    @GetMapping
    public ResponseEntity<clientesResponse> listarClientes(){

        return  ResponseEntity.ok().body((clientesResponse) clienteService.listarClientes());
    }

    @DeleteMapping("/{id}")
    public void deletarCliente(int id){

        clienteService.deletarCliente(id);

    }

}




