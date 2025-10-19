package com.NPlastic.dto.producaocortesolda;

import com.NPlastic.entity.Produtos;
import jakarta.persistence.Column;

public class ProducaoCorteeSoldaRequest {

    private Integer id;

    private Produtos produtos;

    private int quantidade;

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

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
