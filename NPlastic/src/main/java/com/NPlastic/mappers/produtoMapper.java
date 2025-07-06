package com.NPlastic.mappers;

import ch.qos.logback.core.model.ComponentModel;
import com.NPlastic.Entity.Produto;
import com.NPlastic.dto.produtoDto.produtoRequest;
import com.NPlastic.dto.produtoDto.produtoResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(   componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface produtoMapper {

    produtoMapper INSTANCE = Mappers.getMapper(produtoMapper.class);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "nome", target = "nome")
    @Mapping(source = "cor", target = "cor")
    @Mapping(source = "medida", target = "medida")
    @Mapping(source = "peso", target = "peso")
    @Mapping(source = "validade", target = "validade")

    Produto toEntity(produtoRequest produtoRequest);

    @Mapping(source = "nome", target = "nome")
    @Mapping(source = "cor", target = "cor")
    @Mapping(source = "medida", target = "medida")
    @Mapping(source = "peso", target = "peso")
    @Mapping(source = "validade", target = "validade")
    produtoResponse toDto(Produto produto);

    List<produtoResponse> toList(List<Produto> produtoList);

    Produto atualizarProduto(produtoRequest request , @MappingTarget Produto produto);
}
