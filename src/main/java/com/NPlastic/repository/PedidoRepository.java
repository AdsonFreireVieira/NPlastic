package com.NPlastic.repository;

import com.NPlastic.Entity.Pedido;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface PedidoRepository extends CrudRepository<Pedido,Integer> {


}
