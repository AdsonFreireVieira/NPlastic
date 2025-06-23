package com.NPlastic.services.pedidoService;

import com.NPlastic.dto.PedidoDto.pedidoRequest;
import com.NPlastic.dto.PedidoDto.pedidoResponse;

import java.util.Optional;

public interface pedidoService {

    public pedidoResponse cadastrarNovo(pedidoRequest request);

    public pedidoResponse alterarPedido(pedidoRequest request);

    public Optional<pedidoResponse> buscarPedidoPorId(Integer id);






}
