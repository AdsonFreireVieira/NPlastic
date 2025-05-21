package com.NPlastic.service.ServiceEndereco;

<<<<<<< HEAD
import com.NPlastic.dto.dtoEndereco.EnderecoResponse;
=======
import com.NPlastic.Dto.EnderecoDto.EnderecoRequest;
import com.NPlastic.Dto.EnderecoDto.EnderecoResponse;
import com.NPlastic.Entity.Endereco;

>>>>>>> fefb70f1e83e1e72ac672e5557ca9e1a6d65f5dc

import java.util.List;

public interface    IEndereco {

    public EnderecoResponse CriarEndereco(EnderecoRequest enderecoRequest);

    public EnderecoResponse atualizarEndereco(EnderecoRequest enderecoRequest);

    public List<EnderecoResponse> listarEndereco();

    public EnderecoResponse BuscarPorId(int id);

    public void deletarEndereco(int id);
}
