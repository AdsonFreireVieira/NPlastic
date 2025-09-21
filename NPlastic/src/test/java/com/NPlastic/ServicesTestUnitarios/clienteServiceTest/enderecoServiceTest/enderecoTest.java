package com.NPlastic.ServicesTestUnitarios.clienteServiceTest.enderecoServiceTest;

import com.NPlastic.Entity.Clientes;
import com.NPlastic.Entity.Endereco;
import com.NPlastic.dto.clientesDto.clientesRequest;
import com.NPlastic.dto.clientesDto.clientesResponse;
import com.NPlastic.dto.enderecoDto.enderecoRequest;
import com.NPlastic.dto.enderecoDto.enderecoResponse;
import com.NPlastic.mappers.EnderecoMappers;
import com.NPlastic.repository.EnderecoRepository;
import com.NPlastic.services.EnderecoService.EnderecoServiceImpl;
import org.hibernate.internal.util.collections.CollectionHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class enderecoTest {
        @Mock
        private EnderecoRepository repository;

        @Mock
        private EnderecoMappers mappers;

        @InjectMocks
        private EnderecoServiceImpl service;

        private Clientes cliente;
        private Endereco endereco;
        private enderecoRequest request;
        private enderecoResponse response;

        @BeforeEach
        void setUp() {
            cliente = new Clientes(1, "Nome", "email@teste.com", "senha");
            endereco = new Endereco(2, "Rua A", 100, "SP", "12345678", "Bairro X",cliente);
            request = new enderecoRequest(2,"Rua A", 100, "SP", "12345678", "Bairro X",new clientesRequest());
            response = new enderecoResponse(1,"Rua A", 100, "SP", "12345678", "Bairro X",new clientesResponse());
        }

        @Test
        void deveSalvarNovoEndereco() {
            when(mappers.toEntity(request)).thenReturn(endereco);
            when(repository.save(endereco)).thenReturn(endereco);
            when(mappers.toDto(endereco)).thenReturn(response);

            enderecoResponse result = service.novo(request);

            assertEquals("Rua A", result.getNomeRua());
            verify(mappers).toEntity(request);
            verify(repository).save(endereco);
            verify(mappers).toDto(endereco);
        }

        @Test
        void deveAtualizarEnderecoComSucesso() {
            when(repository.findById(2)).thenReturn(Optional.of(endereco));
            when(repository.save(endereco)).thenReturn(endereco);
            when(mappers.toDto(endereco)).thenReturn(response);

            Optional<enderecoResponse> result = service.atualizar(2, request);

            assertTrue(result.isPresent());
            assertEquals("Rua A", result.get().getNomeRua());
            verify(repository).findById(2);
            verify(mappers).atualizarEntity(request, endereco);
            verify(repository).save(endereco);
            verify(mappers).toDto(endereco);
        }

        @Test
        void deveLancarExcecaoAoAtualizarEnderecoInexistente() {
            when(repository.findById(99)).thenReturn(Optional.empty());

            assertThrows(RuntimeException.class, () -> service.atualizar(99, request));

            verify(repository).findById(99);
            verify(mappers, never()).atualizarEntity(any(), any());
        }

        @Test
        void deveBuscarEnderecoPorId() {
            when(repository.findById(2)).thenReturn(Optional.of(endereco));
            when(mappers.toDto(endereco)).thenReturn(response);

            Optional<enderecoResponse> result = service.buscarPorId(2);

            assertTrue(result.isPresent());
            assertEquals("Rua A", result.get().getNomeRua());
            verify(repository).findById(2);
            verify(mappers).toDto(endereco);
        }

        @Test
        void deveDeletarEnderecoExistente() {
            when(repository.findById(2)).thenReturn(Optional.of(endereco));
            when(mappers.toDto(endereco)).thenReturn(response);

            service.deletar(2);

            verify(repository).findById(2);
            verify(repository).deleteById(2);
        }

        @Test
        void deveLancarExcecaoAoDeletarEnderecoInexistente() {
            when(repository.findById(99)).thenReturn(Optional.empty());

            assertThrows(RuntimeException.class, () -> service.deletar(99));

            verify(repository).findById(99);
            verify(repository, never()).deleteById(anyInt());
        }

        @Test
        void deveListarTodosEnderecos() {
            List<Endereco> enderecos = List.of(endereco);
            List<enderecoResponse> responses = List.of(response);

            when(repository.findAll()).thenReturn(enderecos);
            when(mappers.toList(enderecos)).thenReturn(responses);

            List<enderecoResponse> result = service.listarEndereco();

            assertEquals(1, result.size());
            assertEquals("Rua A", result.get(0).getNomeRua());
            verify(repository).findAll();
            verify(mappers).toList(enderecos);
        }
    }

