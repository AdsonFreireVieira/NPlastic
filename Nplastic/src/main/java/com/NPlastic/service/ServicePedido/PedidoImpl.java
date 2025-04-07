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
    public Pedido criarPedido(Pedido pedido) {

        for(Itens_Pedido item : pedido.getItens()){

            item.setPedido(pedido);
        }

        return  pedidoRepository.save(pedido);

    }



    @Override
    public Pedido alterarPedido(Pedido pedido) {


        return pedidoRepository.save(pedido);
    }

    @Override
    public List<Pedido> listarPedido() {
        return (List<Pedido>) pedidoRepository.findAll();
    }

    @Override
    public Pedido buscarPorId(int id) {

        return pedidoRepository.findById(id).orElse(null);
    }

    @Override
    public String deletarPedido(int id) {
        return "REMOVIDO";
    }
}
