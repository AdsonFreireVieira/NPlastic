package com.NPlastic.entity;

import jakarta.persistence.*;

@Entity
public class ProducaoExtrusao {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private Produtos produtos;

    @Column
    private double Kilograma;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Produtos getProdutos() {
        return produtos;
    }

    public void setProdutos(Produtos produtos) {
        this.produtos = produtos;
    }

    public double getKilograma() {
        return Kilograma;
    }

    public void setKilograma(double kilograma) {
        Kilograma = kilograma;
    }
}
