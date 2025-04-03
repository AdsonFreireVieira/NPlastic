package com.NPlastic.service.ServicePedido;

import com.NPlastic.dto.DtoPedido.PedidoResponse;

import java.util.List;

public interface IPedidoService {

    public PedidoResponse criarPedido(PedidoResponse pedidoResponse);

    public PedidoResponse alterarPedido(PedidoResponse pedidoResponse);

    public List<PedidoResponse> listarPedido();

    public PedidoResponse buscarPorId(int id);

    public String deletarPedido(int id);
}
