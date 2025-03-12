package com.NPlastic.mapper;

import ch.qos.logback.core.model.ComponentModel;
import com.NPlastic.Entity.Pedido;
import com.NPlastic.dto.DtoPedido.PedidoRequest;
import com.NPlastic.dto.DtoPedido.PedidoResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Lazy;

import java.util.List;

@Mapper(componentModel = "spring" , uses = {Clientesmapper.class})
public interface PedidoMapper {

    @Lazy
    PedidoMapper INSTANCE = Mappers.getMapper(PedidoMapper.class);

    @Mapping(source = "id",target = "id")
    @Mapping(source = "data",target = "data")
    @Mapping(source = "status",target = "status")
    @Mapping(source = "itensRequestList",target = "itens")
    @Mapping(source = "clientesRequest",target ="clientes")


    Pedido  convertToPedido(PedidoRequest pedidoRequest);

    @Mapping(source ="data",target = "data")
    @Mapping(source ="status",target = "status")
    @Mapping(source ="itens",target = "itensResponseList")
    @Mapping(source ="clientes",target = "clientesResponse")


    PedidoResponse convertToPedidoResponse(Pedido pedido);

    List<PedidoResponse> ConvertListResponse(List<Pedido> pedidoList);
}
