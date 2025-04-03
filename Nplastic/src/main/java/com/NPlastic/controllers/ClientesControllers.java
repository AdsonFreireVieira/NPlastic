package com.NPlastic.controllers;

import com.NPlastic.Entity.Clientes;
import com.NPlastic.service.ServiceUser.ClienteServiceEmpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClientesControllers {

    @Autowired
    private ClienteServiceEmpl service;

    @PostMapping
    public ResponseEntity<Clientes> criarUser(@RequestBody Clientes clientes) {

        if (clientes != null) {

            service.criar(clientes);

        }
        return ResponseEntity.notFound().build();
}
        @PutMapping("/{id}")
        public ResponseEntity<Clientes> updateUSer (@RequestBody Clientes clientes,
        @PathVariable int id){

          clientes.setId(id);
            if (clientes != null) {

                return ResponseEntity.ok().body(service.update(clientes));
            }

            return ResponseEntity.notFound().build();
        }
        @GetMapping
        public ResponseEntity<List<Clientes>> listarTodos() {

            return ResponseEntity.ok().body(service.ListarUser());
        }

        @GetMapping("/{id}")
        public ResponseEntity<Clientes> buscarPorId (@PathVariable int id){

            return ResponseEntity.ok().body(service.BuscarPorID(id));
        }
        @DeleteMapping("/{id}")
        public void DeletarUSer ( @PathVariable int id){
            service.deletarUser(id);



    }
}



