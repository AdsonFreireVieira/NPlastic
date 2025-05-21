package com.NPlastic.Mappers;

import ch.qos.logback.core.model.ComponentModel;
import com.NPlastic.Dto.ProdutosDto.ProdutoRequest;
import com.NPlastic.Dto.ProdutosDto.ProdutoResponse;
import com.NPlastic.Entity.Produto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper()
public interface ProdutoMapper {

    ProdutoMapper INSTANCE = Mappers.getMapper(ProdutoMapper.class);

    @Mapping(source = "id_Produto", target = "id_Produto")
    @Mapping(source = "nome", target = "nome")
    @Mapping(source = "classificacao", target = "classificacao")
    @Mapping(source = "quantidade", target = "quantidade")
    @Mapping(source = "cor", target = "cor")
    @Mapping(source = "peso", target = "peso")
    @Mapping(source = "estoque", target = "estoque")
    @Mapping(source = "valorKg", target = "valorKg")

    Produto toEntity(ProdutoRequest produtoRequest);

    @Mapping(source = "nome", target = "nome")
    @Mapping(source = "classificacao", target = "classificacao")
    @Mapping(source = "quantidade", target = "quantidade")
    @Mapping(source = "cor", target = "cor")
    @Mapping(source = "peso", target = "peso")
    @Mapping(source = "estoque", target = "estoque")
    @Mapping(source = "valorKg", target = "valorKg")

    ProdutoResponse toDto(Produto produto);

    List<ProdutoResponse> convertListDto(List<Produto> produtoList);

}
