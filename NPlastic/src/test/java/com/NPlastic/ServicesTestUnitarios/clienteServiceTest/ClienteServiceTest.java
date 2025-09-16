package com.NPlastic.ServicesTestUnitarios.clienteServiceTest;

import com.NPlastic.Entity.Clientes;
import com.NPlastic.dto.clientesDto.clientesRequest;
import com.NPlastic.dto.clientesDto.clientesResponse;
import com.NPlastic.mappers.ClientesMapper;
import com.NPlastic.repository.ClientesRepository;
import com.NPlastic.services.clienteService.ClienteService;
import com.NPlastic.services.clienteService.clienteServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ClienteServiceTest {

    @InjectMocks
    private clienteServiceImpl service;

    @Mock
    private ClientesMapper mappers;

    @Mock
    private ClientesRepository repository;

    @Test
    @DisplayName("SalvarUsuario")
    void TestarSaveUsuario() {

        clientesRequest request = new clientesRequest(1, "NLimp", "NLipm@Gmail", "qsdqwd3dwsd");
        clientesResponse response = new clientesResponse(1,"NLimp", "NLipm@Gmail", "qsdqwd3dwsd");
        Clientes clientes = new Clientes(1, "NLimp", "NLipm@Gmail", "qsdqwd3dwsd");
        Clientes clientesSalvo = new Clientes(1, "NLimp", "NLipm@Gmail", "qsdqwd3dwsd");


        when(mappers.toEntity(request)).thenReturn(clientes);
        when(repository.save(clientes)).thenReturn(clientesSalvo);
        when(mappers.toDto(clientesSalvo)).thenReturn(response);


        clientesResponse clientResult = service.novoCliente(request);

        assertEquals("NLimp", clientResult.getNomeEmpresa());
        assertEquals("NLipm@Gmail", clientResult.getEmail());

    }

    @Test
    @DisplayName("TestaAlteracaoUsuario")
    void deveAlterarClienteComSucesso() {
                int id = 1;

                clientesRequest request = new clientesRequest(id, "Limpol", "gmail.limpol", "udhdudud");

                Clientes clienteExistente = new Clientes(id, "NLimp", "NLimp@email.com", "senhaAntiga");

                Clientes clienteAtualizado = new Clientes(id, "Limpol", "gmail.limpol", "udhdudud");

                clientesResponse response = new clientesResponse(id,"Limpol", "gmail.limpol", "udhdudud");

                when(repository.findById(id)).thenReturn(Optional.of(clienteExistente));
                when(repository.save(any(Clientes.class))).thenReturn(clienteAtualizado);
                when(mappers.toDto(clienteAtualizado)).thenReturn(response);

                Optional<clientesResponse> resultado = service.alterarCliente(request, id);

                assertTrue(resultado.isPresent());
                assertEquals("Limpol", resultado.get().getNomeEmpresa());
                assertEquals("gmail.limpol", resultado.get().getEmail());
                assertEquals("udhdudud", resultado.get().getSenha());

                verify(mappers).atualizarCliente(request, clienteExistente);
            }

            @Test
            @DisplayName("testeListClientes")
    void testarListClientes(){

        List<clientesResponse> responseList = new ArrayList<>();

        Clientes clientes = new Clientes(1,"NLimp","Nlimp@Gmail.com","sadfrffsd");
        Clientes clientes1 = new Clientes(1,"NLimp","Nlimp@Gmail.com","sadfrffsd");

        clientesResponse response = new clientesResponse(1,"NLimp","Nlimp@Gmail.com","sadfrffsd");
        clientesResponse response1 = new clientesResponse(1,"NLimp","Nlimp@Gmail.com","sadfrffsd");


                List<Clientes> listClientes = new ArrayList<>();
                listClientes.add(clientes);
                listClientes.add(clientes1);

        List<clientesResponse> listResponse = new ArrayList<>();

        listResponse.add(response1);
        listResponse.add(response);

        when(repository.findAll()).thenReturn(listClientes);
        when(mappers.toListDto(listClientes)).thenReturn(listResponse);

        List<clientesResponse> listResult = service.listarClientes();

        assertEquals(2 , listResult.size());


            }
        @Test
        @DisplayName("Retorna Por ID")
        void testarBuscarPorId(){

        int id =1;
        Clientes cliente = new Clientes(1,"NLimp","NLimp@Gmail","wecdcdasd");

        clientesResponse response = new clientesResponse(1,"NLimp","NLimp@Gmail","wedcdccc");

        when(repository.findById(id)).thenReturn(Optional.of(cliente));
        when(mappers.toDto(cliente)).thenReturn(response);


           Optional<clientesResponse> responseResult = service.buscarPorId(id);

           assertEquals("NLimp",responseResult.get().getNomeEmpresa());


        }

        @Test
        @DisplayName("testaDeletarUsuario")

       void testarDeleteUsuario(){

        int id =1;
        Clientes cliente = new Clientes(1,"NLimp","NLimp@gmail.com","dassdfdsf");

        String msg = service.deletarCliente(id);

        assertEquals("Removido",msg);



        }

            }




