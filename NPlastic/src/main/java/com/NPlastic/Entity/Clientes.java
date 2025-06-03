package com.NPlastic.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor

@Table(name = "Clientes")
public class Clientes {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @Column
    private String nomeEmpresa;

    @Column
    private String email;

    @Column
    private String senha;

    @Column
    private Enum Role;
}
