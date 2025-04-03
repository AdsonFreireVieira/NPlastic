package com.NPlastic.service.ServicePedido;

import com.NPlastic.Entity.Pedido;

import java.util.List;

public interface IPedidoService {

    public Pedido criarPedido(Pedido pedido);

    public Pedido alterarPedido(Pedido pedido);

    public List<Pedido> listarPedido();

    public Pedido buscarPorId(int id);

    public String deletarPedido(int id);
}
