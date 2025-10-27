package com.NPlastic.mappers;

import ch.qos.logback.core.model.ComponentModel;
import com.NPlastic.dto.estoquedto.EstoqueRequest;
import com.NPlastic.dto.estoquedto.EstoqueResponse;
import com.NPlastic.entity.Estoque;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EstoqueMappers {


    Estoque toEntity(EstoqueRequest estoqueRequest);

    EstoqueResponse toDto(Estoque estoque);

    List<EstoqueResponse> ListResponse(List<Estoque> estoqueList);

}
