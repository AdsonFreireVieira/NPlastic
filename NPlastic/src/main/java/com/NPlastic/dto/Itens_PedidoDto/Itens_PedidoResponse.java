package com.NPlastic.dto.Itens_PedidoDto;

import com.NPlastic.dto.PedidoDto.pedidoResponse;
import com.NPlastic.dto.produtoDto.produtoResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class Itens_PedidoResponse {

    private Integer Id;

    private int quantidade;

    private produtoResponse produtosResponse;

    private pedidoResponse pedidosResponse;

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

    public produtoResponse getProdutosResponse() {
        return produtosResponse;
    }

    public void setProdutosResponse(produtoResponse produtosResponse) {
        this.produtosResponse = produtosResponse;
    }

    public pedidoResponse getPedidosResponse() {
        return pedidosResponse;
    }

    public void setPedidosResponse(pedidoResponse pedidosResponse) {
        this.pedidosResponse = pedidosResponse;
    }
}
