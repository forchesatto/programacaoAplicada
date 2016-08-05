package br.edu.unoesc.jdbcOO.dao;

import java.util.Collection;

import br.edu.unoesc.jdbcOO.model.Endereco;

public interface EnderecoDAO extends CrudDAO<Endereco> {

	Collection<Endereco> getPorRua(String rua);
}
