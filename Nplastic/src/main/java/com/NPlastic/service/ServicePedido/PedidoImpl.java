package com.NPlastic.service.ServicePedido;

import com.NPlastic.Entity.Pedido;
import com.NPlastic.dto.DtoPedido.PedidoRequest;
import com.NPlastic.dto.DtoPedido.PedidoResponse;
import com.NPlastic.mapper.PedidoMapper;
import com.NPlastic.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PedidoImpl implements  IPedidoService{

    @Autowired
    PedidoRepository pedidoRepository;
    @Override
    public PedidoResponse criarPedido(PedidoRequest pedidoRequest) {


        Pedido pedido = PedidoMapper.INSTANCE.convertToPedido(pedidoRequest);

         pedidoRepository.save(pedido);

        return PedidoMapper.INSTANCE.convertToPedidoResponse(pedido);
    }

    @Override
    public PedidoResponse alterarPedido(PedidoRequest pedidoRequest) {

        Pedido pedido = PedidoMapper.INSTANCE.convertToPedido(pedidoRequest);

        return PedidoMapper.INSTANCE.convertToPedidoResponse(pedidoRepository.save(pedido));
    }

    @Override
    public List<PedidoResponse> listarPedido() {
        return PedidoMapper.INSTANCE.ConvertListResponse((List<Pedido>) pedidoRepository.findAll());
    }

    @Override
    public PedidoResponse buscarPorId(int id) {
        return null;
    }

    @Override
    public PedidoResponse deletarPedido(int id) {
        return null;
    }
}
