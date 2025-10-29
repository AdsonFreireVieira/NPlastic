package com.NPlastic.dto.estoquedto;

import com.NPlastic.entity.Produtos;

public class EstoqueRequest {

    private Integer id;

    private Produtos produto;

    private  int quantidade;

    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public Produtos getProduto() {
        return produto;
    }

    public void setProduto(Produtos produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public EstoqueRequest() {
    }
}
