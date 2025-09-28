package com.NPlastic.Mappers;

import com.NPlastic.Entity.Clientes;
import com.NPlastic.Entity.Itens_Pedido;
import com.NPlastic.dto.Itens_PedidoDto.Itens_PedidoResponse;
import com.NPlastic.dto.Itens_PedidoDto.itens_PedidoRequest;
import com.NPlastic.dto.clientesDto.clientesRequest;
import com.NPlastic.dto.clientesDto.clientesResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface Itens_PedidoMapper {


    @Mapping(source = "produtoRequest",target = "produto")
    @Mapping(source = "pedidoRequest",target = "pedido")
    Itens_Pedido toEntity(itens_PedidoRequest itensPedidoRequest);

    @Mapping(source= "produto",target = "produtosResponse")
    @Mapping(source= "pedido",target = "pedidosResponse")
     Itens_PedidoResponse toDto(Itens_Pedido itensPedido);


     List<Itens_PedidoResponse> toList(List<Itens_Pedido> itens_pedidoList);
    }