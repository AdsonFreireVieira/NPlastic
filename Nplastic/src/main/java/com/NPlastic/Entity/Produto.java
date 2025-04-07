package com.NPlastic.Entity;

import jakarta.persistence.*;

import java.util.List;

@Table(name = "tbl_Produto")
@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id_Produto;

    @Column
    private String nome;

    @Column
    private String classificacao;

    @Column
    private int quantidade;

    @Column
    private String cor;

    @Column
    private Double peso;

    @Column
    private int estoque;

    @Column
    private double valorKg;

    public Integer getId_Produto() {
        return id_Produto;
    }

    public Produto() {
    }

    public void setId_Produto(Integer id_Produto) {
        this.id_Produto = id_Produto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public double getValorKg() {
        return valorKg;
    }

    public void setValorKg(double valorKg) {
        this.valorKg = valorKg;
    }

}
