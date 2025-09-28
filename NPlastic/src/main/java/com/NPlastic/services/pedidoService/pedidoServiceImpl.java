package com.NPlastic.services.pedidoService;

import com.NPlastic.Entity.Pedido;
import com.NPlastic.Mappers.PedidoMapper;
import com.NPlastic.dto.Itens_PedidoDto.itens_PedidoRequest;
import com.NPlastic.dto.PedidoDto.PedidoRequest;
import com.NPlastic.dto.PedidoDto.pedidoResponse;
import com.NPlastic.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class pedidoServiceImpl implements  pedidoService {

    private final PedidoRepository pedidoRepository;
    private final PedidoMapper pedidoMappers;


    public pedidoServiceImpl(PedidoRepository pedidoRepository, PedidoMapper pedidoMappers) {
        this.pedidoRepository = pedidoRepository;
        this.pedidoMappers = pedidoMappers;
    }


    @Override
    public pedidoResponse cadastrarNovo(PedidoRequest request) {

        Pedido pedido = pedidoMappers.toEntity(request);

        for (itens_PedidoRequest itensRequest : pedido.getItensRequest()) {

            itensRequest.setPedidoRequest(request);
        }

        pedidoRepository.save(pedido);


        return pedidoMappers.toDto(pedido);
    }


    //@Override
   public pedidoResponse alterarPedido(PedidoRequest request, int id) {

        Pedido pedido = pedidoRepository.findById(id).orElseThrow(() -> new RuntimeException("Nao Encontrado"));

            Pedido pedidoAtualizado = pedidoMappers.atualizarEntity(request,pedido);

        return pedidoMappers.toDTo(pedidoRepository.save(pedidoAtualizado));
    }

    @Override
    public Optional<pedidoResponse> buscarPedidoPorId(Integer id) {

        return pedidoRepository.findById(id).map(pedidoMappers::toDto);
    }

    @Override
    public List<pedidoResponse> listarPedido() {
        return pedidoMappers.toListResponse((List<Pedido>) pedidoRepository.findAll());
    }
}
