package banco1.dao;

import banco1.conexao.Conexao;
import banco1.conexao.ConexaoProducao;
import banco1.conexao.ConexaoTeste;

public class DaoFactory {

	private static DaoFactory daoFactory;
	
	Conexao conexao = new ConexaoProducao();
	
	public static DaoFactory get(){
		if(daoFactory == null){
			daoFactory = new DaoFactory();
			String ambiente = System.getProperty("ambiente");
			if("test".equals(ambiente)){
				daoFactory.conexao = new ConexaoTeste();
			}
		}
		return daoFactory;
	}
	
	public UfDao ufDao(){
		return new UfJdbc(conexao);
	}
}
