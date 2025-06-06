package com.NPlastic.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer Id;

    @Column
    private Date data;

    @Column
    private double valorTotal;

    @Column
    private int quantidadeItensTotal;

    @OneToMany(mappedBy ="pedido", cascade = CascadeType.ALL)
    private List<Itens_Pedido> itens;

    @ManyToOne
    private Clientes clientes;


}
