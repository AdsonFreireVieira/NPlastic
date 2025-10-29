package testeestoque;

import com.NPlastic.dto.estoquedto.EstoqueRequest;
import com.NPlastic.dto.estoquedto.EstoqueResponse;
import com.NPlastic.entity.Estoque;
import com.NPlastic.entity.Produtos;
import com.NPlastic.mappers.EstoqueMappers;
import com.NPlastic.repository.EstoqueRepository;
import com.NPlastic.services.producaoestoque.EstoqueServiceImpl;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TesteEstoque {

    @Mock
    private EstoqueRepository repository;

    @Mock
    EstoqueMappers mappers;

    @InjectMocks
    private EstoqueServiceImpl serviceEstoque;



    @Test
    @DisplayName("Teste Criar Estoque")
    void criarEstoque(){

            Produtos produto = new Produtos();
            produto.setNome("Saco Para Lixo");
            produto.setMedida("90x110");
            produto.setCor("Amarelo");
            produto.setLitros("200");
            produto.setUnidades("100");
            produto.setClassificacao("P5");
            produto.setPeso(3500);

            Estoque estoque = new Estoque();
            estoque.setId(1);
            estoque.setQuantidade(14);
            estoque.setProdutos(produto);

            Estoque estoqueSalvo = new Estoque();
            estoqueSalvo.setId(1);
            estoqueSalvo.setQuantidade(14);
            estoqueSalvo.setProdutos(produto);

            EstoqueRequest request = new EstoqueRequest();
            request.setProduto(produto);
            request.setQuantidade(14);

            EstoqueResponse response = new EstoqueResponse();
            response.setProduto(produto);
            response.setQuantidade(14);

            when(mappers.toEntity(request)).thenReturn(estoque);
            when(repository.save(estoque)).thenReturn(estoqueSalvo);
            when(mappers.toDto(estoqueSalvo)).thenReturn(response);

            EstoqueResponse result = serviceEstoque.criarEstoque(request);

            assertNotNull(result);
            assertEquals("Amarelo", result.getProduto().getCor());
            assertEquals(14, result.getQuantidade());
        }

    }
