package com.NPlastic.service.ServiceUser;

import com.NPlastic.Entity.Clientes;


import com.NPlastic.repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClienteServiceEmpl implements ClientesService{

    @Autowired
    private ClientesRepository repository;

    @Override
    public Clientes criar(Clientes clientes) {


        return  repository.save(clientes);
    }

    @Override
    public Clientes update(Clientes clientes) {

        return  repository.save(clientes);
    }

    @Override
    public List<Clientes> ListarUser() {
        return(List<Clientes>)repository.findAll();
    }

    @Override
    public void deletarUser(int id) {

          repository.deleteById(id);
    }

    @Override
    public Clientes BuscarPorID(int id) {
        return  repository.findById(id).orElse(null);
    }
}
