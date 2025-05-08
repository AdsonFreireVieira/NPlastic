package com.NPlastic.UserServiceTest;

import com.NPlastic.Dto.ClientesDto.ClientesRequest;
import com.NPlastic.Dto.ClientesDto.ClientesResponse;
import com.NPlastic.Entity.Clientes;
import com.NPlastic.Mappers.ClientesMapper;
import com.NPlastic.repository.ClientesRepository;
import com.NPlastic.service.ServiceUser.ClienteServiceEmpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.mockito.MockitoAnnotations;

    public class UserServiceTest{

        @Mock
        private ClientesRepository repository;

        @InjectMocks
        private ClienteServiceEmpl service;

        @BeforeEach
        public void setUp() {
            MockitoAnnotations.openMocks(this);
        }

        @Test
        public void testCriarCliente() {
            ClientesRequest request = new ClientesRequest();
            Clientes cliente = ClientesMapper.INSTANCE.toEntity(request);
            Clientes savedCliente = cliente;
            ClientesResponse response = ClientesMapper.INSTANCE.toDto(savedCliente);

            when(repository.save(any(Clientes.class))).thenReturn(savedCliente);

            ClientesResponse result = service.criar(request);

            assertEquals(response.getNome(), result.getNome());
            verify(repository, times(1)).save(any(Clientes.class));
        }

        @Test
        public void testListarClientes() {
            Clientes cliente = new Clientes();
            cliente.setId(1);
            when(repository.findAll()).thenReturn(Arrays.asList(cliente));

            List<ClientesResponse> result = service.ListarUser();

            assertEquals(1, result.size());
            verify(repository, times(1)).findAll();
        }

        @Test
        public void testBuscarPorID() {
            Clientes cliente = new Clientes();
            cliente.setId(1);

            when(repository.findById(1)).thenReturn(Optional.of(cliente));

            ClientesResponse result = service.BuscarPorID(1);

            assertNotNull(result);
            verify(repository, times(1)).findById(1);
        }

        @Test
        public void testDeletarUsuario() {
            doNothing().when(repository).deleteById(1);

            service.deletarUser(1);

            verify(repository, times(1)).deleteById(1);
        }

        @Test
        public void testAtualizarCliente() {
            ClientesRequest request = new ClientesRequest();
            Clientes cliente = ClientesMapper.INSTANCE.toEntity(request);
            ClientesResponse response = ClientesMapper.INSTANCE.toDto(cliente);

            when(repository.save(any(Clientes.class))).thenReturn(cliente);

            ClientesResponse result = service.update(request);

            verify(repository, times(1)).save(any(Clientes.class));
        }

}
