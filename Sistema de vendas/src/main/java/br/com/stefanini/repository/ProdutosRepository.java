package br.com.stefanini.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.stefanini.Entity.Produto;


public interface ProdutosRepository extends CrudRepository<Produto, Integer> {

    
    Produto findFirstByCodigo(String codigo);
}
