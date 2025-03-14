package com.NPlastic.controllers;

import com.NPlastic.dto.dtoUser.ClientesRequestDTO;
import com.NPlastic.dto.dtoUser.ClientesResponseDTO;
import com.NPlastic.service.ServiceUser.ClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClientesControllers {

    @Autowired
    private ClientesService service;
    @PostMapping
    public ResponseEntity<ClientesResponseDTO> criarUser(@RequestBody ClientesRequestDTO clientesRequestDTO) {

        if (clientesRequestDTO != null) {

            ClientesResponseDTO userResponseDTO = service.criar(clientesRequestDTO);

            return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest()
                            .path("/{id}")
                            .buildAndExpand(clientesRequestDTO.getId())
                            .toUri())
                    .body(userResponseDTO);
    }
        return ResponseEntity.notFound().build();
}
        @PutMapping("/{id}")
        public ResponseEntity<ClientesResponseDTO> updateUSer (@RequestBody ClientesRequestDTO clientesRequestDTO,
        @PathVariable int id){

            clientesRequestDTO.setId(id);
            if (clientesRequestDTO != null) {

                return ResponseEntity.ok().body(service.update(clientesRequestDTO));
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



