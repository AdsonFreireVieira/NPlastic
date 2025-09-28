package com.NPlastic.Mappers;

import com.NPlastic.Entity.Endereco;
import com.NPlastic.dto.enderecoDto.enderecoRequest;
import com.NPlastic.dto.enderecoDto.enderecoResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface EnderecoMapper {

    @Mapping(target = "clienteRequest",source = "clientes")
    Endereco toEntity (enderecoRequest Request);

    @Mapping(source = "clientes",target = "clienteResponse")
    enderecoResponse toDto(Endereco endereco);

    List<enderecoResponse> convertList(List<Endereco> enderecoList);
}
