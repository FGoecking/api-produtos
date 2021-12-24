package com.example.projetospring.repository;

import com.example.projetospring.model.Produto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Long> {

    Produto findByCodigo(String codigo);
}
