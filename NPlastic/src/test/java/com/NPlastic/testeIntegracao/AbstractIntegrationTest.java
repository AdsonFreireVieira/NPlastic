package com.NPlastic.testeIntegracao;

import com.NPlastic.dto.produtoDto.produtoRequest;
import com.NPlastic.services.clienteService.clienteServiceImpl;
import com.NPlastic.services.produtoService.produtoServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;

public  abstract  class AbstractIntegrationTest {

    @Container
    private static final PostgreSQLContainer<?> postgres = new
            PostgreSQLContainer<>("postgres:14")
            .withDatabaseName("testdb")
            .withUsername("user")
            .withPassword("password");


    @DynamicPropertySource
    static void configureProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgres::getJdbcUrl);
        registry.add("spring.datasource.username", postgres::getUsername);
        registry.add("spring.datasource.password", postgres::getPassword);
    }


}
