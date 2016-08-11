package dao.test;

import static org.junit.Assert.*;

import java.util.Collection;

import org.junit.Test;

import br.edu.unoesc.jdbcOO.dao.EnderecoDAO;
import br.edu.unoesc.jdbcOO.dao.EnderecoJDBC;
import br.edu.unoesc.jdbcOO.model.Endereco;

public class EnderecoDAOTest {

	
	@Test
	public void deveInserirEnderecoNovo(){
		Endereco endereco = new Endereco();
		endereco.setBairro("Centro");
		endereco.setRua("Rua Principal");
		EnderecoDAO enderecoDAO = new EnderecoJDBC();
		enderecoDAO.inserir(endereco);
		Collection<Endereco> enderecos = enderecoDAO.todos();
		//Marca o teste com vermelho ou verde, verde se deu certo.
		assertEquals(1, enderecos.size());
		Endereco enderecoBanco = enderecos.stream()
		.findFirst().get();
		assertEquals("Centro", enderecoBanco.getBairro());
		enderecoDAO.excluir(enderecoBanco.getCodigo());
	}
}
