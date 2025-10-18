package com.NPlastic.services.producaoestoque;

import com.NPlastic.dto.estoquedto.EstoqueRequest;
import com.NPlastic.dto.estoquedto.EstoqueResponse;
import com.NPlastic.entity.Estoque;

import java.util.List;

public interface ProducaoEstoqueI {

    EstoqueResponse criarEstoque(EstoqueRequest estoqueRequest);

    EstoqueResponse atualizarEstoque(EstoqueRequest estoqueRequest);

    EstoqueResponse buscarPorId(int id );

    List<EstoqueResponse> listarEstoque();

}
