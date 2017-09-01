package banco1;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import banco1.dao.DaoFactory;
import banco1.dao.UfDao;
import banco1.model.Uf;

public class UfDaoTest {
	
	@Before
	public void init(){
		System.setProperty("ambiente","test");
	}
	
	@Test
	public void deveInserirUmaUf(){
		UfDao ufDao = DaoFactory.get().ufDao();
		Uf uf = new Uf();
		uf.setNome("Teste");
		ufDao.inserir(uf);
		assertNotNull(uf.getCodigo());
	}

}
