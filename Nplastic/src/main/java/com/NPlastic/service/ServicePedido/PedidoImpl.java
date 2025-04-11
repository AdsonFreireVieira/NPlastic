package com.NPlastic.service.ServicePedido;

import com.NPlastic.Dto.PedidoDto.PedidoRequest;
import com.NPlastic.Dto.PedidoDto.PedidoResponse;
import com.NPlastic.Entity.Itens_Pedido;
import com.NPlastic.Entity.Pedido;
import com.NPlastic.Mappers.PedidoMapper;
import com.NPlastic.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PedidoImpl implements  IPedidoService{

    @Autowired
    PedidoRepository pedidoRepository;

    @Override
    public PedidoResponse criarPedido(PedidoRequest pedidoRequest) {

        Pedido pedido = PedidoMapper.INSTANCE.toEntity(pedidoRequest);

        for(Itens_Pedido item : pedidoRequest.getItens()){

            item.setPedido(pedido);
        }

        return PedidoMapper.INSTANCE.toDto(pedidoRepository.save(pedido));

    }

    @Override
    public PedidoResponse alterarPedido(PedidoRequest pedidoRequest) {

        Pedido pedido = PedidoMapper.INSTANCE.toEntity(pedidoRequest);

        for(Itens_Pedido item : pedidoRequest.getItens()){

            item.setPedido(pedido);
        }

        return PedidoMapper.INSTANCE.toDto(pedidoRepository.save(pedido));

    }

    @Override
    public List<PedidoResponse> listarPedido() {
        return  PedidoMapper.INSTANCE.convertListDto((List < Pedido >) pedidoRepository.findAll());
    }

    @Override
    public PedidoResponse buscarPorId(int id) {

        return PedidoMapper.INSTANCE.toDto(pedidoRepository.findById(id).orElse(null));
    }

    @Override
    public String deletarPedido(int id) {

        return "REMOVIDO";
    }
}
