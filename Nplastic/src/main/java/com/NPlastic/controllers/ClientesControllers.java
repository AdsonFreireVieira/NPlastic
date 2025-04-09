package com.NPlastic.controllers;

import com.NPlastic.Dto.ClientesDto.ClientesRequest;
import com.NPlastic.Dto.ClientesDto.ClientesResponse;
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
    public ResponseEntity<ClientesResponse> criarUser(@RequestBody ClientesRequest clientesRequest) {

        if (clientesRequest != null) {

           return ResponseEntity.ok(service.criar(clientesRequest));

        }
        return ResponseEntity.notFound().build();
}
        @PutMapping("/{id}")
        public ResponseEntity<ClientesResponse> updateUSer (@RequestBody ClientesRequest clientesRequest,
        @PathVariable int id){

          clientesRequest.setId(id);
            if (clientesRequest != null) {

                return ResponseEntity.ok().body(service.update(clientesRequest));
            }

            return ResponseEntity.notFound().build();
        }
        @GetMapping
        public ResponseEntity<List<ClientesResponse>> listarTodos() {

            return ResponseEntity.ok().body(service.ListarUser());
        }

        @GetMapping("/{id}")
        public ResponseEntity<ClientesResponse> buscarPorId (@PathVariable int id){

            return ResponseEntity.ok().body(service.BuscarPorID(id));
        }
        @DeleteMapping("/{id}")
        public void DeletarUSer ( @PathVariable int id){
            service.deletarUser(id);



    }
}



