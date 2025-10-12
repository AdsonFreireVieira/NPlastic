package com.NPlastic.entity;

import jakarta.persistence.*;

@Entity
public class Produtos {

    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    @Column
    private String nome;

    @Column
    private String medida;

    @Column
    private String cor;

    @Column
    private String unidades;

    @Column
    private String litros;


    @Column
    private double peso;

    @Column
    private String etiqueta;

    @Column
    private int quantidadePacote;

    @Column
    private double kiloTonelada;

    @Column
    private int quantidadeEntoque;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getQuantidadeEntoque() {
        return quantidadeEntoque;
    }

    public void setQuantidadeEntoque(int quantidadeEntoque) {
        this.quantidadeEntoque = quantidadeEntoque;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMedida() {
        return medida;
    }

    public void setMedida(String medida) {
        this.medida = medida;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getUnidades() {
        return unidades;
    }

    public void setUnidades(String unidades) {
        this.unidades = unidades;
    }

    public String getLitros() {
        return litros;
    }

    public void setLitros(String litros) {
        this.litros = litros;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    public int getQuantidadePacote() {
        return quantidadePacote;
    }

    public void setQuantidadePacote(int quantidadePacote) {
        this.quantidadePacote = quantidadePacote;
    }

    public double getKiloTonelada() {
        return kiloTonelada;
    }

    public void setKiloTonelada(double kiloTonelada) {
        this.kiloTonelada = kiloTonelada;
    }
}
