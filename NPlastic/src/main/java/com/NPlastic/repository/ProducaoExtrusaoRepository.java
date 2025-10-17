package com.NPlastic.repository;

import com.NPlastic.entity.ProducaoExtrusao;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.repository.CrudRepository;

public interface ProducaoExtrusaoRepository extends CrudRepository<ProducaoExtrusao,Integer> {
}
