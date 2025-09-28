package com.NPlastic.Mappers;

import com.NPlastic.Entity.Pedido;
import com.NPlastic.dto.PedidoDto.PedidoRequest;
import com.NPlastic.dto.PedidoDto.pedidoResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface PedidoMapper {

    @Mapping(source = "",target = "")
    Pedido toEntity(PedidoRequest pedidoRequest);

    pedidoResponse toDto(Pedido pedido);

    List<pedidoResponse> toListResponse(List<Pedido> pedidoList);
}
