package com.NPlastic.dto.producaoextrusao;

import com.NPlastic.entity.Produtos;
import jakarta.persistence.Column;

public class ProducaoExtrusaoResponse {
    private Integer id;


    private Produtos produtos;


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
