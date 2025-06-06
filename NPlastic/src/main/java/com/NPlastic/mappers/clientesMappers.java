package com.NPlastic.mappers;

import ch.qos.logback.core.model.ComponentModel;
import com.NPlastic.Entity.Clientes;
import com.NPlastic.dto.clientesDto.clientesRequest;
import com.NPlastic.dto.clientesDto.clientesResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "Spring")
public interface clientesMappers {

    clientesMappers INSTANCE  = Mappers.getMapper(clientesMappers.class);


    @Mapping(source = "Id", target = "Id")
    @Mapping(source = "nomeEmpresa", target = "nomeEmpresa")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "Role", target = "Role")

        Clientes toEntity(clientesRequest clientesRequest);

    @Mapping(source = "nomeEmpresa", target = "nomeEmpresa")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "Role", target = "Role")

    clientesResponse ToDto(Clientes clientes);


}
