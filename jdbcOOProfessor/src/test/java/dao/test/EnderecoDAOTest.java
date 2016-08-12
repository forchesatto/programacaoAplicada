package dao.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import br.edu.unoesc.jdbcOO.dao.EnderecoDAO;
import br.edu.unoesc.jdbcOO.dao.EnderecoJDBC;
import br.edu.unoesc.jdbcOO.model.Endereco;

public class EnderecoDAOTest {

	@Test
	public void deveInserirEnderecoNovo() {
		Endereco endereco = new Endereco();
		endereco.setBairro("Centro");
		endereco.setRua("Rua Principal");
		EnderecoDAO enderecoDAO = new EnderecoJDBC();
		enderecoDAO.inserir(endereco);
		assertNotNull(endereco.getCodigo());
		enderecoDAO.excluir(endereco.getCodigo());
	}

	@Test
	public void deveAlterarEndereco() {
		Endereco endereco = new Endereco();
		endereco.setBairro("Centro");
		endereco.setRua("Rua Principal");
		EnderecoDAO enderecoDAO = new EnderecoJDBC();
		enderecoDAO.inserir(endereco);
		endereco.setBairro("Jardins");
		enderecoDAO.alterar(endereco);
		Endereco enderecoBanco = enderecoDAO.get(endereco.getCodigo());
		assertEquals("Jardins", enderecoBanco.getBairro());
		enderecoDAO.excluir(enderecoBanco.getCodigo());
	}

}
