
package com.NPlastic.ServicesTestUnitarios.clienteServiceTest.ServicePedidoTest;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.NPlastic.Entity.Itens_Pedido;
import com.NPlastic.Entity.Pedido;
import com.NPlastic.dto.PedidoDto.PedidoRequest;
import com.NPlastic.dto.PedidoDto.pedidoResponse;
import com.NPlastic.mappers.PedidoMapper;
import com.NPlastic.repository.PedidoRepository;
import com.NPlastic.services.pedidoService.pedidoServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class PedidoServiceImplTest {

    @Mock
    private PedidoRepository pedidoRepository;

    @Mock
    private PedidoMapper pedidoMappers;

    @InjectMocks
    private pedidoServiceImpl service;

    private Pedido pedido;
    private PedidoRequest pedidoRequest;
    private pedidoResponse pedidoResponse;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        pedido = new Pedido();
        pedido.setId(1);
        pedido.setItens(Arrays.asList(new Itens_Pedido()));

        pedidoRequest = new PedidoRequest();
        pedidoResponse = new pedidoResponse();
    }

    @Test
    void deveCadastrarNovoPedido() {
        when(pedidoMappers.toEntity(pedidoRequest)).thenReturn(pedido);
        when(pedidoRepository.save(pedido)).thenReturn(pedido);
        when(pedidoMappers.toDTo(pedido)).thenReturn(pedidoResponse);

        pedidoResponse result = service.cadastrarNovo(pedidoRequest);

        assertNotNull(result);
        verify(pedidoMappers).toEntity(pedidoRequest);
        verify(pedidoRepository).save(pedido);
        verify(pedidoMappers).toDTo(pedido);

        pedido.getItens().forEach(item -> assertEquals(pedido, item.getPedido()));
    }

    @Test
    void deveAlterarPedidoExistente() {
        // Arrange
        when(pedidoRepository.findById(1)).thenReturn(Optional.of(pedido));
        when(pedidoMappers.atualizarEntity(pedidoRequest, pedido)).thenReturn(pedido);
        when(pedidoRepository.save(pedido)).thenReturn(pedido);
        when(pedidoMappers.toDTo(pedido)).thenReturn(pedidoResponse);

        pedidoResponse result = service.alterarPedido(pedidoRequest, 1);


        assertNotNull(result);
        verify(pedidoRepository).findById(1);
        verify(pedidoMappers).atualizarEntity(pedidoRequest, pedido);
        verify(pedidoRepository).save(pedido);
        verify(pedidoMappers).toDTo(pedido);
    }

    @Test
    void deveBuscarPedidoPorId() {
        when(pedidoRepository.findById(1)).thenReturn(Optional.of(pedido));
        when(pedidoMappers.toDTo(pedido)).thenReturn(pedidoResponse);

        Optional<pedidoResponse> result = service.buscarPedidoPorId(1);

        assertTrue(result.isPresent());
        verify(pedidoRepository).findById(1);
        verify(pedidoMappers).toDTo(pedido);
    }

    @Test
    void deveListarPedidos() {
        // Arrange
        List<Pedido> listaPedidos = Arrays.asList(pedido);
        List<pedidoResponse> listaResponses = Arrays.asList(pedidoResponse);

        when(pedidoRepository.findAll()).thenReturn(listaPedidos);
        when(pedidoMappers.toListResponse(listaPedidos)).thenReturn(listaResponses);

        List<pedidoResponse> result = service.listarPedido();

        assertEquals(1, result.size());
        verify(pedidoRepository).findAll();
        verify(pedidoMappers).toListResponse(listaPedidos);
    }

    @Test
    void deveLancarExcecaoAoAlterarPedidoNaoEncontrado() {
        when(pedidoRepository.findById(99)).thenReturn(Optional.empty());

        RuntimeException ex = assertThrows(RuntimeException.class,
                () -> service.alterarPedido(pedidoRequest, 99));
        assertEquals("Nao Encontrado", ex.getMessage());
        verify(pedidoRepository).findById(99);
        verifyNoMoreInteractions(pedidoRepository, pedidoMappers);
    }
}
