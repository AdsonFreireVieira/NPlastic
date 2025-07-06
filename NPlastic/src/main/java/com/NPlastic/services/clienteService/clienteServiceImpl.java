package com.NPlastic.services.clienteService;

import com.NPlastic.Entity.Clientes;
import com.NPlastic.dto.clientesDto.clientesRequest;
import com.NPlastic.dto.clientesDto.clientesResponse;
import com.NPlastic.mappers.ClientesMapper;
import com.NPlastic.repository.ClientesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class clienteServiceImpl implements ClienteService {

  private final ClientesRepository clientesRepository;

  private final ClientesMapper clientesMapper;

    public clienteServiceImpl(ClientesRepository clientesRepository, ClientesMapper clientesMapper) {
        this.clientesRepository = clientesRepository;
        this.clientesMapper = clientesMapper;
    }

    @Override
    public clientesResponse novoCliente(clientesRequest clienteRequest) {

       try{

            Clientes cliente = clientesMapper.toEntity(clienteRequest);

            return clientesMapper.toDto(clientesRepository.save(cliente));

       }catch (Exception e){
           throw new RuntimeException("Erro");
       }
    }

    @Override
    public Optional<clientesResponse> alterarCliente(clientesRequest clientesRequest, int id) {

        Clientes clientes = clientesRepository.findById(id).
                orElseThrow(()->new RuntimeException("Nao Localizado"));

        clientesMapper.atualizarCliente(clientesRequest,clientes);


        clientesRepository.save(clientes);

        Clientes clientesAtualizado = clientesRepository.findById(id).
                orElseThrow(()->new RuntimeException("Nao Localizado"));

        return Optional.ofNullable(clientesMapper.toDto(clientesAtualizado));

    }

    @Override
    public List<clientesResponse> listarClientes() {
        return clientesMapper.toListDto((List<Clientes>) clientesRepository.findAll());
    }

    @Override
    public Optional<clientesResponse> buscarPorId(int id) {
        return clientesRepository.findById(id).map(clientesMapper::toDto);

    }

    @Override
    public String deletarCliente(int id) {

        return "Removido";

    }
}
