package com.NPlastic.dto.enderecoDto;

import com.NPlastic.Entity.Clientes;
import com.NPlastic.dto.clientesDto.clientesResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class enderecoResponse {

    private Integer id;
    private String nomeRua;

    private int numero;

    private String cidade;

    private String cep;

    private String bairro;
    private clientesResponse clienteResponse;

}