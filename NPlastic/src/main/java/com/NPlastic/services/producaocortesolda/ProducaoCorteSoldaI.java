package com.NPlastic.services.producaocortesolda;

import com.NPlastic.dto.producaocortesolda.ProducaoCorteeSoldaRequest;
import com.NPlastic.dto.producaocortesolda.ProducaoCorteeSoldaResponse;

import java.util.List;
import java.util.Optional;

public interface ProducaoCorteSoldaI {

    ProducaoCorteeSoldaResponse criarProducaoCorteSolda(ProducaoCorteeSoldaRequest producaoCorteeSoldaRequest);

   Optional<ProducaoCorteeSoldaResponse> atualizarProducaoCorteSolda(int id, ProducaoCorteeSoldaRequest producaoCorteeSoldaRequest);

   ProducaoCorteeSoldaResponse buscarProducaoCorteSolda(int id);

   List<ProducaoCorteeSoldaResponse> listarProdutoCorteSolda();

    String deletarProducaoCorteSolda(int id);
}
