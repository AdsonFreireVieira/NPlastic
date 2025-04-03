package com.NPlastic.service.ServiceUser;

import com.NPlastic.Entity.Clientes;
import com.NPlastic.dto.dtoUser.ClientesResponseDTO;
import java.util.List;

public interface ClientesService {

    public Clientes criar(Clientes clientes);

    public Clientes update(Clientes clientesResponseDTO);

    public List<Clientes> ListarUser();

    public void deletarUser(int id);

    public Clientes BuscarPorID(int id);
}
