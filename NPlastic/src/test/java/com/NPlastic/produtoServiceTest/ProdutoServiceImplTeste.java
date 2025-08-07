package com.NPlastic.produtoServiceTest;

import com.NPlastic.Entity.Produto;
import com.NPlastic.Exception.ProdutoException;
import com.NPlastic.dto.clientesDto.clientesResponse;
import com.NPlastic.dto.produtoDto.produtoRequest;
import com.NPlastic.dto.produtoDto.produtoResponse;
import com.NPlastic.mappers.produtoMapper;
import com.NPlastic.repository.ProdutoRepository;
import com.NPlastic.services.produtoService.produtoServiceImpl;
import org.apache.coyote.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProdutoServiceImplTeste {

    @InjectMocks
    private produtoServiceImpl service;

    @Mock
    private produtoMapper mappers;

    @Mock
    private ProdutoRepository repository;

    @Test
    @DisplayName("InserirProduto")
    void deveInserirProduto(){

        Produto produto = new Produto(1,"Plastico","Preto","90x110",3.5,"Indeterminada");
        produtoResponse response = new produtoResponse("Plastico","Preto",3.5,"90x110","Indeterminada");
        produtoRequest request = new produtoRequest(1,"Plastico","Preto",3.5,"90x110","Indeterminada");


        when(mappers.toEntity(request)).thenReturn(produto);
        when(mappers.toDto(produto)).thenReturn(response);

        produtoResponse responseResult = service.cadastrarNovo(request);

        assertEquals("Plastico",responseResult.getNome());
        assertEquals(3.5,responseResult.getPeso());


    }

    @DisplayName("AtualizaProduto")
    @Test
    void atualizaProduto() {
        int id = 2;

        Produto produtoSalvo = new Produto(2, "Plastico", "Preto", "90x110", 3.5, "Indeterminada");
        Produto produto = new Produto(2, "Plastico", "Preto", "90x110", 3.5, "Indeterminada");

        produtoResponse response = new produtoResponse("Plastico", "Preto", 3.5, "90x110", "Indeterminada");
        produtoRequest request = new produtoRequest(2, "Plastico", "Preto", 3.5, "90x110", "Indeterminada");

        when(repository.findById(id)).thenReturn(Optional.of(produtoSalvo));
        when(repository.save(any(Produto.class))).thenReturn(produtoSalvo);
        when(mappers.toDto(any(Produto.class))).thenReturn(response);

        Optional<produtoResponse> resultado = service.alterarProduto(request, id);

        assertTrue(resultado.isPresent());
        assertEquals("Plastico", resultado.get().getNome());
        assertEquals("Preto", resultado.get().getCor());
        assertEquals(3.5, resultado.get().getPeso());
    }

    @Test
    @DisplayName("RetornaListarProduto")
    void RetornaProdutos(){


      List<Produto> listProdutos  =new ArrayList<>();

        produtoResponse response = new produtoResponse("Plastico", "Preto", 3.5, "90x110", "Indeterminada");
        produtoResponse response1 = new produtoResponse("Plastico", "Preto", 3.5, "90x110", "Indeterminada");

        Produto produtoSalvo = new Produto(2, "Plastico", "Preto", "90x110", 3.5, "Indeterminada");
        Produto produto = new Produto(2, "Plastico", "Preto", "90x110", 3.5, "Indeterminada");

        listProdutos.add(produto);
        listProdutos.add(produtoSalvo);

        List<produtoResponse> responseList = new ArrayList<>();

        responseList.add(response);
        responseList.add(response1);

        when(repository.findAll()).thenReturn(listProdutos);
        when(mappers.toList(listProdutos)).thenReturn(responseList);

       List<produtoResponse> resultList = service.listarProduto();

       assertEquals(2,resultList.size());
    }

    @Test
    @DisplayName("RetornaSucessProdutoPorId")
    void testaProdutoPorId(){

        Produto produto = new Produto(2, "Plastico", "Preto", "90x110", 3.5, "Indeterminada");
      int id =2;

        produtoResponse produtoResponse = new produtoResponse( "Plastico", "Preto", 3.5,"90x110", "Indeterminada");

     when(repository.findById(id)).thenReturn(Optional.of(produto));
     when(mappers.toDto(produto)).thenReturn(produtoResponse);

     Optional<produtoResponse> result = service.buscarPorId(id);

     assertEquals("Plastico",result.get().getNome());



    }
@Test
 @DisplayName("DeletarProduto")

 void deletarProdutoPorId(){

    Produto produto = new Produto(2, "Plastico", "Preto", "90x110", 3.5, "Indeterminada");
   int id =2;

   String msg = service.deletar(id);

   assertEquals("removido",msg);
}

}
