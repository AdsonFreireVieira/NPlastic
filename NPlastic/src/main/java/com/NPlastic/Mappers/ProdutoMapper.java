package com.NPlastic.Mappers;

import com.NPlastic.Entity.Produto;
import com.NPlastic.dto.produtoDto.produtoRequest;
import com.NPlastic.dto.produtoDto.produtoResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface ProdutoMapper {

    Produto toEntity(produtoRequest request);

    produtoResponse toDto(Produto produto);

    List<produtoResponse> toListResponse(List<Produto> produtoList);
}
