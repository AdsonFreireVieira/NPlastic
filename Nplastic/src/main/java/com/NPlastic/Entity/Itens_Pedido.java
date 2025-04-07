package com.NPlastic.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

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
    private double valorItens;

    @ManyToOne()
    @JoinColumn( name = "pedido_id")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name ="produto_id")
    @JsonIgnoreProperties("itens")
    private Produto produto;

    public Produto getProduto() {
        return produto;

        }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Produto getProdutoResponse() {
        return produto;
    }

    public void setProdutoResponse(Produto produto) {
        this.produto = produto;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedidoResponse) {
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

    public double getValorItens() {
        return valorItens;
    }

    public void setValorItens(double valorItens) {
        this.valorItens = valorItens;
    }
}
