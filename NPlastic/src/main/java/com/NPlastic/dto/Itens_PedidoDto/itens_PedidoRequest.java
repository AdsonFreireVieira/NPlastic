package com.NPlastic.dto.Itens_PedidoDto;

import com.NPlastic.Entity.Pedido;
import com.NPlastic.Entity.Produto;
import com.NPlastic.dto.PedidoDto.PedidoRequest;
import com.NPlastic.dto.produtoDto.produtoRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.service.annotation.GetExchange;

public class itens_PedidoRequest {

    private Integer id;

    private int quantidade;

    private produtoRequest produtosRequest;

    private PedidoRequest pedidoRequest;

    public itens_PedidoRequest() {
    }

    public itens_PedidoRequest(Integer id, int quantidade, produtoRequest produtosRequest, PedidoRequest pedidoRequest) {
        this.id = id;
        this.quantidade = quantidade;
        this.produtosRequest = produtosRequest;
        this.pedidoRequest = pedidoRequest;
    }

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

    public produtoRequest getProdutosRequest() {
        return produtosRequest;
    }

    public void setProdutosRequest(produtoRequest produtosRequest) {
        this.produtosRequest = produtosRequest;
    }

    public PedidoRequest getPedidoRequest() {
        return pedidoRequest;
    }

    public void setPedidoRequest(PedidoRequest pedidoRequest) {
        this.pedidoRequest = pedidoRequest;
    }
}

