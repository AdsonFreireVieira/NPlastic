package com.NPlastic.services.producaocortesolda;

import com.NPlastic.entity.ProducaoCorte;

import java.util.List;

public interface ProducaoCorteSoldaI {

    ProducaoCorte criarProducaoCorteSolda(ProducaoCorte producaoCorte);

    ProducaoCorte atualizarProducaoCorteSolda(ProducaoCorte producaoCorte);

    ProducaoCorte buscarProdutoCorteSolda(int id);

   List<ProducaoCorte> listarProdutoCorteSolda();

    String deletarProducaoCorteSolda(int id);
}
