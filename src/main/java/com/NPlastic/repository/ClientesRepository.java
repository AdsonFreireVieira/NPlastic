package com.NPlastic.repository;

import com.NPlastic.Entity.Clientes;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientesRepository extends CrudRepository<Clientes,Integer>{
}
