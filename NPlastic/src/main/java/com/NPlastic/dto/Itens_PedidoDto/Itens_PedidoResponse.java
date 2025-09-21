package com.NPlastic.dto.Itens_PedidoDto;

import com.NPlastic.Entity.Pedido;
import com.NPlastic.Entity.Produto;
import com.NPlastic.dto.PedidoDto.pedidoResponse;
import com.NPlastic.dto.produtoDto.produtoResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Itens_PedidoResponse {

    private Integer Id;

    private int quantidade;

    private produtoResponse produtosResponse;

    private pedidoResponse pedidosResponse;


}
