package com.NPlastic.service.serviceProduto;

<<<<<<< HEAD
import com.NPlastic.dto.dtoProduto.ProdutoResponse;

=======
import com.NPlastic.Dto.ProdutosDto.ProdutoRequest;
import com.NPlastic.Dto.ProdutosDto.ProdutoResponse;
>>>>>>> fefb70f1e83e1e72ac672e5557ca9e1a6d65f5dc
import java.util.List;

public interface IProduto {

    public  ProdutoResponse criarProduto(ProdutoRequest produtoRequest);

    public ProdutoResponse AtualizaProduto(ProdutoRequest produtoRequest );

    public List<ProdutoResponse> listarProdutos();

    public ProdutoResponse buscarPorId(int id);

    public String deletarProduto(int id);
}
