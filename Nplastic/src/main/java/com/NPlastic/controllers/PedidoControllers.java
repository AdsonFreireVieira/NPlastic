package com.NPlastic.controllers;

import com.NPlastic.Dto.PedidoDto.PedidoRequest;
import com.NPlastic.Dto.PedidoDto.PedidoResponse;
import com.NPlastic.Entity.Pedido;
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

        PedidoResponse res = service.criarPedido(pedidoRequest);
        if (res != null){

            return  ResponseEntity.ok(res);
        }

        return ResponseEntity.notFound().build();
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
