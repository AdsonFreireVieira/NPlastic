package com.NPlastic.services.pedidoService;

import com.NPlastic.dto.PedidoDto.pedidoRequest;
import com.NPlastic.dto.PedidoDto.pedidoResponse;

public interface pedidoService {

    public pedidoResponse cadastrarNovo(pedidoRequest request);

    public pedidoResponse alterarPedido(pedidoRequest request);

    public pedidoResponse buscarPedidoPorId(Integer id);






}
