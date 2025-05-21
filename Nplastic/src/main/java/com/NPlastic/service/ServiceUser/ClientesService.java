package com.NPlastic.service.ServiceUser;

<<<<<<< HEAD
import com.NPlastic.dto.dtoUser.ClientesResponseDTO;
=======
import com.NPlastic.Dto.ClientesDto.ClientesRequest;
import com.NPlastic.Dto.ClientesDto.ClientesResponse;
import com.NPlastic.Entity.Clientes;
>>>>>>> fefb70f1e83e1e72ac672e5557ca9e1a6d65f5dc
import java.util.List;

public interface ClientesService {

    public ClientesResponse criar(ClientesRequest clientesRequest);

    public ClientesResponse update(ClientesRequest clientesRequest);

    public List<ClientesResponse> ListarUser();

    public void deletarUser(int id);

    public ClientesResponse BuscarPorID(int id);
}
