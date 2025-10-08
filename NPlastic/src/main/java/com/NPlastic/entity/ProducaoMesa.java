package com.NPlastic.entity;

public class ProducaoMesa extends  ProducaoAbstract {
    private int id;
    private String etiqueta;
    private Double pesoBalanca;

    public ProducaoMesa(String medida, Double peso, String cor, String etiqueta, Double pesoBalanca) {
        super(medida, peso, cor);
        this.id = id;
        this.etiqueta = etiqueta;
        this.pesoBalanca = pesoBalanca;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    public Double getPesoBalanca() {
        return pesoBalanca;
    }

    public void setPesoBalanca(Double pesoBalanca) {
        this.pesoBalanca = pesoBalanca;
    }
}
