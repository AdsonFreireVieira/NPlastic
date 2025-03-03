package com.NPlastic.service.ServiceUser;

import com.NPlastic.dto.dtoUser.UserRequestDTO;
import com.NPlastic.dto.dtoUser.UserResponseDTO;

import java.util.List;

public interface userService {

    public UserResponseDTO create(UserRequestDTO userRequestDTOer);

    public UserResponseDTO update(UserRequestDTO userRequestDTO);

    public List<UserResponseDTO> ListarUser();

    public void deletarUser(int id);

    public UserResponseDTO BuscarPorID(int id);
}
