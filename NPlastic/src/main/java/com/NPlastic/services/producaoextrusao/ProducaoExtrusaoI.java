package com.NPlastic.services.producaoextrusao;

import com.NPlastic.dto.producaoextrusao.ProducaoExtrusaoRequest;
import com.NPlastic.dto.producaoextrusao.ProducaoExtrusaoResponse;
import com.NPlastic.entity.ProducaoCorte;
import com.NPlastic.entity.ProducaoExtrusao;

import java.util.List;

public interface ProducaoExtrusaoI {

    ProducaoExtrusaoResponse criarProdutoExtrusao(ProducaoExtrusaoRequest producaoExtrusaoRequest);

    ProducaoExtrusaoResponse atualizarProdutoExtrusao(ProducaoExtrusaoRequest producaoExtrusaoRequest);

    ProducaoExtrusaoResponse buscarPorId(int id);

    List<ProducaoExtrusaoResponse> listarProducaoExtrusao();

    String deletarProducaoExtrusao(int id);
}
