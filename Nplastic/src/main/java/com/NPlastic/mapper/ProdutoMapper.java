package com.NPlastic.mapper;

import com.NPlastic.Entity.Produto;
import com.NPlastic.dto.dtoProduto.ProdutoResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProdutoMapper {

    ProdutoMapper INSTANCE = Mappers.getMapper(ProdutoMapper.class);

    Produto toEntity(ProdutoResponse produtoResponse);

    ProdutoResponse toDTO(Produto produto);

    List<ProdutoResponse> toListResponse(List<Produto> produtoList);
}
