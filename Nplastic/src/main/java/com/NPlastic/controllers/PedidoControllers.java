package com.NPlastic.controllers;

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
    public ResponseEntity<Pedido> criarPedido(@RequestBody Pedido pedido){

        Pedido res = service.criarPedido(pedido);
        if (res != null){

            return  ResponseEntity.ok(res);
        }

        return ResponseEntity.notFound().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Pedido> atualizarPedido(@RequestBody Pedido pedido,
                                                          @PathVariable int id){

        if(pedido != null){

            return ResponseEntity.ok().body(service.alterarPedido(pedido));
        }
        return  ResponseEntity.notFound().build();

    }
    @GetMapping
    public ResponseEntity<List<Pedido>> listarPedido(){

        return ResponseEntity.ok().body( service.listarPedido());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> buscarPorID( @PathVariable int id){

        return ResponseEntity.ok().body(service.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar( @PathVariable  int id){

        return  ResponseEntity.ok().body(service.deletarPedido(id));

    }


}
