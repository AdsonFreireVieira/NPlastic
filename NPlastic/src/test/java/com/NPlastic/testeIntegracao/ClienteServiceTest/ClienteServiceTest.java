package com.NPlastic.testeIntegracao.ClienteServiceTest;

import com.NPlastic.Entity.Clientes;
import com.NPlastic.dto.clientesDto.clientesRequest;
import com.NPlastic.dto.clientesDto.clientesResponse;
import com.NPlastic.mappers.ClientesMapper;
import com.NPlastic.services.clienteService.clienteServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;



@SpringBootTest
@Testcontainers
public class ClienteServiceTest {

    int id = 2;

    @Container
    private static final PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:14")
            .withDatabaseName("testdb")
            .withUsername("user")
            .withPassword("password");


    @DynamicPropertySource
    static void configureProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgres::getJdbcUrl);
        registry.add("spring.datasource.username", postgres::getUsername);
        registry.add("spring.datasource.password", postgres::getPassword);
    }

    @Test
    @DisplayName("Postgres Container OK")
    void testContainerRodando() {
        assertThat(postgres.isRunning()).isTrue();
    }

    @BeforeEach
    void setUp() {

        clientesRequest request = new clientesRequest();

        request.setNomeEmpresa("NLimp");
        request.setEmail("NLimp@gmail.com");
        request.setSenha("aaaaa");

        clienteService.novoCliente(request);

    }

    @Autowired
    private clienteServiceImpl clienteService;

    @Test
    void deveCriarCliente() {

        clientesRequest request = new clientesRequest();
        request.setNomeEmpresa("NLimp");
        request.setEmail("NLimp@Gmail.com");
        clientesResponse response = clienteService.novoCliente(request);

        assertThat(response).isNotNull();
        assertThat(response.getNomeEmpresa()).isEqualTo("NLimp");
        assertThat(response.getEmail()).isEqualTo("NLimp@Gmail.com");

    }

    @Test
    @DisplayName("Retorna Lista Clientes")
    void deveRetornarListaClientes() {

        clientesRequest cliente1 = new clientesRequest();

        cliente1.setNomeEmpresa("Empresa1");
        cliente1.setEmail("Empresa1@Gmail");

        clientesRequest cliente2 = new clientesRequest();

        cliente2.setNomeEmpresa("Empresa2");
        cliente2.setEmail("Empresa2@Gmail");

        clienteService.novoCliente(cliente1);
        clienteService.novoCliente(cliente2);

        List<clientesResponse> responseList = clienteService.listarClientes();

        assertThat(responseList.size()).isEqualTo(3);
        assertThat(responseList.get(1).getEmail()).isEqualTo("Empresa1@Gmail");

        assertThat(responseList.get(2).getEmail()).isEqualTo("Empresa2@Gmail");


    }

    @Test
    @DisplayName("deve Atualizar")
    void atualizaCliente() {


        List<clientesResponse> listResponses = clienteService.listarClientes();

        int idCadastrado = listResponses.get(0).getId();


        clientesRequest requestAtualizar = new clientesRequest();

        requestAtualizar.setNomeEmpresa("NLimpo");
        requestAtualizar.setEmail("NLimpol@Gmail.com");


        Optional<clientesResponse> atualizado = clienteService.alterarCliente(requestAtualizar, idCadastrado);


        assertThat(requestAtualizar).isNotNull();
        assertThat(requestAtualizar.getNomeEmpresa()).isEqualTo("NLimpo");
        assertThat(requestAtualizar.getEmail()).isEqualTo("NLimpol@Gmail.com");

    }

    @Test
    @DisplayName("Deletar Usuario")
    void deletarUsuario(){

        List<clientesResponse> listResponse = clienteService.listarClientes();

        int id = listResponse.get(0).getId();

       String msg= clienteService.deletarCliente(id);

       assertThat("Removido").isEqualTo(msg);



    }

}