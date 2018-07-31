package conexaoJDBC.dao;

import java.util.List;

public interface GenericDAO<T> {

	void inserir(T dado);
	
	void alterar(T dado);
	
	void excluir(Integer codigo);
	
	List<T> listar();
	
	T buscar(Integer codigo);
}
