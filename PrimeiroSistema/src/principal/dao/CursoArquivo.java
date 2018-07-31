package principal.dao;

import principal.model.Curso;

public class CursoArquivo extends CrudArquivo<Curso> implements CursoDAO {

	@Override
	protected ManipuladorArquivo<Curso> criarManipulador() {
		return new ManipuladorArquivo<>("cursos.ser");
	}
	
}
