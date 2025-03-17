package com.NPlastic.mapper;



import com.NPlastic.Entity.Clientes;
import com.NPlastic.dto.dtoUser.ClientesRequestDTO;
import com.NPlastic.dto.dtoUser.ClientesResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


import java.util.List;

@Mapper(componentModel = "spring")
public interface  Clientesmapper {

    Clientesmapper INSTANCE = Mappers.getMapper(Clientesmapper.class);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "nome", target = "nome")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "telefone", target = "telefone")
    @Mapping(source = "senha", target = "senha")
    @Mapping(source = "data", target = "data")
    Clientes toCliente(ClientesRequestDTO userRequestDTO);

    @Mapping(source = "nome", target = "nome")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "telefone", target = "telefone")
    @Mapping(source = "senha", target = "senha")
    @Mapping(source = "data", target = "data")

   ClientesResponseDTO toResponseDto(Clientes user);


     List<ClientesResponseDTO> toListResponseDto(List<Clientes>  cliente);

        }







