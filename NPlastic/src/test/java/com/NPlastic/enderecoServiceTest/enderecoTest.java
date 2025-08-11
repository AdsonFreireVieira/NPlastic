package com.NPlastic.enderecoServiceTest;

import com.NPlastic.Entity.Clientes;
import com.NPlastic.Entity.Endereco;
import com.NPlastic.dto.enderecoDto.enderecoRequest;
import com.NPlastic.dto.enderecoDto.enderecoResponse;
import com.NPlastic.mappers.EnderecoMappers;
import com.NPlastic.repository.EnderecoRepository;
import com.NPlastic.services.EnderecoService.EnderecoServiceImpl;
import org.hibernate.internal.util.collections.CollectionHelper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class enderecoTest {

    @InjectMocks
    private EnderecoServiceImpl service;

    @Mock
    private EnderecoMappers mappers;

    @Mock
    private EnderecoRepository repository;

    @Mock
    private Clientes cliente;


    @Test
    @DisplayName("CriarEndereco")
    void CriarEndereco() {

        Clientes clientes = new Clientes(2, "NLimp", "NLimp@Gmail.com", "sewqrewew");

        Endereco enderecoS = new Endereco(2, "ruaErmelinno", 223, "SP", "0987873", "bairro do Limao", clientes);
        enderecoResponse enderecoResponse = new enderecoResponse("ruaErmelinno", 223, "SP", "0987873", "bairro do Limao", clientes);
        enderecoRequest enderecoRe = new enderecoRequest(2, "ruaErmelinno", 223, "SP", "0987873", "bairro do Limao", clientes);

        when(mappers.toEntity(enderecoRe)).thenReturn(enderecoS);
        when(repository.save(enderecoS)).thenReturn(enderecoS);
        when(mappers.toDto(enderecoS)).thenReturn(enderecoResponse);

        enderecoResponse enderecoResult = service.novo(enderecoRe);

        assertEquals("ruaErmelinno", enderecoResult.getNomeRua());
        assertEquals(223, enderecoResult.getNumero());
    }


    @Test
    @DisplayName("Deve atualizar endereço corretamente")
    void deveAtualizarEndereco() {

        int id = 1;

        Clientes cliente = new Clientes(1, "Nome", "email@teste.com", "senha");

        Endereco enderecoExistente = new Endereco(id, "Rua A", 100, "SP", "12345678", "Bairro X", cliente);

        enderecoRequest request = new enderecoRequest(id, "Rua B", 101, "RJ", "87654321", "Bairro Y", cliente);

        enderecoResponse response = new enderecoResponse("Rua B", 101, "RJ", "87654321", "Bairro Y", cliente);

        when(repository.findById(id)).thenReturn(Optional.of(enderecoExistente));

        doAnswer(invocation -> {
            enderecoRequest req = invocation.getArgument(0);
            Endereco end = invocation.getArgument(1);

            end.setNomeRua(req.getNomeRua());
            end.setNumero(req.getNumero());
            end.setCep(req.getCep());
            end.setBairro(req.getBairro());

            return null;
        }).when(mappers).atualizarEntity(any(enderecoRequest.class), any(Endereco.class));

        when(repository.save(enderecoExistente)).thenReturn(enderecoExistente);

        when(mappers.toDto(enderecoExistente)).thenReturn(response);

        Optional<enderecoResponse> resultado = service.atualizar(id, request);

        assertTrue(resultado.isPresent());
        assertEquals("Rua B", resultado.get().getNomeRua());
        assertEquals(101, resultado.get().getNumero());
        assertEquals("87654321", resultado.get().getCep());
        assertEquals("Bairro Y", resultado.get().getBairro());

        verify(repository).findById(id);
        verify(mappers).atualizarEntity(request, enderecoExistente);
        verify(repository).save(enderecoExistente);
        verify(mappers).toDto(enderecoExistente);
    }

    @Test
    @DisplayName("Buscar Por Id")
    void buscarPorId() {


        int id = 2;
        Clientes cliente = new Clientes(1, "Nome", "email@teste.com", "senha");

        Endereco enderecoExistente = new Endereco(2, "Rua A", 100, "SP", "12345678", "Bairro X", cliente);


        enderecoResponse response = new enderecoResponse("Rua A", 101, "RJ", "87654321", "Bairro Y", cliente);

        when(repository.findById(id)).thenReturn(Optional.of(enderecoExistente));
        when(mappers.toDto(enderecoExistente)).thenReturn(response);

        Optional<enderecoResponse> result = service.buscarPorId(id);

        assertTrue(result.isPresent());
        assertEquals("Rua A", result.get().getNomeRua());

        verify(repository).findById(id);
        verify(mappers).toDto(enderecoExistente);
    }

    @Test
    @DisplayName("Deletar Usuario")
    void deveDeletarEnderecoComSucesso() {
        int id = 2;
        Endereco enderecoExistente = new Endereco(id, "Rua A", 100, "SP", "12345678", "Bairro X", null);

        when(repository.findById(id)).thenReturn(Optional.of(enderecoExistente));

        // Act
        service.deletar(id);

        // Assert
        verify(repository).findById(id);
        verify(repository).deleteById(id);
    }
    }



