package com.NPlastic.services.producaocortesolda;

import com.NPlastic.dto.producaocortesolda.ProducaoCorteeSoldaRequest;
import com.NPlastic.dto.producaocortesolda.ProducaoCorteeSoldaResponse;

import java.util.List;

public interface ProducaoCorteSoldaI {

    ProducaoCorteeSoldaResponse criarProducaoCorteSolda(ProducaoCorteeSoldaRequest producaoCorteeSoldaRequest);

    ProducaoCorteeSoldaResponse atualizarProducaoCorteSolda(int id,ProducaoCorteeSoldaRequest producaoCorteeSoldaRequest);

    ProducaoCorteeSoldaResponse buscarProdutoCorteSolda(int id);

   List<ProducaoCorteeSoldaResponse> listarProdutoCorteSolda();

    String deletarProducaoCorteSolda(int id);
}
