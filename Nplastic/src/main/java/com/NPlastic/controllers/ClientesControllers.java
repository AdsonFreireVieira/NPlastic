package com.NPlastic.controllers;

import com.NPlastic.dto.dtoUser.ClientesResponseDTO;
import com.NPlastic.service.ServiceUser.ClienteServiceEmpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClientesControllers {

    @Autowired
    private ClienteServiceEmpl service;

    @PostMapping
    public ResponseEntity<ClientesResponseDTO> criarUser(@RequestBody ClientesResponseDTO clientesResponseDTO) {

        if (clientesResponseDTO != null) {

            ClientesResponseDTO userResponseDTO = service.criar(clientesResponseDTO);

            return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest()
                            .path("/{id}")
                            .buildAndExpand(clientesResponseDTO.getId())
                            .toUri())
                    .body(userResponseDTO);
    }
        return ResponseEntity.notFound().build();
}
        @PutMapping("/{id}")
        public ResponseEntity<ClientesResponseDTO> updateUSer (@RequestBody ClientesResponseDTO clientesResponseDTO,
        @PathVariable int id){

            clientesResponseDTO.setId(id);
            if (clientesResponseDTO != null) {

                return ResponseEntity.ok().body(service.update(clientesResponseDTO));
            }

            return ResponseEntity.notFound().build();
        }
        @GetMapping
        public ResponseEntity<List<ClientesResponseDTO>> listarTodos() {

            return ResponseEntity.ok().body(service.ListarUser());
        }

        @GetMapping("/{id}")
        public ResponseEntity<ClientesResponseDTO> buscarPorId (@PathVariable int id){

            return ResponseEntity.ok().body(service.BuscarPorID(id));
        }
        @DeleteMapping("/{id}")
        public void DeletarUSer ( @PathVariable int id){
            service.deletarUser(id);



    }
}



