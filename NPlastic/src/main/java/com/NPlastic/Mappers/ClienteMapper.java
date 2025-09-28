package com.NPlastic.Mappers;

import com.NPlastic.Entity.Clientes;
import com.NPlastic.dto.clientesDto.clientesRequest;
import com.NPlastic.dto.clientesDto.clientesResponse;
import org.mapstruct.Mapping;

import java.util.List;

public interface ClienteMapper {

    @Mapping(source = "clienteRequest", target= "clientes")
    Clientes toEntity(clientesRequest request);

    clientesResponse toDTo(Clientes clientes);

    List<clientesResponse>toList(List<Clientes> clientes);
}
