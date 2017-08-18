package banco1.dao;

public class DaoFactory {

	private static DaoFactory daoFactory;
	
	public static DaoFactory get(){
		if(daoFactory == null){
			daoFactory = new DaoFactory();
		}
		return daoFactory;
	}
	
	public UfDao ufDao(){
		return new UfJdbc();
	}
}
