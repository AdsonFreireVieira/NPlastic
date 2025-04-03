package com.NPlastic.service.ServiceEndereco;

import com.NPlastic.Entity.Endereco;


import java.util.List;

public interface IEndereco {

    public Endereco CriarEndereco(Endereco endereco);

    public Endereco atualizarEndereco(Endereco endereco);

    public List<Endereco> listarEndereco();

    public Endereco BuscarPorId(int id);

    public void deletarEndereco(int id);
}
