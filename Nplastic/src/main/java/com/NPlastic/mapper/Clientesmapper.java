package com.NPlastic.mapper;



import com.NPlastic.Entity.Clientes;
import com.NPlastic.dto.dtoUser.ClientesResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


import java.util.List;

@Mapper(componentModel = "spring")
public interface  Clientesmapper {

    Clientesmapper INSTANCE = Mappers.getMapper(Clientesmapper.class);

    Clientes toEntity(ClientesResponseDTO clientesResponseDTO);

    ClientesResponseDTO toDTO(Clientes clientes);


     List<ClientesResponseDTO> toDTOLIst(List<Clientes>  cliente);

        }







