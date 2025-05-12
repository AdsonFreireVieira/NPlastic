package com.NPlastic;

import com.NPlastic.Dto.ProdutosDto.ProdutoRequest;
import com.NPlastic.Dto.ProdutosDto.ProdutoResponse;
import com.NPlastic.Entity.Produto;
import com.NPlastic.Mappers.ProdutoMapper;
import com.NPlastic.repository.ProdutoRepository;
import com.NPlastic.service.serviceProduto.ServiceProdutoImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class ServiceProdutoImplTest {

    @Mock
    private ProdutoRepository repository;

    @InjectMocks
    private ServiceProdutoImpl service;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCriarProduto() {
        ProdutoRequest request = new ProdutoRequest();
        request.setNome("Produto Teste");

        Produto produtoEntity = ProdutoMapper.INSTANCE.toEntity(request);
        Produto produtoSalvo = new Produto();
        produtoSalvo.setNome("Produto Teste");

        when(repository.save(any(Produto.class))).thenReturn(produtoSalvo);

        ProdutoResponse response = service.criarProduto(request);

        assertNotNull(response);
        assertEquals("Produto Teste", response.getNome());
    }

    @Test
    void testAtualizaProduto() {
        ProdutoRequest request = new ProdutoRequest();
        request.setNome("Produto Atualizado");

        Produto produtoEntity = ProdutoMapper.INSTANCE.toEntity(request);
        Produto produtoAtualizado = new Produto();
        produtoAtualizado.setNome("Produto Atualizado");

        when(repository.save(any(Produto.class))).thenReturn(produtoAtualizado);

        ProdutoResponse response = service.AtualizaProduto(request);

        assertNotNull(response);
        assertEquals("Produto Atualizado", response.getNome());
    }

    @Test
    void testListarProdutos() {
        Produto produto1 = new Produto();
        produto1.setNome("Produto 1");

        Produto produto2 = new Produto();

        produto2.setNome("Produto 2");

        when(repository.findAll()).thenReturn(Arrays.asList(produto1, produto2));

        List<ProdutoResponse> responseList = service.listarProdutos();

        assertNotNull(responseList);
        assertEquals(2, responseList.size());
        assertEquals("Produto 1", responseList.get(0).getNome());
        assertEquals("Produto 2", responseList.get(1).getNome());
    }

    @Test
    void testBuscarPorId() {
        Produto produto = new Produto();
        produto.setNome("Produto Buscado");

        when(repository.findById(1)).thenReturn(Optional.of(produto));

        ProdutoResponse response = service.buscarPorId(1);

        assertNotNull(response);
        assertEquals("Produto Buscado", response.getNome());
    }

    @Test
    void testBuscarPorIdNaoEncontrado() {
        when(repository.findById(99)).thenReturn(Optional.empty());

        ProdutoResponse response = service.buscarPorId(99);

        assertNull(response);
    }

    @Test
    void testDeletarProduto() {
           String resultado = service.deletarProduto(1);
        assertEquals("Removido", resultado);


    }
}
