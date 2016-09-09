package br.edu.unoesc.jdbcOO.factory;

import br.edu.unoesc.jdbcOO.conexao.ConexaoMysqlProducao;
import br.edu.unoesc.jdbcOO.dao.CidadeDAO;
import br.edu.unoesc.jdbcOO.dao.CidadeJDBC;
import br.edu.unoesc.jdbcOO.dao.EnderecoDAO;
import br.edu.unoesc.jdbcOO.dao.EnderecoJDBC;
import br.edu.unoesc.jdbcOO.dao.UFDAO;
import br.edu.unoesc.jdbcOO.dao.UFJDBC;

public class DAOFactory {

	private static DAOFactory factory;
	
	/**
	 * Pega a fabrica de DAO, instância única para todo mundo.
	 * Padrão Singleton simples.
	 * @return
	 */
	public static DAOFactory get(){
		if(factory == null){
			factory = new DAOFactory();
		}
		return factory;
	}
	
	/**
	 * Cria um DAO e retorna para quem chamou a interface DAO.
	 * @return EnderecoDAO
	 */
	public EnderecoDAO enderecoDAO(){
		return new EnderecoJDBC(new ConexaoMysqlProducao());
	}
	
	public CidadeDAO cidadeDAO(){
		return new CidadeJDBC(new ConexaoMysqlProducao());
	}
	
	public UFDAO ufDAO(){
		return new UFJDBC(new ConexaoMysqlProducao());
	}
	
}
