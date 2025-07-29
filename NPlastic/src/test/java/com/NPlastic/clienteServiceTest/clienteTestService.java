package com.NPlastic.clienteServiceTest;

import com.NPlastic.Entity.Clientes;
import com.NPlastic.dto.clientesDto.clientesRequest;
import com.NPlastic.dto.clientesDto.clientesResponse;
import com.NPlastic.mappers.ClientesMapper;
import com.NPlastic.repository.ClientesRepository;
import com.NPlastic.services.clienteService.clienteServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.List;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class clienteServiceImplTest {

    private ClientesRepository repository;
    private ClientesMapper mapper;
    private clienteServiceImpl service;

    @BeforeEach
    void setUp() {
        repository = mock(ClientesRepository.class);
        mapper = mock(ClientesMapper.class);
        service = new clienteServiceImpl(repository, mapper);
    }

    @Test
    void testNovoCliente() {
        clientesRequest request = new clientesRequest(); // adicione os valores se quiser
        Clientes entity = new Clientes();
        clientesResponse response = new clientesResponse();

        when(mapper.toEntity(request)).thenReturn(entity);
        when(repository.save(entity)).thenReturn(entity);
        when(mapper.toDto(entity)).thenReturn(response);

        clientesResponse result = service.novoCliente(request);

        assertNotNull(result);
        verify(repository).save(entity);
    }

    @Test
    void testAlterarCliente() {
        int id = 1;
        clientesRequest request = new clientesRequest();
        Clientes entity = new Clientes();
        clientesResponse response = new clientesResponse();

        when(repository.findById(id)).thenReturn(Optional.of(entity));
        when(mapper.toEntity(request)).thenReturn(entity);
        when(repository.save(entity)).thenReturn(entity);
        when(mapper.toDto(entity)).thenReturn(response);

        Optional<clientesResponse> result = service.alterarCliente(request, id);

        assertTrue(result.isPresent());
        verify(repository).save(entity);
    }

    @Test
    void testListarClientes() {
        Clientes cliente1 = new Clientes();
        Clientes cliente2 = new Clientes();
        clientesResponse resp1 = new clientesResponse();
        clientesResponse resp2 = new clientesResponse();

        when(repository.findAll()).thenReturn(Arrays.asList(cliente1, cliente2));
        when(mapper.toDto(cliente1)).thenReturn(resp1);
        when(mapper.toDto(cliente2)).thenReturn(resp2);

        List<clientesResponse> result = service.listarClientes();

        assertEquals(2, result.size());
    }

    @Test
    void testBuscarPorId() {
        int id = 1;
        Clientes cliente = new Clientes();
        clientesResponse response = new clientesResponse();

        when(repository.findById(id)).thenReturn(Optional.of(cliente));
        when(mapper.toDto(cliente)).thenReturn(response);

        Optional<clientesResponse> result = service.buscarPorId(id);

        assertTrue(result.isPresent());
        assertEquals(response, result.get());
    }

    @Test
    void testDeletarCliente() {
        int id = 1;
        Clientes cliente = new Clientes();

        when(repository.findById(id)).thenReturn(Optional.of(cliente));

        String result = service.deletarCliente(id);

        verify(repository).delete(cliente);
        assertEquals("Cliente deletado com sucesso", result); // ajuste conforme a mensagem real
    }
}
