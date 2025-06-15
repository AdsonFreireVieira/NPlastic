package com.NPlastic.controller;

import com.NPlastic.dto.clientesDto.clientesRequest;
import com.NPlastic.dto.clientesDto.clientesResponse;
import com.NPlastic.services.clienteService.clienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClientesController {
    @Autowired
    private  clienteServiceImpl clienteService;

    @PostMapping
    public ResponseEntity<clientesResponse> criarNovo(@RequestBody clientesRequest clientes) {
        return ResponseEntity.ok(clienteService.novoCliente(clientes));
    }

    @PutMapping("/{id}")
    public ResponseEntity<clientesResponse> alterarCliente(@RequestBody clientesRequest clientes, @PathVariable int id) {
        return ResponseEntity.ok(clienteService.alterarCliente(clientes));
    }

    @GetMapping("/{id}")
    public ResponseEntity<clientesResponse> buscarporId(@PathVariable int id) {

        return ResponseEntity.ok().body(clienteService.buscarPorId(id));

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
