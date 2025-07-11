package com.NPlastic.mappers;

import com.NPlastic.Entity.Endereco;
import com.NPlastic.dto.enderecoDto.enderecoRequest;
import com.NPlastic.dto.enderecoDto.enderecoResponse;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(   componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface EnderecoMappers {

    EnderecoMappers INSTANCE = Mappers.getMapper(EnderecoMappers.class);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "nomeRua", target = "nomeRua" , conditionQualifiedByName = "naoNulo")
    @Mapping(source = "numero", target = "numero" ,conditionQualifiedByName = "naoNulo")
    @Mapping(source = "cidade", target = "cidade" , conditionQualifiedByName = "naoNulo")
    @Mapping(source = "cep", target = "cep" ,conditionQualifiedByName = "naoNulo")
    @Mapping(source = "bairro", target = "bairro" , conditionQualifiedByName = "naoNulo")
    @Mapping(source = "clientes", target = "clientes" , conditionQualifiedByName = "naoNulo")
    Endereco toEntity(enderecoRequest enderecoRequest);

    @Mapping(source = "nomeRua", target = "nomeRua")
    @Mapping(source = "numero", target = "numero")
    @Mapping(source = "cidade", target = "cidade")
    @Mapping(source = "cep", target = "cep")
    @Mapping(source = "bairro", target = "bairro")
    @Mapping(source = "clientes", target = "clientes")

    enderecoResponse toDto(Endereco endereco);

    void atualizarEntity(enderecoRequest request, @MappingTarget Endereco endereco);

    List<enderecoResponse> toList(List<Endereco> enderecoList);

    @Condition
    @Named("naoNulo")
    default boolean naoNullo(Object valor){
        if(valor instanceof  String){
            return  valor !=null && !((String) valor).trim().isEmpty();
        }
        return  valor != null;
    }
}






