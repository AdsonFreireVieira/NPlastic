package com.NPlastic.mappers;

import com.NPlastic.dto.producaocortesolda.ProducaoCorteeSoldaRequest;
import com.NPlastic.dto.producaocortesolda.ProducaoCorteeSoldaResponse;
import com.NPlastic.entity.ProducaoCorteSolda;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface ProducaoCorteSoldaMappers {

    ProducaoCorteSolda toEntity(ProducaoCorteeSoldaRequest producaoCorteeSoldaRequest);

    ProducaoCorteeSoldaResponse toDto(ProducaoCorteSolda producaoCorte);

    List<ProducaoCorteeSoldaResponse> listResponse(List<ProducaoCorteSolda> producaoCorteSoldaList);
}
