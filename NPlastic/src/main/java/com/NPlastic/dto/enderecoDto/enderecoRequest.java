package com.NPlastic.dto.enderecoDto;

import com.NPlastic.Entity.Clientes;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class enderecoRequest {

    private Integer Id;

    private String nomeRua;

    private int numero;

    private String cidade;

    private String cep;

    private String bairro;

    private Clientes clientes;
}
