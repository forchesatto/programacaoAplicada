package br.edu.unoesc.jdbcOO.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import br.edu.unoesc.jdbcOO.conexao.Conexao;
import br.edu.unoesc.jdbcOO.model.Cidade;
import br.edu.unoesc.jdbcOO.model.UF;

public class CidadeJDBC implements CidadeDAO {

	private Conexao conexao;

	/**
	 * Conexão com o banco de dados.
	 * 
	 * @param conexao.get()
	 */
	public CidadeJDBC(Conexao conexao) {
		this.conexao = conexao;
	}

	@Override
	public void inserir(Cidade objeto) {
		String insert = "insert into cidade (nome,coduf) "
				+ "values(?,?)";
		try {
			PreparedStatement ps = conexao.get().prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, objeto.getNome());
			ps.setLong(2, objeto.getUf().getCodigo());
			ps.executeUpdate();
			// Popular o objeto com o código gerado.
			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			objeto.setCodigo(rs.getLong(1));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conexao.close();
		}
	}

	@Override
	public void alterar(Cidade objeto) {
		String update = "update cidade set nome=?, coduf = ?"
				+ " where codcidade = ?";
		try {
			PreparedStatement ps = conexao.get().prepareStatement(update);
			ps.setString(1, objeto.getNome());
			ps.setLong(2, objeto.getUf().getCodigo());
			ps.setLong(3, objeto.getCodigo());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conexao.close();
		}
	}

	@Override
	public void excluir(Long codigo) {
		String delete = "delete from cidade where codcidade = ?";
		try {
			PreparedStatement ps = conexao.get().prepareStatement(delete);
			ps.setLong(1, codigo);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conexao.close();
		}
	}

	@Override
	public Collection<Cidade> todos() {
		String sql = "select * from Cidade";
		List<Cidade> cidades = new ArrayList<>();
		try {
			PreparedStatement ps = conexao.get().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			cidades = getLista(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conexao.close();
		}
		return cidades;
	}

	@Override
	public Cidade get(Long codigo) {
		String sql = "select * from Cidade where codcidade = ?";
		Cidade cidade = null;
		try {
			PreparedStatement ps = conexao.get().prepareStatement(sql);
			ps.setLong(1, codigo);
			ResultSet rs = ps.executeQuery();
			// Passa por todos os registros que vieram do banco.
			while (rs.next()) {
				cidade = getCidade(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conexao.close();
		}
		return cidade;
	}
	
	private List<Cidade> getLista(ResultSet rs) throws SQLException {
		List<Cidade> cidades = new ArrayList<>();
		while (rs.next()) {
			cidades.add(getCidade(rs));
		}
		return cidades;
	}

	private Cidade getCidade(ResultSet rs) throws SQLException {
		Cidade cidade = new Cidade(rs.getLong("codcidade"), 
				rs.getString("nome"), new UF(rs.getLong("coduf")));
		return cidade;
	}

	@Override
	public List<Cidade> todosComUf() {
		String sql = "select c.codcidade, c.nome nomeCidade, c.coduf, u.nome nomeUf"
				+ " from Cidade c join Uf u on c.coduf = u.coduf ";
		List<Cidade> cidades = new ArrayList<>();
		try {
			PreparedStatement ps = conexao.get().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Cidade cidade = new Cidade(rs.getLong("codcidade"), 
						rs.getString("nomeCidade"), 
						new UF(rs.getLong("coduf"), rs.getString("nomeUf")));
				cidades.add(cidade);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conexao.close();
		}
		return cidades;
	}

}
