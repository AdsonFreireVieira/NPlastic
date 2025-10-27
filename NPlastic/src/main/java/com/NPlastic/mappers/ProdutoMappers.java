package com.NPlastic.mappers;

import com.NPlastic.dto.produtodto.ProdutosRequest;
import com.NPlastic.dto.produtodto.ProdutosResponse;
import com.NPlastic.entity.Produtos;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProdutoMappers {

    Produtos toEntity(ProdutosRequest produtosRequest);

    ProdutosResponse toDto(Produtos produtos);

    List<ProdutosResponse> listConverttoDto(List<Produtos> produtosList);
}
