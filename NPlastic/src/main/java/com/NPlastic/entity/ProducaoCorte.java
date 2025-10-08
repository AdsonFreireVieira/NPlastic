package com.NPlastic.entity;

public class ProducaoCorte extends  ProducaoAbstract {

    private int id;

     private int quantidade;

    public ProducaoCorte(String medida, Double peso, String cor,  int quantidade) {
        super(medida, peso, cor);
        this.quantidade = quantidade;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
