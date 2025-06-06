package com.NPlastic.dto.produtoDto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class produtoResponse {


    private String nome;

    private String cor;

    private double peso;

    private String medida;

    private String validade;

}
