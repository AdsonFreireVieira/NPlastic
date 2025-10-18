package com.NPlastic.services.producaoextrusao;

import com.NPlastic.dto.producaoextrusao.ProducaoExtrusaoRequest;
import com.NPlastic.dto.producaoextrusao.ProducaoExtrusaoResponse;
import com.NPlastic.entity.ProducaoExtrusao;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProducaoExtrusaoImpl implements ProducaoExtrusaoI{

    @Override
    public ProducaoExtrusaoResponse criarProdutoExtrusao(ProducaoExtrusaoRequest producaoExtrusaoRequest) {
        return null;
    }

    @Override
    public ProducaoExtrusaoResponse atualizarProdutoExtrusao(ProducaoExtrusaoRequest producaoExtrusaoRequest) {
        return null;
    }

    @Override
    public ProducaoExtrusaoResponse buscarPorId(int id) {
        return null;
    }

    @Override
    public List<ProducaoExtrusaoResponse> listarProducaoExtrusao() {
        return List.of();
    }

    @Override
    public String deletarProducaoExtrusao(int id) {
        return "";
    }
}
