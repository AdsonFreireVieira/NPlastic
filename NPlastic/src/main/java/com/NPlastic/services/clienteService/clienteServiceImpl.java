package com.NPlastic.services.clienteService;

import com.NPlastic.Entity.Clientes;
import com.NPlastic.dto.clientesDto.clientesRequest;
import com.NPlastic.dto.clientesDto.clientesResponse;
import com.NPlastic.mappers.clientesMappers;
import com.NPlastic.repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class clienteServiceImpl implements ClienteService {

    @Autowired
    private ClientesRepository clientesRepository;
    @Autowired
    private  clientesMappers clientesMappers;


    @Override
    public clientesResponse novoCliente(clientesRequest clienteRequest) {

        Clientes cliente  = clientesMappers.toEntity(clienteRequest);
        clientesRepository.save(cliente);

        return clientesMappers.toDto(cliente);
    }

    @Override
    public clientesResponse alterarCliente(clientesRequest clientesRequest) {

        Clientes clientes = clientesMappers.toEntity(clientesRequest);

        clientesRepository.save(clientes);

        return clientesMappers.toDto(clientes);
    }

    @Override
    public List<clientesResponse> listarClientes() {
        return clientesMappers.toListDto((List<Clientes>) clientesRepository.findAll());
    }

    @Override
    public clientesResponse buscarPorId(int id) {
        return clientesMappers.toDto(clientesRepository.findById(id).orElse(null));

    }

    @Override
    public String deletarCliente(int id) {

        return "Removido";

    }
}
