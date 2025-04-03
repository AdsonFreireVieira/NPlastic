package com.NPlastic.service.ServicePedido;

import com.NPlastic.Entity.Itens_Pedido;
import com.NPlastic.Entity.Pedido;
import com.NPlastic.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PedidoImpl implements  IPedidoService{

    @Autowired
    PedidoRepository pedidoRepository;
    @Override
    public PedidoResponse criarPedido(PedidoResponse pedidoResponse) {

        Pedido pedido = PedidoMapper.INSTANCE.toEntity(pedidoResponse);


        for(Itens_Pedido itens : pedido.getItens()){


            itens.setPedido(pedido);
        }


         pedidoRepository.save(pedido);

        return PedidoMapper.INSTANCE.toDTO(pedido);
    }

    @Override
    public PedidoResponse alterarPedido(PedidoResponse pedidoResponse) {

        Pedido pedido = PedidoMapper.INSTANCE.toEntity(pedidoResponse);

        return PedidoMapper.INSTANCE.toDTO(pedidoRepository.save(pedido));
    }

    @Override
    public List<PedidoResponse> listarPedido() {
        return PedidoMapper.INSTANCE.ConvertListResponse((List<Pedido>) pedidoRepository.findAll());
    }

    @Override
    public PedidoResponse buscarPorId(int id) {

        return PedidoMapper.INSTANCE.toDTO(pedidoRepository.findById(id).orElse(null));
    }

    @Override
    public String deletarPedido(int id) {
        return "REMOVIDO";
    }
}
