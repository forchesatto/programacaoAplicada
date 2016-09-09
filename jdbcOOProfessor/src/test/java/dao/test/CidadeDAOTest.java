package dao.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import br.edu.unoesc.jdbcOO.dao.CidadeDAO;
import br.edu.unoesc.jdbcOO.factory.DAOFactory;
import br.edu.unoesc.jdbcOO.model.Cidade;
import br.edu.unoesc.jdbcOO.model.UF;

public class CidadeDAOTest {

	@Test
	public void deveInserirCidadeNova() {
		Cidade cidade = new Cidade();
		cidade.setNome("Xaxim");
		cidade.setUf(new UF(1L));
		CidadeDAO cidadeDAO = DAOFactory.get().cidadeDAO();
		cidadeDAO.inserir(cidade);
		assertNotNull(cidade.getCodigo());
		cidadeDAO.excluir(cidade.getCodigo());
	}

	@Test
	public void deveAlterarCidade() {
		Cidade cidade = new Cidade();
		cidade.setNome("Chapecó");
		cidade.setUf(new UF(1L));
		CidadeDAO cidadeDAO = DAOFactory.get().cidadeDAO();
		cidadeDAO.inserir(cidade);
		cidade.setNome("Chapecó Alterado");
		cidadeDAO.alterar(cidade);
		Cidade cidadeBanco = cidadeDAO.get(cidade.getCodigo());
		assertEquals("Chapecó Alterado", cidadeBanco.getNome());
		cidadeDAO.excluir(cidadeBanco.getCodigo());
	}
	
}
