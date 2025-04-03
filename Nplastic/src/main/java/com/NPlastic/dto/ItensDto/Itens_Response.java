package com.NPlastic.dto.ItensDto;

import com.NPlastic.Entity.Pedido;
import com.NPlastic.Entity.Produto;
import com.NPlastic.dto.DtoPedido.PedidoResponse;
import com.NPlastic.dto.dtoProduto.ProdutoResponse;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class Itens_Response {

    private Integer id_Itens;

    private int quantidade;

    private  int totalItens;

    private double valorItens;

    private Pedido pedido;

    private Produto produto;

    public Produto getProduto() {
        return produto;
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

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}