package principal.dao;

public class ArquivoFactory implements DaoFactory{

	@Override
	public AreaDAO areaDao() {
		return new AreaArquivo();
	}

}
