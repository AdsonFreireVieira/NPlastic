package com.NPlastic.servicePedidoTest;


import com.NPlastic.Dto.PedidoDto.PedidoRequest;
import com.NPlastic.Dto.PedidoDto.PedidoResponse;
import com.NPlastic.Entity.Itens_Pedido;
import com.NPlastic.Entity.Pedido;
import com.NPlastic.Entity.Produto;
import com.NPlastic.Mappers.PedidoMapper;
import com.NPlastic.repository.PedidoRepository;
import com.NPlastic.service.ServicePedido.PedidoImpl;
import com.NPlastic.service.ServicePedido.config.configuracaoItensPedido;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class PedidoImplTest {

        @Mock
        private PedidoRepository pedidoRepository;

        @Mock
        private configuracaoItensPedido configuracao;

        @InjectMocks
        private PedidoImpl pedidoService;

        @BeforeEach
        void setup() {
            MockitoAnnotations.openMocks(this);
        }

        @Test
        void testCriarPedido() {
            PedidoRequest request = new PedidoRequest();
            Itens_Pedido item = new Itens_Pedido();
            Produto produto = new Produto();
            produto.setValorKg(10.0);
            item.setProduto(produto);
            item.setQuantidade(2);
            request.setItens(Collections.singletonList(item));

            Pedido pedido = PedidoMapper.INSTANCE.toEntity(request);
            pedido.setId(1);

            when(configuracao.retornaProdutoCadastrado(any())).thenReturn(produto);
            when(configuracao.calculaValorProduto(any())).thenReturn(10.0);
            when(configuracao.calculaValorTotal(any())).thenReturn(20.0);
            when(pedidoRepository.save(any(Pedido.class))).thenReturn(pedido);

            PedidoResponse response = pedidoService.criarPedido(request);

            assertNotNull(response);
        }

        @Test
        void testAlterarPedido() {
            PedidoRequest request = new PedidoRequest();
            Itens_Pedido item = new Itens_Pedido();
            Produto produto = new Produto();
            produto.setValorKg(15.0);
            item.setProduto(produto);
            request.setItens(Collections.singletonList(item));

            Pedido pedido = PedidoMapper.INSTANCE.toEntity(request);
            pedido.setId(1);

            when(pedidoRepository.save(any(Pedido.class))).thenReturn(pedido);

            PedidoResponse response = pedidoService.alterarPedido(request);

            assertNotNull(response);
        }

        @Test
        void testListarPedido() {
            Pedido pedido1 = new Pedido();
            pedido1.setId(1);
            Pedido pedido2 = new Pedido();
            pedido2.setId(2);

            when(pedidoRepository.findAll()).thenReturn(Arrays.asList(pedido1, pedido2));

            List<PedidoResponse> responseList = pedidoService.listarPedido();

            assertEquals(2, responseList.size());

        }
        @Test
        void testBuscarPorIdEncontrado() {
            Pedido pedido = new Pedido();
            pedido.setId(1);
            when(pedidoRepository.findById(1)).thenReturn(Optional.of(pedido));

            PedidoResponse response = pedidoService.buscarPorId(1);

            assertNotNull(response);
        }

        @Test
        void testBuscarPorIdNaoEncontrado() {
            when(pedidoRepository.findById(99)).thenReturn(Optional.empty());

            PedidoResponse response = pedidoService.buscarPorId(99);

            assertNull(response);
        }

        @Test
        void testDeletarPedido() {
            String resultado = pedidoService.deletarPedido(1);
            assertEquals("REMOVIDO", resultado);
        }
    }


