package com.NPlastic.Entity;

import jakarta.persistence.*;

import java.util.List;
@Entity
@Table(name = "tbl_Itens")
public class Itens_Pedido {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column
    private Integer id_Itens;

    @Column
    private int quantidade;

    @Column
    private  int totalItens;

    @Column
    private double valorItens;

   @ManyToOne(cascade = CascadeType.ALL)
   @JoinColumn(name ="id_Produto")
   private Produto produto;

   @ManyToOne(cascade = CascadeType.ALL)
   @JoinColumn(name = "Pedido")
   private Pedido pedido;

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Integer getId_Itens() {
        return id_Itens;
    }

    public void setId_Itens(Integer id_Itens) {
        this.id_Itens = id_Itens;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getTotalItens() {
        return totalItens;
    }

    public void setTotalItens(int totalItens) {
        this.totalItens = totalItens;
    }

    public double getValorItens() {
        return valorItens;
    }

    public void setValorItens(double valorItens) {
        this.valorItens = valorItens;
    }
}
