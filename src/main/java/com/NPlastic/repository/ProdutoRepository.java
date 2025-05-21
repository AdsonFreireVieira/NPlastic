package com.NPlastic.repository;

import com.NPlastic.Entity.Produto;
import org.springframework.data.repository.CrudRepository;

public interface ProdutoRepository extends CrudRepository<Produto,Integer> {
}
