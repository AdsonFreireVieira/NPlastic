package com.NPlastic.services.clienteService;

import com.NPlastic.Entity.Clientes;
import com.NPlastic.dto.clientesDto.clientesRequest;
import com.NPlastic.dto.clientesDto.clientesResponse;
import com.NPlastic.mappers.clientesMappers;
import com.NPlastic.repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class clienteServiceImpl implements ClienteService {

    @Autowired
    private ClientesRepository clientesRepository;
    @Autowired
    private  clientesMappers clientesMappers;


    @Override
    public clientesResponse novoCliente(clientesRequest clienteRequest) {

       try{

            Clientes cliente = clientesMappers.toEntity(clienteRequest);

            return clientesMappers.toDto(clientesRepository.save(cliente));

       }catch (Exception e){
           throw new RuntimeException("Erro");
       }
    }

    @Override
    public Optional<clientesResponse> alterarCliente(clientesRequest clientesRequest) {

        Clientes clientes = clientesMappers.toEntity(clientesRequest);

        clientesResponse response = clientesMappers.toDto(clientesRepository.save( clientes));

        return Optional.ofNullable(response);

    }

    @Override
    public List<clientesResponse> listarClientes() {
        return clientesMappers.toListDto((List<Clientes>) clientesRepository.findAll());
    }

    @Override
    public Optional<clientesResponse> buscarPorId(int id) {
        return clientesMappers.toDto(clientesRepository.findById(id).orElse(null));

    }

    @Override
    public Boolean deletarCliente(int id) {

        return "Removido";

    }
}
