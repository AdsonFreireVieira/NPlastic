package com.NPlastic.Entity;

import jakarta.persistence.*;

@Entity
@Table
public class Itens_Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column
    private int quantidade;

    @ManyToOne
    @JoinColumn(name ="produto_id")
    private Produto produto;

    @ManyToOne()
    @JoinColumn(name = "pedido")
    private Pedido pedido;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

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


}
