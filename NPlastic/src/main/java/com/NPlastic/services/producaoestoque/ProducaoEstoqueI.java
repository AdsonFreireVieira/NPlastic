package com.NPlastic.services.producaoestoque;

import com.NPlastic.entity.Estoque;

import java.util.List;

public interface ProducaoEstoqueI {

    Estoque criarEstoque(Estoque estoque);

    Estoque atualizarEstoque(Estoque estoque);

    Estoque buscarPorId(int id );

    List<Estoque> listarEstoque();

}
