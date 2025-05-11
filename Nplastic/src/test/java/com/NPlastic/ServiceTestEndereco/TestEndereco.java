package com.NPlastic.ServiceTestEndereco;

import com.NPlastic.Dto.EnderecoDto.EnderecoRequest;
import com.NPlastic.Dto.EnderecoDto.EnderecoResponse;
import com.NPlastic.Entity.Endereco;
import com.NPlastic.Mappers.EnderecoMapper;
import com.NPlastic.repository.EnderecoRepository;
import com.NPlastic.service.ServiceEndereco.ServiceEnderecoImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class ServiceEnderecoImplTest {

        @Mock
        private EnderecoRepository repository;

        @InjectMocks
        private ServiceEnderecoImpl service;

        @BeforeEach
        void setUp() {
            MockitoAnnotations.openMocks(this);
        }

        @Test
        void criarEndereco_deveRetornarEnderecoResponse() {
            EnderecoRequest request = new EnderecoRequest();
            Endereco endereco = EnderecoMapper.INSTANCE.toEntity(request);


            when(repository.save(any(Endereco.class))).thenReturn(endereco);

            EnderecoResponse response = service.CriarEndereco(request);

            assertNotNull(response);
        }

        @Test
        void listarEndereco_deveRetornarListaDeEnderecoResponse() {
            Endereco endereco = new Endereco();
            when(repository.findAll()).thenReturn(Arrays.asList(endereco));

            List<EnderecoResponse> result = service.listarEndereco();

            assertFalse(result.isEmpty());
        }

        @Test
        void buscarPorId_deveRetornarEnderecoResponse_QuandoEncontrado() {
            Endereco endereco = new Endereco();
            when(repository.findById(1)).thenReturn(Optional.of(endereco));

            EnderecoResponse response = service.BuscarPorId(1);

            assertNotNull(response);
        }

        @Test
        void deletarEndereco_deveChamarRepositoryDeleteById() {
            service.deletarEndereco(1);

            verify(repository, times(1)).deleteById(1);
        }
    }
