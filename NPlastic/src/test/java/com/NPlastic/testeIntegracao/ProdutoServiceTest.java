package com.NPlastic.testeIntegracao;

import com.NPlastic.dto.produtoDto.produtoRequest;
import com.NPlastic.dto.produtoDto.produtoResponse;
import com.NPlastic.services.produtoService.produtoServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@Testcontainers
public class ProdutoServiceTest extends AbstractIntegrationTest{

    @Autowired
    private produtoServiceImpl  service;

     @BeforeEach
     void setUp(){

         produtoRequest requestCadastrar = new produtoRequest();

         requestCadastrar.setCor("Preto");
         requestCadastrar.setNome("Plastico");
         requestCadastrar.setValidade("Indeterminado");
         requestCadastrar.setPeso(5.00);
         requestCadastrar.setMedida("75 X 105");

         service.cadastrarNovo(requestCadastrar);

              }

    @DisplayName("Atualizar Produto")
    @Test
    void atualizarProduto(){

         produtoResponse produtoSalvo = service.listarProduto().get(0);

         produtoRequest requestAtualizar = new produtoRequest();

         requestAtualizar.setCor("Amarelo");
         requestAtualizar.setMedida("90X105");


         Optional<produtoResponse> produtoResult = service.alterarProduto(requestAtualizar , produtoSalvo.getId());

         assertThat(produtoResult).isNotNull();
         assertThat(produtoResult.get().getCor()).isEqualTo("Amarelo");
     assertThat(produtoResult.get().getMedida()).isEqualTo("90X105");
     assertThat(produtoResult.get().getValidade()).isEqualTo("Indeterminado");

    }
}
