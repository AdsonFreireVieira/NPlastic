package com.NPlastic.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@NoArgsConstructor

@Entity
@Table
public class Itens_Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer Id;


    @Column
    private int quantidade;

    @Column
    private Produto produto;

    @ManyToOne()
    @JoinColumn(name = "pedido")
    private Pedido pedido;

}
