package com.NPlastic.dto.PedidoDto;

import com.NPlastic.Entity.Clientes;
import com.NPlastic.Entity.Itens_Pedido;
import com.NPlastic.Entity.Pedido;
import com.NPlastic.dto.Itens_PedidoDto.itens_PedidoRequest;
import com.NPlastic.dto.clientesDto.clientesRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class PedidoRequest {

    private Integer Id;

    private Date data;

    private double valorTotal;

    private int quantidadeItensTotal;

    private List<itens_PedidoRequest> itensPedidoRequests;

    private clientesRequest clientesRequest;
}