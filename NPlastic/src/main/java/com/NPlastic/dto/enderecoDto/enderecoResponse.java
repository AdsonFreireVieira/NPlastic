package com.NPlastic.dto.enderecoDto;

import com.NPlastic.Entity.Clientes;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter

public class enderecoResponse {

    private Integer Id;

    private String nomeRua;

    private int numero;

    private String cidade;

    private String cep;

    private String bairro;

    private Clientes clientes;
}
