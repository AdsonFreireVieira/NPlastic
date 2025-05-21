package com.NPlastic.service.ServiceUser;

import com.NPlastic.Dto.ClientesDto.ClientesRequest;
import com.NPlastic.Dto.ClientesDto.ClientesResponse;
import com.NPlastic.Entity.Clientes;
<<<<<<< HEAD
import com.NPlastic.dto.dtoUser.ClientesResponseDTO;
import com.NPlastic.mapper.Clientesmapper;
=======
>>>>>>> fefb70f1e83e1e72ac672e5557ca9e1a6d65f5dc


import com.NPlastic.Mappers.ClientesMapper;
import com.NPlastic.repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClienteServiceEmpl implements ClientesService{

    @Autowired
    private ClientesRepository repository;

    @Override
    public ClientesResponse criar(ClientesRequest clientesRequest) {

        Clientes clientes =  ClientesMapper.INSTANCE.toEntity(clientesRequest);

        return ClientesMapper.INSTANCE.toDto(repository.save(clientes));
    }

    @Override
    public ClientesResponse update(ClientesRequest clientesRequests) {

        Clientes clientes =  ClientesMapper.INSTANCE.toEntity(clientesRequests);

        return ClientesMapper.INSTANCE.toDto(repository.save(clientes));
    }

    @Override
    public List<ClientesResponse> ListarUser() {
        return ClientesMapper.INSTANCE.convertListResponse((List<Clientes>)repository.findAll());
    }

    @Override
    public void deletarUser(int id) {

        repository.deleteById(id);
    }

    @Override
    public ClientesResponse BuscarPorID(int id) {
        return ClientesMapper.INSTANCE.toDto( repository.findById(id).orElse(null));
    }
}
