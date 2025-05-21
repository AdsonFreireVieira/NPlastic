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

    @Mapping(source = "id_Produto",target = "id_Produto")
    @Mapping(source = "nome",target = "nome")
    @Mapping(source = "classificacao",target = "classificacao")
    @Mapping(source = "quantidade",target = "quantidade")
    @Mapping(source = "cor",target = "cor")
    @Mapping(source = "valorKg",target = "valorKg")
    @Mapping(source = "peso",target = "peso")
    @Mapping(source = "estoque",target = "estoque")

    Produto toProduto(ProdutoRequest produtoRequest);

    @Mapping(source = "nome",target = "nome")
    @Mapping(source = "classificacao",target = "classificacao")
    @Mapping(source = "quantidade",target = "quantidade")
    @Mapping(source = "cor",target = "cor")
    @Mapping(source = "valorKg",target = "valorKg")
    @Mapping(source = "peso",target = "peso")
    @Mapping(source = "estoque",target = "estoque")
    ProdutoResponse toResponse(Produto produto);

    List<ProdutoResponse> toListResponse(List<Produto> produtoList);
}
