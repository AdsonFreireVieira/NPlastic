package com.NPlastic.service.ServiceUser;

import com.NPlastic.dto.dtoUser.ClientesResponseDTO;
import java.util.List;

public interface ClientesService {

    public ClientesResponseDTO criar(ClientesResponseDTO clientesResponseDTO);

    public ClientesResponseDTO update(ClientesResponseDTO clientesResponseDTO);

    public List<ClientesResponseDTO> ListarUser();

    public void deletarUser(int id);

    public ClientesResponseDTO BuscarPorID(int id);
}
