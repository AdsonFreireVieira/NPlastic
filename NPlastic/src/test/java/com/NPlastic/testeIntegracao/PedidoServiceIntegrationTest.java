package com.NPlastic.testeIntegracao;

import com.NPlastic.Entity.Clientes;
import com.NPlastic.Entity.Itens_Pedido;
import com.NPlastic.Entity.Pedido;
import com.NPlastic.Entity.Produto;
import com.NPlastic.dto.PedidoDto.PedidoRequest;
import com.NPlastic.dto.PedidoDto.pedidoResponse;
import com.NPlastic.repository.ClientesRepository;
import com.NPlastic.repository.PedidoRepository;
import com.NPlastic.repository.ProdutoRepository;
import com.NPlastic.services.pedidoService.pedidoService;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class PedidoServiceIntegrationTest {

    @Autowired
    private pedidoService pedidoService;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ClientesRepository clienteRepository;

    private Produto produto;
    private Clientes cliente;

    @BeforeEach
    public void setUp() {
        produto = new Produto();
        produto.setNome("Produto Teste");
        produto = produtoRepository.save(produto);

        cliente = new Clientes();
        cliente.setNomeEmpresa("Empresa Teste");
        cliente.setEmail("cliente@email.com");
        cliente.setSenha("123456");
        cliente = clienteRepository.save(cliente);
    }

    private PedidoRequest criarPedidoRequest(double precoUnitario, int quantidade) {
        Itens_Pedido item = new Itens_Pedido();
        item.setProduto(produto);
        item.setQuantidade(quantidade);

        PedidoRequest request = new PedidoRequest();
        request.setData(new Date());
        request.setValorTotal(precoUnitario * quantidade);
        request.setQuantidadeItensTotal(quantidade);
        request.setItens(Arrays.asList(item));
        request.setClientes(cliente);

        return request;
    }

    @Test
    public void deveCadastrarPedido() {
        PedidoRequest request = criarPedidoRequest(50, 2);
        pedidoResponse response = pedidoService.cadastrarNovo(request);

        assertThat(response).isNotNull();
        assertThat(response.getId()).isNotNull();
        assertThat(response.getClientes().getId()).isEqualTo(cliente.getId());
        assertThat(response.getItens()).hasSize(1);
    }

    @Test
    public void deveAtualizarPedido() {
        // 1. Cadastrar pedido
        PedidoRequest request = criarPedidoRequest(50, 2);
        pedidoResponse criado = pedidoService.cadastrarNovo(request);

        // 2. Alterar dados
        PedidoRequest novoRequest = criarPedidoRequest(100, 1); // muda valores e quantidade
        pedidoResponse atualizado = pedidoService.alterarPedido(novoRequest, criado.getId());

        assertThat(atualizado.getValorTotal()).isEqualTo(100.0);
        assertThat(atualizado.getQuantidadeItensTotal()).isEqualTo(1);
    }

    @Test
    public void deveBuscarPedidoPorId() {
        PedidoRequest request = criarPedidoRequest(50, 2);
        pedidoResponse criado = pedidoService.cadastrarNovo(request);

        Optional<pedidoResponse> buscado = pedidoService.buscarPedidoPorId(criado.getId());

        assertThat(buscado).isPresent();
        assertThat(buscado.get().getId()).isEqualTo(criado.getId());
    }

    @Test
    public void deveDeletarPedido() {
        // Cadastrar
        PedidoRequest request = criarPedidoRequest(50, 2);
        pedidoResponse criado = pedidoService.cadastrarNovo(request);

        // Deletar direto pelo repositório (já que seu serviço não tem método delete)
        pedidoRepository.deleteById(criado.getId());

        Optional<Pedido> pedidoDeletado = pedidoRepository.findById(criado.getId());

        assertThat(pedidoDeletado).isEmpty();
    }
}
