package com.NPlastic.service.ServiceUser;

import com.NPlastic.Entity.Clientes;
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
    public ClientesResponseDTO criar(ClientesResponseDTO clientesResponseDTO) {

        Clientes cliente = Clientesmapper.INSTANCE.toEntity(clientesResponseDTO);

        return  Clientesmapper.INSTANCE.toDTO(repository.save(cliente));
    }

    @Override
    public ClientesResponseDTO update(ClientesResponseDTO clientesResponseDTO) {

        Clientes cliente = Clientesmapper.INSTANCE.toEntity(clientesResponseDTO);
        return  Clientesmapper.INSTANCE.toDTO(repository.save(cliente));
    }

    @Override
    public List<ClientesResponseDTO> ListarUser() {
        return Clientesmapper.INSTANCE.toDTOLIst((List<Clientes>)repository.findAll());
    }

    @Override
    public void deletarUser(int id) {

          repository.deleteById(id);
    }

    @Override
    public ClientesResponseDTO BuscarPorID(int id) {
        return Clientesmapper.INSTANCE.toDTO(repository.findById(id).orElse(null));
    }
}
