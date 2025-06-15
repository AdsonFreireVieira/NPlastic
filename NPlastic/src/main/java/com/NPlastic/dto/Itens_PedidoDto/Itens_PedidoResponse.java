package com.NPlastic.dto.Itens_PedidoDto;

import com.NPlastic.Entity.Pedido;
import com.NPlastic.Entity.Produto;

public class Itens_PedidoResponse {

    private Integer Id;

    private int quantidade;

    private Produto produto;

    private Pedido pedido;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
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
