package com.NPlastic.services.pedidoService;

import com.NPlastic.Entity.Itens_Pedido;
import com.NPlastic.Entity.Pedido;
import com.NPlastic.dto.PedidoDto.PedidoRequest;
import com.NPlastic.dto.PedidoDto.pedidoResponse;
import com.NPlastic.mappers.PedidoMappers;
import com.NPlastic.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class pedidoServiceImpl implements  pedidoService{

    private final PedidoRepository pedidoRepository;
    private final PedidoMappers  pedidoMappers;


    public pedidoServiceImpl(PedidoRepository pedidoRepository, PedidoMappers pedidoMappers) {
        this.pedidoRepository = pedidoRepository;
        this.pedidoMappers = pedidoMappers;
    }


    @Override
    public pedidoResponse cadastrarNovo(PedidoRequest request) {

        Pedido pedido  = pedidoMappers.toEntity(request);

        for (Itens_Pedido itens : pedido.getItens()){

            itens.setPedido(pedido);
        }

        pedidoRepository.save(pedido);



        return pedidoMappers.toDTo(pedido);
    }


    @Override
    public pedidoResponse alterarPedido(PedidoRequest request , int id) {

        Pedido pedido = pedidoRepository.findById(id).orElseThrow(()-> new RuntimeException("Nao Encontrado"));

        Pedido pedidoAtualizado = pedidoMappers.atualizarEntity(request,pedido);

        return pedidoMappers.toDTo(pedidoRepository.save(pedidoAtualizado));
    }

    @Override
    public Optional<pedidoResponse> buscarPedidoPorId(Integer id) {

        return pedidoRepository.findById(id).map(pedidoMappers::toDTo);
    }

    @Override
    public List<pedidoResponse> listarPedido() {
        return pedidoMappers.toListResponse((List<Pedido>) pedidoRepository.findAll());
    }
}
