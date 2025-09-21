package com.NPlastic.mappers;

import com.NPlastic.Entity.Pedido;
import com.NPlastic.dto.PedidoDto.PedidoRequest;
import com.NPlastic.dto.PedidoDto.pedidoResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(    componentModel = "spring"
        ,nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface PedidoMappers {

    @Mapping(source="id",target = "id")
    @Mapping(source="data",target = "data")
    @Mapping(source="valorTotal",target = "valorTotal")
    @Mapping(source="quantidadeItensTotal",target = "quantidadeItensTotal")
    @Mapping(source="itens",target = "itens")
    @Mapping(source="clientes",target = "clientes")

 Pedido toEntity(PedidoRequest pedidoRequest);

    @Mapping(source="id",target = "id")
    @Mapping(source="data",target = "data")
    @Mapping(source="valorTotal",target = "valorTotal")
    @Mapping(source="quantidadeItensTotal",target = "quantidadeItensTotal")
    @Mapping(source="itens",target = "itens")
    @Mapping(source="clientes",target = "clientes")

    pedidoResponse toDTo(Pedido pedido);

    List<pedidoResponse> toListResponse(List<Pedido> pedidoList);

    Pedido atualizarEntity(PedidoRequest pedidoRequest ,@MappingTarget Pedido PedidoRequest);
}
