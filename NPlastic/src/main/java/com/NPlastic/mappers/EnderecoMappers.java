package com.NPlastic.mappers;

import com.NPlastic.Entity.Endereco;
import com.NPlastic.dto.enderecoDto.enderecoRequest;
import com.NPlastic.dto.enderecoDto.enderecoResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "Spring")
public interface EnderecoMappers {

    EnderecoMappers INSTANCE = Mappers.getMapper(EnderecoMappers.class);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "nomeRua", target = "nomeRua")
    @Mapping(source = "numero", target = "numero")
    @Mapping(source = "cidade", target = "cidade")
    @Mapping(source = "cep", target = "cep")
    @Mapping(source = "bairro", target = "bairro")
    @Mapping(source = "clientes", target = "clientes")
    Endereco toEntity(enderecoRequest enderecoRequest);

    @Mapping(source = "nomeRua", target = "nomeRua")
    @Mapping(source = "numero", target = "numero")
    @Mapping(source = "cidade", target = "cidade")
    @Mapping(source = "cep", target = "cep")
    @Mapping(source = "bairro", target = "bairro")
    @Mapping(source = "clientes", target = "clientes")

    enderecoResponse toDto(Endereco endereco);

    Endereco atualizarEntity(enderecoRequest request, @MappingTarget Endereco endereco);

    List<enderecoResponse> toList(List<Endereco> enderecoList);

}