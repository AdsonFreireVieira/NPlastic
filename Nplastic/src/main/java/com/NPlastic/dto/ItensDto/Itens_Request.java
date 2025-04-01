package com.NPlastic.dto.ItensDto;
import com.NPlastic.dto.DtoPedido.PedidoRequest;
import com.NPlastic.dto.dtoProduto.ProdutoRequest;

public class Itens_Request {

    private Integer id_Itens;

    private int quantidade;

    private  int totalItens;

    private double valorItens;

    private  ProdutoRequest produtoRequest;

    private PedidoRequest pedidoRequest;

    public Itens_Request() {
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

    public ProdutoRequest getProdutoRequest() {
        return produtoRequest;
    }

    public PedidoRequest getPedidoRequest() {
        return pedidoRequest;
    }

    public void setPedidoRequest(PedidoRequest pedidoRequest) {
        this.pedidoRequest = pedidoRequest;
    }

    public void setProdutoRequest(ProdutoRequest produtoRequest) {
        this.produtoRequest = produtoRequest;
    }
}
