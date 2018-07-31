package principal.dao;

import principal.model.Area;

public class AreaArquivo extends CrudArquivo<Area> implements AreaDAO {

	@Override
	protected ManipuladorArquivo<Area> criarManipulador() {
		return new ManipuladorArquivo<>("area.ser");
	}

}
