package br.edu.unoesc.jdbcOO.dao;

import java.util.Collection;

public interface CrudDAO<T> {

	void inserir(T objeto);
	
	void alterar(T objeto);
	
	void excluir(Long codigo);
	
	Collection<T> todos();
	
	T get(Long codigo);
	
	
}
