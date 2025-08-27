package com.NPlastic.testeIntegracao.ClienteServiceTest;

import com.NPlastic.dto.clientesDto.clientesRequest;
import com.NPlastic.dto.clientesDto.clientesResponse;
import com.NPlastic.services.clienteService.clienteServiceImpl;
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

import static org.assertj.core.api.Assertions.assertThat;



@SpringBootTest
@Testcontainers
public class ClienteServiceTest {


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
    @Order(0)
    void testContainerRodando() {
        assertThat(postgres.isRunning()).isTrue();
    }



    int id = 5;

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


}


























