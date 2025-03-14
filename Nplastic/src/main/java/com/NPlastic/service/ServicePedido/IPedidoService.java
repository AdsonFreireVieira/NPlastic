package com.NPlastic.service.ServicePedido;

import com.NPlastic.dto.DtoPedido.PedidoRequest;
import com.NPlastic.dto.DtoPedido.PedidoResponse;
import com.NPlastic.repository.PedidoRepository;

import java.util.List;

public interface IPedidoService {

    public PedidoResponse criarPedido(PedidoRequest pedidoRequest);

    public PedidoResponse alterarPedido(PedidoRequest pedidoRequest);

    public List<PedidoResponse> listarPedido();

    public PedidoResponse buscarPorId(int id);

    public String deletarPedido(int id);
}
