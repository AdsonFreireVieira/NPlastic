package com.NPlastic.services.clienteService;

import com.NPlastic.dto.clientesDto.clientesRequest;
import com.NPlastic.dto.clientesDto.clientesResponse;

import java.util.List;
import java.util.Optional;

public interface ClienteService {

    clientesResponse novoCliente(clientesRequest clienteRequest);

   Optional <clientesResponse> alterarCliente(clientesRequest clientesRequest);

    List<clientesResponse> listarClientes();

    Optional<clientesResponse> buscarPorId(int id);

    String


    deletarCliente(int id);
}
