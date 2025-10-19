package com.NPlastic.dto.estoquedto;

import com.NPlastic.entity.Produtos;
import jakarta.persistence.Column;

public class EstoqueResponse {

    private Integer id;


    private Produtos produto;

    private  int quantidade;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public EstoqueResponse() {
    }
}
