package com.NPlastic.service.ServicePedido;

import com.NPlastic.Dto.PedidoDto.PedidoRequest;
import com.NPlastic.Dto.PedidoDto.PedidoResponse;
import com.NPlastic.Entity.Pedido;

import java.util.List;

public interface IPedidoService {

    public PedidoResponse criarPedido(PedidoRequest pedidoRequest);

    public PedidoResponse alterarPedido(PedidoRequest pedidoRequest);

    public List<PedidoResponse> listarPedido();

    public PedidoResponse buscarPorId(int id);

    public String deletarPedido(int id);
}
