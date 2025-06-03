package com.NPlastic.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor

@Entity
@Table
public class Endereco {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    @Id

    private Integer Id;

    @Column
    private String nomeRua;

    @Column
    private int numero;

    @Column
    private String cidade;

    @Column
    private String cep;
    
    @Column
    private String bairro;
}
