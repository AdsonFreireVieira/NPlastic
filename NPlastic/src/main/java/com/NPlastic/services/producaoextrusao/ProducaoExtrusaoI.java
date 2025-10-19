package com.NPlastic.services.producaoextrusao;

import com.NPlastic.dto.producaoextrusao.ProducaoExtrusaoRequest;
import com.NPlastic.dto.producaoextrusao.ProducaoExtrusaoResponse;

import java.util.List;

public interface ProducaoExtrusaoI {

    ProducaoExtrusaoResponse criarProdutoExtrusao(ProducaoExtrusaoRequest producaoExtrusaoRequest);

    ProducaoExtrusaoResponse atualizarProdutoExtrusao(int id,ProducaoExtrusaoRequest producaoExtrusaoRequest);

    ProducaoExtrusaoResponse buscarPorId(int id);

    List<ProducaoExtrusaoResponse> listarProducaoExtrusao();

    String deletarProducaoExtrusao(int id);
}
