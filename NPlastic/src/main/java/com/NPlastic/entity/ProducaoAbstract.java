package com.NPlastic.entity;

public  abstract class ProducaoAbstract {

   private String medida;

   private Double peso;

   private String cor;

    public ProducaoAbstract(String medida, Double peso, String cor) {
        this.medida = medida;
        this.peso = peso;
        this.cor = cor;
    }

    public String getMedida() {
        return medida;
    }

    public void setMedida(String medida) {
        this.medida = medida;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }
}
