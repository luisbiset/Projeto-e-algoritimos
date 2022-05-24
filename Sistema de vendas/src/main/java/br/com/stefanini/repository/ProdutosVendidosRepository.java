package br.com.stefanini.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.stefanini.Entity.ProdutoVendido;


public interface ProdutosVendidosRepository extends CrudRepository<ProdutoVendido, Integer> {

}
