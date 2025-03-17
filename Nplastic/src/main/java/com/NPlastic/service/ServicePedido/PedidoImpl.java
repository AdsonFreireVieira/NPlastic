package com.NPlastic.service.ServicePedido;

import com.NPlastic.Entity.Itens_Pedido;
import com.NPlastic.Entity.Pedido;
import com.NPlastic.dto.DtoPedido.PedidoRequest;
import com.NPlastic.dto.DtoPedido.PedidoResponse;
import com.NPlastic.mapper.PedidoMapper;
import com.NPlastic.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class PedidoImpl implements  IPedidoService{

    @Autowired
    PedidoRepository pedidoRepository;
    @Override
    public PedidoResponse criarPedido(PedidoRequest pedidoRequest) {


        Pedido pedido = PedidoMapper.INSTANCE.convertToPedido(pedidoRequest);

        for(Itens_Pedido itens : pedido.getItens()){

            itens.setPedido(pedido);
        }
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

        return PedidoMapper.INSTANCE.convertToPedidoResponse(pedidoRepository.findById(id).orElse(null));
    }

    @Override
    public String deletarPedido(int id) {
        return "REMOVIDO";
    }
}
