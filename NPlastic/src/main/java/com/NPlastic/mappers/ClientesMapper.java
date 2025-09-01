package com.NPlastic.mappers;

import com.NPlastic.Entity.Clientes;
import com.NPlastic.dto.clientesDto.clientesRequest;
import com.NPlastic.dto.clientesDto.clientesResponse;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ClientesMapper {

    @Mapping(source = "id",target = "id")
    @Mapping(source = "nomeEmpresa", target = "nomeEmpresa")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "senha", target = "senha")
    Clientes toEntity(clientesRequest clientesRequest);

    clientesResponse toDto(Clientes clientes);

    List<clientesResponse> toListDto(List<Clientes> clientesList);

    @Mapping(source = "id",target = "id")
    @Mapping(source = "nomeEmpresa", target = "nomeEmpresa", conditionQualifiedByName = "valorNaoNulo")
    @Mapping(source = "email", target = "email", conditionQualifiedByName = "valorNaoNulo")
    @Mapping(source = "senha", target = "senha", conditionQualifiedByName = "valorNaoNulo")
    void atualizarCliente(clientesRequest request, @MappingTarget Clientes cliente);

    @Condition
    @Named("valorNaoNulo")
    default boolean valorNaoNulo(Object valor) {
        if (valor instanceof String) {
            return valor != null && !((String) valor).trim().isEmpty();
        }
        return valor != null;
    }
}
