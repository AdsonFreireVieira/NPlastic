package com.NPlastic.repository;

import com.NPlastic.entity.Produtos;
import org.springframework.data.repository.CrudRepository;

public interface ProdutoRepository extends CrudRepository<Produtos,Integer> {

}
