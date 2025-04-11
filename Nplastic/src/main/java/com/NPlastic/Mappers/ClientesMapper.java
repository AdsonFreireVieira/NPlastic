package com.NPlastic.Mappers;

import com.NPlastic.Dto.ClientesDto.ClientesRequest;
import com.NPlastic.Dto.ClientesDto.ClientesResponse;
import com.NPlastic.Entity.Clientes;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientesMapper {

    ClientesMapper INSTANCE = Mappers.getMapper(ClientesMapper.class);

    @Mapping(target = "id",source = "id")
    @Mapping(target = "nome",source = "nome")
    @Mapping(target = "email",source = "email")
    @Mapping(target = "telefone",source = "telefone")
    @Mapping(target = "senha",source = "senha")
    @Mapping(target = "data",source = "data")

    Clientes toEntity(ClientesRequest clientesRequest);

    @Mapping(target = "nome",source = "nome")
    @Mapping(target = "email",source = "email")
    @Mapping(target = "telefone",source = "telefone")
    @Mapping(target = "senha",source = "senha")
    @Mapping(target = "data",source = "data")

    ClientesResponse toDto(Clientes clientes);

    List<ClientesResponse> convertListResponse(List<Clientes> clientesList);
}
