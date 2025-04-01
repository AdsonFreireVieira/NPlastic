package com.NPlastic.controllers;

import com.NPlastic.dto.DtoPedido.PedidoRequest;
import com.NPlastic.dto.DtoPedido.PedidoResponse;
import com.NPlastic.service.ServicePedido.PedidoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoControllers {

    @Autowired
    private PedidoImpl service;


    @PostMapping
    public ResponseEntity<PedidoResponse> criarPedido(@RequestBody PedidoRequest pedidoRequest){



        return ResponseEntity.ok().body(service.criarPedido(pedidoRequest));
    }
    @PutMapping("/{id}")
    public ResponseEntity<PedidoResponse> atualizarPedido(@RequestBody PedidoRequest pedidoRequest,
                                                          @PathVariable int id){

        if(pedidoRequest != null){

            return ResponseEntity.ok().body(service.alterarPedido(pedidoRequest));
        }
        return  ResponseEntity.notFound().build();

    }
    @GetMapping
    public ResponseEntity<List<PedidoResponse>> listarPedido(){

        return ResponseEntity.ok().body( service.listarPedido());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoResponse> buscarPorID( @PathVariable int id){

        return ResponseEntity.ok().body(service.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar( @PathVariable  int id){

        return  ResponseEntity.ok().body(service.deletarPedido(id));

    }


}
