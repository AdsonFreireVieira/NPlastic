package com.NPlastic.mappers;

import ch.qos.logback.core.model.ComponentModel;
import com.NPlastic.Entity.Clientes;
import com.NPlastic.dto.clientesDto.clientesRequest;
import com.NPlastic.dto.clientesDto.clientesResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


import java.util.List;

@Mapper(componentModel = "spring")
public interface clientesMappers {

    clientesMappers INSTANCE = Mappers.getMapper(clientesMappers.class);


    Clientes toEntity(clientesRequest clientesRequest);

    clientesResponse toDto(Clientes clientes);

    List<clientesResponse> toListDto(List<Clientes> clientesList);


}
