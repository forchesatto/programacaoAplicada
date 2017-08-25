package br.edu.unoesc.revisaoOO.dao;

public class DaoFactory {

	private static DaoFactory daoFactory;
	
	public static DaoFactory get(){
		if(daoFactory == null){
			daoFactory = new DaoFactory();
		}
		return daoFactory;
	}

	public AgenciaDAO agenciaDao() {
		return new AgenciaJDBC();
	}
	
	public ClienteDAO clienteDao() {
		return new ClienteJDBC();
	}
	
}
