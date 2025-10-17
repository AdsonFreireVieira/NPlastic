package com.NPlastic.services.producaoestoque;

import com.NPlastic.entity.Estoque;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class EstoqueImpl implements ProducaoEstoqueI
{
    @Override
    public Estoque criarEstoque(Estoque estoque) {
        return null;
    }

    @Override
    public Estoque atualizarEstoque(Estoque estoque) {
        return null;
    }

    @Override
    public Estoque buscarPorId(int id) {
        return null;
    }

    @Override
    public List<Estoque> listarEstoque() {
        return List.of();
    }
}
