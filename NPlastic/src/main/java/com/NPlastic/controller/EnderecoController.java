package com.NPlastic.controller;


import com.NPlastic.dto.enderecoDto.enderecoRequest;
import com.NPlastic.dto.enderecoDto.enderecoResponse;
import com.NPlastic.services.EnderecoService.EnderecoServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class EnderecoController {

    private final EnderecoServiceImpl enderecoService;

    public EnderecoController(EnderecoServiceImpl enderecoService) {
        this.enderecoService = enderecoService;
    }

    @PostMapping
    public ResponseEntity<enderecoResponse> criarNovo(@RequestBody enderecoRequest enderecoRequest) {

        enderecoResponse response = enderecoService.novo(enderecoRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<enderecoResponse> alterar(@RequestBody enderecoRequest enderecoRequest
            , @PathVariable Integer id) {

        return enderecoService.atualizar(id, enderecoRequest).map(ResponseEntity::ok).
                orElseGet(() -> ResponseEntity.status(HttpStatus.BAD_REQUEST).build());

    }
    @GetMapping("/{id}")
    public ResponseEntity<enderecoResponse> buscarPorId(@PathVariable  int id){

        return  enderecoService.buscarPorId(id).map(ResponseEntity::ok)
                .orElseGet(()-> ResponseEntity.status(HttpStatus.BAD_REQUEST).build());


    }
    @GetMapping
    public ResponseEntity  <List<enderecoResponse>> listarEndereco(){

        return ResponseEntity.status(HttpStatus.OK).body(enderecoService.listarEndereco());
    }
 @DeleteMapping("/{id}")
   public   ResponseEntity<?>  deletar(int id){

        enderecoService.deletar(id);
        return  ResponseEntity.status(HttpStatus.OK).build();

   }
}
