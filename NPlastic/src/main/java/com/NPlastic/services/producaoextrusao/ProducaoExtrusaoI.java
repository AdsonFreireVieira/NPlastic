package com.NPlastic.services.producaoextrusao;

import com.NPlastic.entity.ProducaoCorte;
import com.NPlastic.entity.ProducaoExtrusao;

import java.util.List;

public interface ProducaoExtrusaoI {

    ProducaoExtrusao criarProdutoExtrusao(ProducaoExtrusao producaoExtrusao);

    ProducaoExtrusao atualizarProdutoExtrusao(ProducaoExtrusao producaoExtrusao);

    ProducaoExtrusao buscarPorId(int id);

    List<ProducaoExtrusao> listarProducaoExtrusao();

    String deletarProducaoExtrusao(int id);
}
