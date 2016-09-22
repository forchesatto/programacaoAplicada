package br.edu.unoesc.jdbcOO.dao;

import java.util.List;

import br.edu.unoesc.jdbcOO.model.UF;

public interface UFDAO extends CrudDAO<UF> {

	List<UF> getPorNome(String nome);

}
