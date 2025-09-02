package com.NPlastic.testeIntegracao;

import com.NPlastic.Entity.Clientes;
import com.NPlastic.dto.clientesDto.clientesRequest;
import com.NPlastic.dto.clientesDto.clientesResponse;
import com.NPlastic.dto.enderecoDto.enderecoRequest;
import com.NPlastic.dto.enderecoDto.enderecoResponse;
import com.NPlastic.mappers.ClientesMapper;
import com.NPlastic.services.EnderecoService.EnderecoService;
import com.NPlastic.services.clienteService.ClienteService;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Testcontainers
public class EnderecoServiceTest extends AbstractIntegrationTest {

     @Autowired
    private EnderecoService serviceEndereco;
      @Autowired
      private ClientesMapper mapper;
     @Autowired
     private ClienteService serviceCliente;

    @BeforeEach
    void  setUp(){

        clientesRequest request = new clientesRequest();

        request.setNomeEmpresa("CClean");
        request.setEmail("cclean@gmail.com");
        request.setSenha("aaaa");

        serviceCliente.novoCliente(request);


    }

    @Test
    @DisplayName(" criar Novo Endereco")
    void criarNovoEndereco(){


        clientesResponse clientesRe = serviceCliente.listarClientes().get(0);

        Clientes clientes = new Clientes();

        clientes.setId(clientesRe.getId());
        clientes.setSenha(clientesRe.getSenha());
        clientes.setNomeEmpresa(clientesRe.getNomeEmpresa());
        clientes.setEmail(clientesRe.getEmail());


        enderecoRequest enderecoRe = new enderecoRequest();

        enderecoRe.setNomeRua("rua Avenida Costa Sul");
        enderecoRe.setCidade("Peruibe");
        enderecoRe.setBairro("Jardim Parque1");
        enderecoRe.setCep("89896343");
        enderecoRe.setNumero(443);
        enderecoRe.setClientes(clientes);

          enderecoResponse endResponse = serviceEndereco.novo(enderecoRe);

        assertThat(endResponse).isNotNull();
        assertThat(endResponse.getNumero()).isEqualTo(443);
        assertThat(endResponse.getNomeRua()).isEqualTo("rua Avenida Costa Sul");


    }


}
