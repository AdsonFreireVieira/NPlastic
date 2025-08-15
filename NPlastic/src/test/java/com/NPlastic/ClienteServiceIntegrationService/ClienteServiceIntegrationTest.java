package com.NPlastic.ClienteServiceIntegrationService;

import com.NPlastic.dto.clientesDto.clientesRequest;
import com.NPlastic.dto.clientesDto.clientesResponse;
import com.NPlastic.repository.ClientesRepository;

import com.NPlastic.services.clienteService.ClienteService;
import com.NPlastic.services.clienteService.clienteServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Testcontainers
class ClienteServiceIntegrationTest {

    @Autowired
    private clienteServiceImpl clienteService;

    @Autowired
    private ClientesRepository clientesRepository;

    @Container
    public static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:15")
            .withDatabaseName("nplastic_test")
            .withUsername("postgres")
            .withPassword("postgres");

    @DynamicPropertySource
    static void configureDatasource(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgres::getJdbcUrl);
        registry.add("spring.datasource.username", postgres::getUsername);
        registry.add("spring.datasource.password", postgres::getPassword);
    }

    @BeforeEach
    void cleanDatabase() {
        clientesRepository.deleteAll();
    }

    @Test
    void deveSalvarCliente() {
        clientesResponse salvo = clienteService.novoCliente(
                new clientesRequest(1,"Adson", "adson@email.com"));

        assertEquals("Adson", salvo.getNomeEmpresa());
        assertEquals("adson@email.com", salvo.getEmail());
    }

    @Test
    void deveListarClientes() {
        clienteService.novoCliente(new clientesRequest(1,"Maria", "maria@email.com"));
        clienteService.novoCliente(new clientesRequest(4,"João", "joao@email.com"));

        List<?> clientes = (List<?>) clientesRepository.findAll();
        assertEquals(2, clientes.size());
    }

    @Test
    void deveBuscarPorId() {
        clientesResponse salvo = clienteService.novoCliente(
                new clientesRequest(3,"Lucas", "lucas@email.com"));

        var encontrado = clientesRepository.findById(3).orElseThrow();

        assertEquals("Lucas", encontrado.getNomeEmpresa());
    }

    @Test
    void deveAtualizarCliente() {
        clientesResponse salvo = clienteService.novoCliente(
                new clientesRequest(6, "Carlos", "carlos@email.com"));

        var cliente = clientesRepository.findById(6);
    }
}