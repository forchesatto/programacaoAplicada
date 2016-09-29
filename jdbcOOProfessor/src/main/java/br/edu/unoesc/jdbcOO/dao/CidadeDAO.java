package br.edu.unoesc.jdbcOO.dao;

import java.util.List;

import br.edu.unoesc.jdbcOO.model.Cidade;

public interface CidadeDAO extends CrudDAO<Cidade> {

	List<Cidade> todosComUf();
}
