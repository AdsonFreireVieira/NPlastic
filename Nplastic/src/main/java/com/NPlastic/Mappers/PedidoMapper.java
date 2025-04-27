package com.NPlastic.Mappers;

import com.NPlastic.Dto.PedidoDto.PedidoRequest;
import com.NPlastic.Dto.PedidoDto.PedidoResponse;
import com.NPlastic.Entity.Pedido;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PedidoMapper {

    PedidoMapper INSTANCE = Mappers.getMapper(PedidoMapper.class);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "data", source = "data")
    @Mapping(target = "quantidade", source = "quantidade")
    @Mapping(target = "valorTotal", source = "valorTotal")
    @Mapping(target = "status", source = "status")
    @Mapping(target = "itens", source = "itens")
    @Mapping(target = "clientes", source = "clientes")

    Pedido toEntity(PedidoRequest pedidoRequest);


    @Mapping(target = "data", source = "data")
    @Mapping(target = "status", source = "status")
    @Mapping(target = "quantidade", source = "quantidade")
    @Mapping(target = "valorTotal", source = "valorTotal")
    @Mapping(target = "itens", source = "itens")
    @Mapping(target = "clientes", source = "clientes")

     PedidoResponse toDto(Pedido pedido);

     List<PedidoResponse> convertListDto(List<Pedido> pedidoList);
}
