package com.NPlastic.service.ServiceUser;

import com.NPlastic.Entity.Clientes;
import com.NPlastic.dto.dtoUser.ClientesRequestDTO;
import com.NPlastic.dto.dtoUser.ClientesResponseDTO;
import com.NPlastic.mapper.Clientesmapper;

import com.NPlastic.repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClienteServiceEmpl implements ClientesService{

    @Autowired
    private ClientesRepository repository;

    @Override
    public ClientesResponseDTO criar(ClientesRequestDTO clientesRequestDTO) {

        Clientes cliente = Clientesmapper.INSTANCE.toCliente(clientesRequestDTO);

        return  Clientesmapper.INSTANCE.toResponseDto(repository.save(cliente));
    }

    @Override
    public ClientesResponseDTO update(ClientesRequestDTO userRequestDTO) {

        Clientes cliente = Clientesmapper.INSTANCE.toCliente(userRequestDTO);
        return  Clientesmapper.INSTANCE.toResponseDto(repository.save(cliente));
    }

    @Override
    public List<ClientesResponseDTO> ListarUser() {
        return Clientesmapper.INSTANCE.toListResponseDto((List<Clientes>)repository.findAll());
    }

    @Override
    public void deletarUser(int id) {

          repository.deleteById(id);
    }

    @Override
    public ClientesResponseDTO BuscarPorID(int id) {
        return Clientesmapper.INSTANCE.toResponseDto(repository.findById(id).orElse(null));
    }
}
