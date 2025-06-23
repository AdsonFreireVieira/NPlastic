package com.NPlastic.services.pedidoService;

import com.NPlastic.Entity.Itens_Pedido;
import com.NPlastic.Entity.Pedido;
import com.NPlastic.dto.PedidoDto.pedidoRequest;
import com.NPlastic.dto.PedidoDto.pedidoResponse;
import com.NPlastic.mappers.PedidoMappers;
import com.NPlastic.repository.PedidoRepository;

import java.util.Optional;

public class pedidoServiceImpl implements  pedidoService{

    private final PedidoRepository pedidoRepository;
    private final PedidoMappers  pedidoMappers;


    public pedidoServiceImpl(PedidoRepository pedidoRepository, PedidoMappers pedidoMappers) {
        this.pedidoRepository = pedidoRepository;
        this.pedidoMappers = pedidoMappers;
    }


    @Override
    public pedidoResponse cadastrarNovo(pedidoRequest request) {

        Pedido pedido  = pedidoMappers.toEntity(request);

        for (Itens_Pedido itens : pedido.getItens()){

            itens.setPedido(pedido);
        }

        return pedidoMappers.toDTo(pedido);
    }


    @Override
    public pedidoResponse alterarPedido(pedidoRequest request) {

        Pedido pedido = pedidoMappers.toEntity(request);

        return pedidoMappers.toDTo(pedidoRepository.save(pedido));
    }

    @Override
    public Optional<pedidoResponse> buscarPedidoPorId(Integer id) {

        return pedidoRepository.findById(id).map(pedidoMappers::toDTo);
    }
}
