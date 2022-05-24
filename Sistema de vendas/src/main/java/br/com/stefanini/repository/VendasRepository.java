package br.com.stefanini.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.stefanini.Entity.Venda;

public interface VendasRepository extends CrudRepository<Venda, Integer> {
}
