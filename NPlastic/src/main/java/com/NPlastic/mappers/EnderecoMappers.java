package com.NPlastic.mappers;

import com.NPlastic.Entity.Endereco;
import com.NPlastic.dto.enderecoDto.enderecoRequest;
import com.NPlastic.dto.enderecoDto.enderecoResponse;
import org.mapstruct.*;

import java.util.List;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface EnderecoMappers {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "nomeRua", target = "nomeRua")
    @Mapping(source = "numero", target = "numero")
    @Mapping(source = "cidade", target = "cidade")
    @Mapping(source = "cep", target = "cep")
    @Mapping(source = "bairro", target = "bairro")
    @Mapping(source = "clientes", target = "clientes")
    Endereco toEntity(enderecoRequest enderecoRequest);

    @Mapping(source = "nomeRua", target = "nomeRua" )
    @Mapping(source = "numero", target = "numero")
    @Mapping(source = "cidade", target = "cidade")
    @Mapping(source = "cep", target = "cep")
    @Mapping(source = "bairro", target = "bairro")
    @Mapping(source = "clientes", target = "clientes")
    enderecoResponse toDto(Endereco endereco);

    @Mapping(source = "nomeRua", target = "nomeRua", conditionQualifiedByName = "valorNaoNulo")
    @Mapping(source = "numero", target = "numero", conditionQualifiedByName = "valorNaoNulo")
    @Mapping(source = "cidade", target = "cidade", conditionQualifiedByName = "valorNaoNulo")
    @Mapping(source = "cep", target = "cep", conditionQualifiedByName = "valorNaoNulo")
    @Mapping(source = "bairro", target = "bairro", conditionQualifiedByName = "valorNaoNulo")
    @Mapping(source = "clientes", target = "clientes", conditionQualifiedByName = "valorNaoNulo")
    void atualizarEntity(enderecoRequest request, @MappingTarget Endereco endereco);

    List<enderecoResponse> toList(List<Endereco> enderecoList);

    @Condition
    @Named("valorNaoNulo")
    default boolean valorNaoNulo(Object valor) {
        if (valor instanceof String) {
            return valor != null && !((String) valor).trim().isEmpty();
        }
        return valor != null;
    }
}
