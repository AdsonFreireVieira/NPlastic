package com.NPlastic.service.ServicePedido;

import com.NPlastic.Dto.PedidoDto.PedidoRequest;
import com.NPlastic.Dto.PedidoDto.PedidoResponse;
import com.NPlastic.Entity.Itens_Pedido;
import com.NPlastic.Entity.Pedido;
import com.NPlastic.Entity.Produto;
import com.NPlastic.Mappers.PedidoMapper;
import com.NPlastic.repository.PedidoRepository;
import com.NPlastic.repository.ProdutoRepository;
import com.NPlastic.service.ServicePedido.config.configuracaoItensPedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoImpl implements  IPedidoService {

    @Autowired
    PedidoRepository pedidoRepository;

  @Autowired
    configuracaoItensPedido configuracao;

    @Override
    public PedidoResponse criarPedido(PedidoRequest pedidoRequest) {

        Pedido pedido = PedidoMapper.INSTANCE.toEntity(pedidoRequest);

        for (Itens_Pedido item : pedidoRequest.getItens()) {

            pedido.setQuantidade(pedido.getItens().size());

            item.setPedido(pedido);


            item.setProduto(configuracao.retornaProdutoCadastrado(pedido));


            item.setValorItens(configuracao.calculaValorProduto(pedido));

        }


           pedido.setValorTotal(configuracao.calculaValorTotal(pedido));



        return PedidoMapper.INSTANCE.toDto(pedidoRepository.save(pedido));

    }

    @Override
    public PedidoResponse alterarPedido(PedidoRequest pedidoRequest) {

        Pedido pedido = PedidoMapper.INSTANCE.toEntity(pedidoRequest);


        pedidoRequest.getItens().stream().forEach(item -> item.setPedido(pedido));

        pedido.getItens().stream().forEach(itensPedido -> itensPedido.getProduto().getValorKg());


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
