package com.NPlastic.mappers;

import com.NPlastic.dto.producaoextrusao.ProducaoExtrusaoRequest;
import com.NPlastic.dto.producaoextrusao.ProducaoExtrusaoResponse;
import com.NPlastic.entity.ProducaoExtrusao;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProducaoExtrusaoMappers {

    ProducaoExtrusao toEntity(ProducaoExtrusaoRequest producaoExtrusaoRequest);

    ProducaoExtrusaoResponse toDto(ProducaoExtrusao producaoExtrusao);

    List<ProducaoExtrusaoResponse> listConverttoDto(List<ProducaoExtrusao> producaoExtrusaoList);
}
