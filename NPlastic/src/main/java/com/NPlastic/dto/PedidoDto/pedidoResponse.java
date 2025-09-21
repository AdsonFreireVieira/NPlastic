package com.NPlastic.dto.PedidoDto;

import com.NPlastic.Entity.Clientes;
import com.NPlastic.Entity.Itens_Pedido;
import com.NPlastic.dto.Itens_PedidoDto.Itens_PedidoResponse;
import com.NPlastic.dto.clientesDto.clientesResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class pedidoResponse {

    private Integer id;

    private Date data;

    private double valorTotal;

    private int quantidadeItensTotal;

    private List<Itens_PedidoResponse> itensResponse;

    private clientesResponse clienteResponse;

}