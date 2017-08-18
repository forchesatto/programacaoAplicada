package banco1.dao;

import java.util.List;

public interface CrudDao<T> {
	
	void inserir(T entidade);
	
	void alterar(T entidade);
	
	void excluir(Long codigo);
	
	List<T> listar();
	
	T get(Long codigo);

}
