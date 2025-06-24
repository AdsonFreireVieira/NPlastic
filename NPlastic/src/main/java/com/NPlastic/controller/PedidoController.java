package com.NPlastic.controller;

import com.NPlastic.dto.PedidoDto.PedidoRequest;
import com.NPlastic.dto.PedidoDto.pedidoResponse;
import com.NPlastic.repository.PedidoRepository;
import com.NPlastic.services.pedidoService.pedidoServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class PedidoController {

    private final pedidoServiceImpl pedidoService;

    public PedidoController(pedidoServiceImpl pedidoService) {
        this.pedidoService = pedidoService;
    }


    @PostMapping
    public ResponseEntity<pedidoResponse> cadastrarNovo(@RequestBody PedidoRequest pedidoRequest){

        pedidoResponse response =pedidoService.cadastrarNovo(pedidoRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }
    @PutMapping("/{id}")
    public ResponseEntity<pedidoResponse> alterar(@RequestBody PedidoRequest pedidoRequest , @PathVariable int id){

        pedidoResponse pedidoResponse = pedidoService.alterarPedido(pedidoRequest,id);

        return ResponseEntity.status(HttpStatus.OK).body(pedidoResponse);
    }
    @GetMapping("{id}")
    public ResponseEntity<pedidoResponse>buscarPorId(@PathVariable int id){

       return ResponseEntity.status(HttpStatus.OK).body(pedidoService.buscarPedidoPorId(id).
               orElseThrow(()-> new RuntimeException(" Nao Encontrado")));

    }

    @GetMapping
    public ResponseEntity <List<pedidoResponse>> listarPedido(){

        return ResponseEntity.status(HttpStatus.OK).body(pedidoService.listarPedido());
    }
}
