package com.NPlastic.dto.dtoProduto;

public class ProdutoResponse {

    private Integer id_Produto;

    private String nome;

    private String classificacao;

    private int quantidade;

    private String cor;

    private Double peso;

    private int estoque;

    private double valorKg;

    public Integer getId_Produto() {
        return id_Produto;
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

    public double getValorKg() {
        return valorKg;
    }

    public void setValorKg(double valorKg) {
        this.valorKg = valorKg;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }


    public ProdutoResponse() {
    }
}
