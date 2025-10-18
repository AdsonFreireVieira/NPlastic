package com.NPlastic.services.producaocortesolda;

import com.NPlastic.dto.producaocortesolda.ProducaoCorteeSoldaRequest;
import com.NPlastic.dto.producaocortesolda.ProducaoCorteeSoldaResponse;
import com.NPlastic.entity.ProducaoCorte;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProducaoCorteSoldaImpl implements ProducaoCorteSoldaI {



    @Override
    public ProducaoCorteeSoldaResponse criarProducaoCorteSolda(ProducaoCorteeSoldaRequest producaoCorteeSoldaRequest) {
        return null;
    }

    @Override
    public ProducaoCorteeSoldaResponse atualizarProducaoCorteSolda(ProducaoCorteeSoldaRequest producaoCorteeSoldaRequest) {
        return null;
    }

    @Override
    public ProducaoCorteeSoldaResponse buscarProdutoCorteSolda(int id) {
        return null;
    }

    @Override
    public List<ProducaoCorteeSoldaResponse> listarProdutoCorteSolda() {
        return null;
    }

    @Override
    public String deletarProducaoCorteSolda(int id) {
        return "";
    }
}
