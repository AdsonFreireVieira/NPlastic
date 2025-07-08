package com.NPlastic.mappers;

import com.NPlastic.Entity.Clientes;
import com.NPlastic.dto.clientesDto.clientesRequest;
import com.NPlastic.dto.clientesDto.clientesResponse;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ClientesMapper {

    Clientes toEntity(clientesRequest clientesRequest);

    clientesResponse toDto(Clientes clientes);

    List<clientesResponse> toListDto(List<Clientes> clientesList);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void atualizarCliente( @MappingTarget clientesRequest request, Clientes cliente);

    @Condition
    @Named("valorNaoNullo")
    default  Boolean   valorNaoNullo(Object valor){
        if(valor instanceof String){
            return valor != null && !((String) valor).trim().isEmpty();
        }
        return valor!=null;
    }
}
