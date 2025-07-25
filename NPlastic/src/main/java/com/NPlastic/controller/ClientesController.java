package com.NPlastic.controller;

import com.NPlastic.Exception.ClienteException;
import com.NPlastic.dto.clientesDto.clientesRequest;
import com.NPlastic.dto.clientesDto.clientesResponse;
import com.NPlastic.services.clienteService.clienteServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClientesController {
    private final clienteServiceImpl clienteService;

    public ClientesController(clienteServiceImpl clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public ResponseEntity<clientesResponse> criarNovo(@RequestBody clientesRequest clientes) {

        clientesResponse clientesResponse = clienteService.novoCliente(clientes);

        return  ResponseEntity.status(HttpStatus.CREATED).body(clientesResponse);

    }

    @PutMapping("/{id}")
    public ResponseEntity<clientesResponse> alterarCliente(@RequestBody clientesRequest clientes, @PathVariable int id) {

        return  clienteService.alterarCliente(clientes,id )
                .map(ResponseEntity::ok).orElseThrow(()-> new ClienteException(" Erro ALteracao "));


    }

    @GetMapping("/{id}")
    public ResponseEntity<clientesResponse> buscarporId(@PathVariable int id) {

        Optional<clientesResponse> response = clienteService.buscarPorId(id);

        return response.map(clientes -> new ResponseEntity<>(clientes, HttpStatus.OK))
                .orElseThrow(() -> new ClienteException("Cliente Nao Encontrado "));
    }
    @GetMapping
    public ResponseEntity<List<clientesResponse>> listarClientes() {
        return ResponseEntity.ok(clienteService.listarClientes());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCliente(@PathVariable int id) {
        clienteService.deletarCliente(id);
        return ResponseEntity.noContent().build();
    }
}
