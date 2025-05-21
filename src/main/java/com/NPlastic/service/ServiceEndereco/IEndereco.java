package com.NPlastic.service.ServiceEndereco;

import com.NPlastic.Dto.EnderecoDto.EnderecoRequest;
import com.NPlastic.Dto.EnderecoDto.EnderecoResponse;
import com.NPlastic.Entity.Endereco;


import java.util.List;

public interface    IEndereco {

    public EnderecoResponse CriarEndereco(EnderecoRequest enderecoRequest);

    public EnderecoResponse atualizarEndereco(EnderecoRequest enderecoRequest);

    public List<EnderecoResponse> listarEndereco();

    public EnderecoResponse BuscarPorId(int id);

    public void deletarEndereco(int id);
}
