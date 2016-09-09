package dao.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import br.edu.unoesc.jdbcOO.dao.UFDAO;
import br.edu.unoesc.jdbcOO.factory.DAOFactory;
import br.edu.unoesc.jdbcOO.model.UF;

public class UFDAOTest {

	@Test
	public void deveInserirUFNova() {
		UF UF = new UF();
		UF.setNome("São Paulo");
		UFDAO UFDAO = DAOFactory.get().ufDAO();
		UFDAO.inserir(UF);
		assertNotNull(UF.getCodigo());
		UFDAO.excluir(UF.getCodigo());
	}

	@Test
	public void deveAlterarUF() {
		UF UF = new UF();
		UF.setNome("Rio de Janeiro");
		UFDAO UFDAO = DAOFactory.get().ufDAO();
		UFDAO.inserir(UF);
		UF.setNome("Rio Grande do Sul");
		UFDAO.alterar(UF);
		UF UFBanco = UFDAO.get(UF.getCodigo());
		assertEquals("Rio Grande do Sul", UFBanco.getNome());
		UFDAO.excluir(UFBanco.getCodigo());
	}
	
}
