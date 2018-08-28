package principal.dao;

public class JDBCFactory implements DaoFactory{

	@Override
	public AreaDAO areaDao() {
		return new AreaJDBC();
	}

}
