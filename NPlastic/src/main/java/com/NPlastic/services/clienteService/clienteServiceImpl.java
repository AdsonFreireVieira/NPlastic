package com.NPlastic.services.clienteService;

import com.NPlastic.Entity.Clientes;
import com.NPlastic.Mappers.ClienteMapper;
import com.NPlastic.dto.clientesDto.clientesRequest;
import com.NPlastic.dto.clientesDto.clientesResponse;
import com.NPlastic.repository.ClientesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class clienteServiceImpl implements ClienteService {

  private final ClientesRepository clientesRepository;

  private final ClienteMapper clienteMapper;


    public clienteServiceImpl(ClientesRepository clientesRepository, ClienteMapper clienteMapper) {
        this.clientesRepository = clientesRepository;
        this.clienteMapper = clienteMapper;
    }

    @Override
    public clientesResponse novoCliente(clientesRequest clienteRequest) {


            Clientes cliente = clienteMapper.toEntity(clienteRequest);

            return clienteMapper.toDTo(clientesRepository.save(cliente));


    }

    @Override
    public Optional<clientesResponse> alterarCliente(clientesRequest clientesRequest, int id) {

        Clientes cliente = clientesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Não localizado"));


        Clientes clienteAtualizado = clientesRepository.save(cliente);

        return Optional.of(clienteMapper.toDTo(clienteAtualizado));

    }

    @Override
    public List<clientesResponse> listarClientes() {
        return clienteMapper.toList((List<Clientes>) clientesRepository.findAll());
    }

    @Override
    public Optional<clientesResponse> buscarPorId(int id) {
        return clientesRepository.findById(id).map(clienteMapper::toDTo);

    }

    @Override
    public String deletarCliente(int id) {
        clientesRepository.deleteById(id);
        return "Removido";

    }
}
