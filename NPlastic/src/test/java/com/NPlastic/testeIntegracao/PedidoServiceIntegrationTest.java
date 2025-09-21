package com.NPlastic.testeIntegracao;

import com.NPlastic.Entity.Clientes;
import com.NPlastic.Entity.Endereco;
import com.NPlastic.Entity.Itens_Pedido;
import com.NPlastic.Entity.Produto;
import com.NPlastic.dto.PedidoDto.PedidoRequest;
import com.NPlastic.dto.PedidoDto.pedidoResponse;
import com.NPlastic.repository.ClientesRepository;
import com.NPlastic.repository.EnderecoRepository;
import com.NPlastic.repository.ProdutoRepository;
import com.NPlastic.services.clienteService.clienteServiceImpl;
import com.NPlastic.services.pedidoService.pedidoServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@Testcontainers
public class PedidoServiceIntegrationTest extends AbstractIntegrationTest {

    @Autowired
    private pedidoServiceImpl pedidoService;

    @Autowired
    private ClientesRepository clientesRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @BeforeEach
    void setUp() {

        Produto produto = new Produto();
        produto.setPeso(4.0);
        produto.setValidade("Inteterminada");
        produto.setNome("Plastico");
        produto.setMedida("120L");

        produtoRepository.save(produto);

        Clientes clientes = new Clientes();
        clientes.setNomeEmpresa("CClean");
        clientes.setEmail("Cclean@Gmail.com");

        clientesRepository.save(clientes);

        Endereco endereco = new Endereco();

        endereco.setBairro("Mogi Mirim");
        endereco.setCidade("Sp");
        endereco.setNumero(123);
        endereco.setCep("0989892");
        endereco.setClientes(clientes);

        enderecoRepository.save(endereco);

        PedidoRequest pedidoRequest = new PedidoRequest();


        Itens_Pedido itensPedido = new Itens_Pedido();
        itensPedido.setQuantidade(5);
        itensPedido.setProduto(produto);
        itensPedido.setPedido(pedidoRequest);
        List<Itens_Pedido> itens = new ArrayList<>();

        itens.add(itensPedido);

        pedidoRequest.setClientes(clientes);
        pedidoRequest.setData(Date.from(Instant.now()));
        pedidoRequest.setValorTotal(200);
        pedidoRequest.setQuantidadeItensTotal(10);
        pedidoRequest.setItens(itens);
        pedidoService.cadastrarNovo(pedidoRequest);

    }

    @Test
    @DisplayName("Atualizar Pedido")
    void atualizarPedido() {

        pedidoResponse pedidoSalvo = pedidoService.listarPedido().get(0);

        PedidoRequest pedidoRequestAtualizar = new PedidoRequest();

        pedidoRequestAtualizar.setQuantidadeItensTotal(10);
        pedidoRequestAtualizar.setValorTotal(500);

         pedidoResponse pedidoAtualizado = pedidoService.alterarPedido(pedidoRequestAtualizar, pedidoSalvo.getId());

   assertThat(pedidoAtualizado).isNotNull();
   assertThat(pedidoAtualizado.getValorTotal()).isEqualTo(200);

    }
}