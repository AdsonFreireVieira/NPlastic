package com.NPlastic.services.producaoestoque;

import com.NPlastic.dto.estoquedto.EstoqueRequest;
import com.NPlastic.dto.estoquedto.EstoqueResponse;
import com.NPlastic.entity.Estoque;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class EstoqueImpl implements ProducaoEstoqueI
{
    @Override
    public EstoqueResponse criarEstoque(EstoqueRequest estoqueRequest) {
        return null;
    }

    @Override
    public EstoqueResponse atualizarEstoque(EstoqueRequest estoqueRequest) {
        return null;
    }

    @Override
    public EstoqueResponse buscarPorId(int id) {
        return null;
    }

    @Override
    public List<EstoqueResponse> listarEstoque() {
        return List.of();
    }
}
