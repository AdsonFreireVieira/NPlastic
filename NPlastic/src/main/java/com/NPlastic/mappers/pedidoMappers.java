package com.NPlastic.mappers;

import com.NPlastic.Entity.Pedido;
import com.NPlastic.dto.PedidoDto.pedidoRequest;
import com.NPlastic.dto.PedidoDto.pedidoResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "Spring")
public interface pedidoMappers {

    @Mapping(source="id",target = "id")
    @Mapping(source="data",target = "data")
    @Mapping(source="valorTotal",target = "valorTotal")
    @Mapping(source="quantidadeItensTotal",target = "quantidadeItensTotal")
    @Mapping(source="itens",target = "itens")
    @Mapping(source="clientes",target = "clientes")

 Pedido toEntity(pedidoRequest pedidoRequest);

    @Mapping(source="data",target = "data")
    @Mapping(source="valorTotal",target = "valorTotal")
    @Mapping(source="quantidadeItensTotal",target = "quantidadeItensTotal")
    @Mapping(source="itens",target = "itens")
    @Mapping(source="clientes",target = "clientes")

    pedidoResponse toDTo(Pedido pedido);
}
