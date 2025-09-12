package com.NPlastic.mappers;

import ch.qos.logback.core.model.ComponentModel;
import com.NPlastic.Entity.Produto;
import com.NPlastic.dto.produtoDto.produtoRequest;
import com.NPlastic.dto.produtoDto.produtoResponse;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(   componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface produtoMapper {

    produtoMapper INSTANCE = Mappers.getMapper(produtoMapper.class);
    @Mapping(target = "id", source = "id")
    Produto toEntity(produtoRequest produtoRequest);
    @Mapping(target = "id" , source = "id")
    produtoResponse toDto(Produto produto);


    List<produtoResponse> toList(List<Produto> produtoList);

    @Mapping(source = "id", target = "id", conditionQualifiedByName = "naoNullo")
    @Mapping(source = "nome", target = "nome", conditionQualifiedByName = "naoNullo")
    @Mapping(source = "cor", target = "cor", conditionQualifiedByName = "naoNullo")
    @Mapping(source = "medida", target = "medida", conditionQualifiedByName = "naoNullo")
    @Mapping(source = "peso", target = "peso", conditionQualifiedByName = "naoNullo")
    @Mapping(source = "validade", target = "validade", conditionQualifiedByName = "naoNullo")
    Produto atualizarProduto(produtoRequest request, @MappingTarget Produto produto);


    @Named("naoNullo")
    @Condition

    default Boolean naoNullo(Object valor) {
     if( valor instanceof  String){

         return  valor != null && !((String) valor).trim().isEmpty();
     }
     return  valor!= null;
    }
}