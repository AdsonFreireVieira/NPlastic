package com.NPlastic.repository;

import com.NPlastic.Entity.Produto;
import org.springframework.data.repository.CrudRepository;

public interface produtoRepository extends CrudRepository<Produto,Integer> {
}
