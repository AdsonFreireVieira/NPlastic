package com.NPlastic.mapper;

import com.NPlastic.Entity.Pedido;
import com.NPlastic.dto.DtoPedido.PedidoResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PedidoMapper {


    PedidoMapper INSTANCE = Mappers.getMapper(PedidoMapper.class);

    Pedido toEntity(PedidoResponse pedidoResponse);

    PedidoResponse toDTO(Pedido pedido);

    List<PedidoResponse> ConvertListResponse(List<Pedido> pedidoList);
}

