package com.NPlastic.service.ServiceUser;

import com.NPlastic.Dto.ClientesDto.ClientesRequest;
import com.NPlastic.Dto.ClientesDto.ClientesResponse;
import com.NPlastic.Entity.Clientes;
import java.util.List;

public interface ClientesService {

    public ClientesResponse criar(ClientesRequest clientesRequest);

    public ClientesResponse update(ClientesRequest clientesRequest);

    public List<ClientesResponse> ListarUser();

    public void deletarUser(int id);

    public ClientesResponse BuscarPorID(int id);
}
