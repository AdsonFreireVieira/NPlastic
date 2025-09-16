package com.NPlastic.testeIntegracao;

import com.NPlastic.Entity.Clientes;
import com.NPlastic.Entity.Itens_Pedido;
import com.NPlastic.dto.Itens_PedidoDto.itens_PedidoRequest;
import com.NPlastic.dto.clientesDto.clientesRequest;
import com.NPlastic.dto.produtoDto.produtoRequest;
import com.NPlastic.services.clienteService.clienteServiceImpl;
import com.NPlastic.services.pedidoService.pedidoServiceImpl;
import com.NPlastic.services.produtoService.produtoServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;

public class PedidoServiceTest extends AbstractIntegrationTest{

    @Autowired
    private clienteServiceImpl serviceCliente;

    @Autowired
    private produtoServiceImpl produtoService;

    @Autowired
    private pedidoServiceImpl servicePedido;

    @BeforeEach
   void Setup(){

        produtoRequest produtoR = new produtoRequest();

        produtoR.setNome("Plastico");
        produtoR.setValidade("Indeterminado");
        produtoR.setCor("Azul");
        produtoR.setMedida("100");

        produtoService.cadastrarNovo(produtoR);

        itens_PedidoRequest itensRequest = new itens_PedidoRequest();

        itensRequest.setProduto();

        clientesRequest clienteRe = new clientesRequest();

        clienteRe.setNomeEmpresa("Cclean ");
        clienteRe.setEmail("Clean@Gmail.com");

        serviceCliente.novoCliente(clienteRe);

        produtoRequest produtoRe = new produtoRequest();
        produtoRe.setMedida("75 X 105");
        produtoRe.setCor("Amarelo");
        produtoRe.setPeso(4.200);
        produtoRe.setValidade("Indeterminado");
        produtoRe.setNome("Plastico");

        produtoService.cadastrarNovo(produtoRe);



    }
}
