package com.NPlastic.Mappers;

import ch.qos.logback.core.model.ComponentModel;
import com.NPlastic.Dto.EnderecoDto.EnderecoRequest;
import com.NPlastic.Dto.EnderecoDto.EnderecoResponse;
import com.NPlastic.Entity.Endereco;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper()
public interface EnderecoMapper {

    EnderecoMapper INSTANCE = Mappers.getMapper(EnderecoMapper.class);
    @Mapping(source = "id",target = "id")
    @Mapping(source = "numero",target = "numero")
    @Mapping(source = "cep",target = "cep")
    @Mapping(source = "cidade",target = "cidade")
    @Mapping(source = "bairro",target = "bairro")
    @Mapping(source = "estado",target = "estado")
    @Mapping(source = "clientes",target = "clientes")

    Endereco toEntity(EnderecoRequest enderecoRequest);

    @Mapping(source = "numero",target = "numero")
    @Mapping(source = "cep",target = "cep")
    @Mapping(source = "cidade",target = "cidade")
    @Mapping(source = "bairro",target = "bairro")
    @Mapping(source = "estado",target = "estado")
    @Mapping(source = "clientes",target = "clientes")

    EnderecoResponse toDto(Endereco endereco);

    List<EnderecoResponse> convertList(List<Endereco> enderecoList);
}
