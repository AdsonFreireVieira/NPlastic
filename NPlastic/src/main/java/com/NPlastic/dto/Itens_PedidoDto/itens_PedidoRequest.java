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

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class itens_PedidoRequest {

    private Integer id;

    private int quantidade;

    private produtoRequest produtosRequest;

    private PedidoRequest pedidoRequest;

}

