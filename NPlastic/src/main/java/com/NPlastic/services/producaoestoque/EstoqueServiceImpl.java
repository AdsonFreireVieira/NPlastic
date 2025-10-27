package com.NPlastic.services.producaoestoque;

import com.NPlastic.dto.estoquedto.EstoqueRequest;
import com.NPlastic.dto.estoquedto.EstoqueResponse;

import java.util.List;

public interface EstoqueServiceImpl {

    EstoqueResponse criarEstoque(EstoqueRequest estoqueRequest);

    EstoqueResponse atualizarEstoque(int id,EstoqueRequest estoqueRequest);

    EstoqueResponse buscarPorId(int id );

    List<EstoqueResponse> listarEstoque();

}
