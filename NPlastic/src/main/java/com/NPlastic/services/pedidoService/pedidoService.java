package com.NPlastic.services.pedidoService;

import com.NPlastic.Entity.Pedido;
import com.NPlastic.dto.PedidoDto.PedidoRequest;

import com.NPlastic.dto.PedidoDto.pedidoResponse;

import java.util.List;
import java.util.Optional;

public interface pedidoService {

    public pedidoResponse cadastrarNovo(PedidoRequest request);

    public pedidoResponse alterarPedido(PedidoRequest request , int id);

    public Optional<pedidoResponse> buscarPedidoPorId(Integer id);

     public List<pedidoResponse> listarPedido();




}
