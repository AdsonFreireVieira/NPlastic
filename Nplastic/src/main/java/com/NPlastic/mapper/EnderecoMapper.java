package com.NPlastic.mapper;

import com.NPlastic.Entity.Endereco;
import com.NPlastic.dto.dtoEndereco.EnderecoResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EnderecoMapper {

EnderecoMapper INSTANCE = Mappers.getMapper(EnderecoMapper.class);

 Endereco toEntity(EnderecoResponse enderecoResponse);

 EnderecoResponse toDTO(Endereco endereco);

 List<EnderecoResponse> toListResponse(List<Endereco> enderecoList);

}