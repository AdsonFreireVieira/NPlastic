package com.NPlastic.mappers;

import com.NPlastic.Entity.Clientes;
import com.NPlastic.dto.clientesDto.clientesRequest;
import com.NPlastic.dto.clientesDto.clientesResponse;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ClientesMapper {

    Clientes toEntity(clientesRequest clientesRequest);

    clientesResponse toDto(Clientes clientes);

    List<clientesResponse> toListDto(List<Clientes> clientesList);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void atualizarCliente( clientesRequest request,@MappingTarget Clientes cliente);
}
