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

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Testcontainers
public class EnderecoServiceTest extends AbstractIntegrationTest {

     @Autowired
    private EnderecoService serviceEndereco;

     @Autowired
     private ClienteService serviceCliente;

    @BeforeEach
    void  setUp(){

        clientesRequest clientesRe = new clientesRequest();

        clientesRe.setNomeEmpresa("NCleas");
        clientesRe.setEmail("Cclean@Gmail.com");
        clientesRe.setSenha("qqqqq");

        serviceCliente.novoCliente(clientesRe);
        clientesResponse clientesSalvo = serviceCliente.listarClientes().get(0);

        Clientes clientes = new Clientes();

        clientes.setId(clientesSalvo.getId());
        clientes.setSenha(clientesSalvo.getSenha());
        clientes.setNomeEmpresa(clientesSalvo.getNomeEmpresa());
        clientes.setEmail(clientesSalvo.getEmail());


        enderecoRequest enderecoRe = new enderecoRequest();

        enderecoRe.setNomeRua("rua Avenida Costa Sul");
        enderecoRe.setCidade("Peruibe");
        enderecoRe.setBairro("Jardim Parque1");
        enderecoRe.setCep("89896343");
        enderecoRe.setNumero(443);
        enderecoRe.setClientes(clientes);

        enderecoResponse endResponse = serviceEndereco.novo(enderecoRe);



    }

    @Test
    @DisplayName("Atualiza Endereco")
    void atualizaEndereco(){

        enderecoResponse  enderecoSalvo = serviceEndereco.listarEndereco().get(0);

   enderecoRequest enderecoRe = new enderecoRequest();

   enderecoRe.setNumero(140);
   enderecoRe.setCidade("Aguas de Lindoia");
   enderecoRe.setNomeRua("Mirante Alta");



   Optional<enderecoResponse> result = serviceEndereco.atualizar(enderecoSalvo.getId(),enderecoRe);

   assertThat(result).isNotNull();
   assertThat(result.get().getNomeRua()).isEqualTo("Mirante Alta");
   assertThat(result.get().getCidade()).isEqualTo("Aguas de Lindoia");
   assertThat(result.get().getNumero()).isEqualTo(140);
    }

    @Test
    @DisplayName("deveListarEndeeco")
    void deveListar(){

        int  quantenderecoList = serviceEndereco.listarEndereco().size();

        assertThat(quantenderecoList).isEqualTo(1);

    }

    @Test
    @DisplayName("deletar Endereco")
    void deletarEndereco(){

        enderecoResponse enderecoSalvo = serviceEndereco.listarEndereco().get(0);

          serviceEndereco.deletar(enderecoSalvo.getId());

         List<enderecoResponse> enderResult = serviceEndereco.listarEndereco();

         assertThat(enderResult.isEmpty());


    }



}
