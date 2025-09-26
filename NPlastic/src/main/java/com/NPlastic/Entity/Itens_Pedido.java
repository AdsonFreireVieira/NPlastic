package com.NPlastic.Entity;

import com.NPlastic.dto.produtoDto.produtoRequest;
import com.fasterxml.jackson.annotation.JsonBackReference;
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
    private produtoRequest produtoRequest;

    @ManyToOne
    @JoinColumn(name = "pedido")
    @JsonBackReference
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

    public produtoRequest getProdutoRequest() {
        return produtoRequest;
    }

    public void setProdutoRequest(produtoRequest produtoRequest) {
        this.produtoRequest = produtoRequest;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }


}
