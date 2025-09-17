package com.NPlastic.testeIntegracao;

import com.NPlastic.Entity.Clientes;
import com.NPlastic.Entity.Itens_Pedido;
import com.NPlastic.Entity.Produto;
import com.NPlastic.dto.Itens_PedidoDto.Itens_PedidoResponse;
import com.NPlastic.dto.Itens_PedidoDto.itens_PedidoRequest;
import com.NPlastic.dto.PedidoDto.PedidoRequest;
import com.NPlastic.dto.PedidoDto.pedidoResponse;
import com.NPlastic.dto.clientesDto.clientesRequest;
import com.NPlastic.dto.produtoDto.produtoRequest;
import com.NPlastic.services.clienteService.clienteServiceImpl;
import com.NPlastic.services.pedidoService.pedidoServiceImpl;
import com.NPlastic.services.produtoService.produtoServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PedidoServiceTest extends AbstractIntegrationTest{

    @Autowired
    private clienteServiceImpl serviceCliente;

    @Autowired
    private produtoServiceImpl produtoService;

    @Autowired
    private pedidoServiceImpl servicePedido;

    @BeforeEach
   void Setup(){

        Clientes clientes = new Clientes();

        clientes.setEmail("Cclean@Hotmail.com");
        clientes.setNomeEmpresa("CClean");

        Produto produto = new Produto();
        produto.setNome("Plastico");
        produto.setValidade("Indeterminado");
        produto.setCor("Azul");
        produto.setMedida("100");



        Itens_Pedido itens = new Itens_Pedido();
        Itens_Pedido itens1 = new Itens_Pedido();

        itens.setProduto(produto);
        itens.setQuantidade(5);

        itens1.setProduto(produto);
        itens1.setQuantidade(3);

        List<Itens_Pedido> itensList = new ArrayList<>();

        itensList.add(itens);
        itensList.add(itens1);




        PedidoRequest pedidoRequest = new PedidoRequest();

        pedidoRequest.setItens(itensList);
        pedidoRequest.setClientes(clientes);
        pedidoRequest.setValorTotal(0);
        pedidoRequest.setQuantidadeItensTotal(5);

    servicePedido.cadastrarNovo(pedidoRequest);




    }

    @Test
    @DisplayName("ListaPedido")
    void BuscarPedidos(){

        List<pedidoResponse> listPedidosResponse = servicePedido.listarPedido();

        assertThat(listPedidosResponse).isNotNull();


    }
}
