package com.NPlastic.services.clienteService;

import com.NPlastic.Entity.Clientes;
import com.NPlastic.dto.clientesDto.clientesRequest;
import com.NPlastic.dto.clientesDto.clientesResponse;
import com.NPlastic.mappers.clientesMappers;
import com.NPlastic.repository.ClientesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class clienteServiceImpl implements ClienteService{

    private final ClientesRepository clientesRepository;



    public clienteServiceImpl(ClientesRepository clientesRepository) {
        this.clientesRepository = clientesRepository;
    }

    @Override
    public clientesResponse novoCliente(clientesRequest clienteRequest) {

        Clientes cliente  = clientesMappers.INSTANCE.toEntity(clienteRequest);
        clientesRepository.save(cliente);

        return clientesMappers.INSTANCE.ToDto(cliente);
    }

    @Override
    public clientesResponse alterarCliente(clientesRequest clientesRequest) {

        Clientes clientes = clientesMappers.INSTANCE.toEntity(clientesRequest);

        clientesRepository.save(clientes);

        return clientesMappers.INSTANCE.ToDto(clientes);
    }

    @Override
    public List<clientesResponse> listarClientes() {
        return clientesMappers.INSTANCE.toListDto((List<Clientes>) clientesRepository.findAll());
    }

    @Override
    public Optional<clientesResponse> buscarPorId(int id) {
        return clientesRepository.findById(id).map(clientesMappers.INSTANCE::ToDto);

    }

    @Override
    public String deletarCliente(int id) {

        return "Removido";

    }
}
