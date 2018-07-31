package conexaoJDBC.dao;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.SQLException;
import java.sql.ResultSet;

import conexaoJDBC.conexao.ConexaoUtil;
import java.sql.Statement;
import java.util.List;

import conexaoJDBC.model.Cidade;

public class CidadeJDBC implements CidadeDAO {

	@Override
	public void inserir(Cidade dado) {
		try {
			String sql = "insert into cidade values (?,?)";
			PreparedStatement statement = ConexaoUtil.getConn().prepareStatement(sql);
			statement.setInt(1, dado.getCodigo());
			statement.setString(2, dado.getNome());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void alterar(Cidade dado) {
		try {
			String sql = "update cidade set nomcidade = ?" + " where idcidade = ?";
			PreparedStatement statement = ConexaoUtil.getConn().prepareStatement(sql);
			statement.setString(1, dado.getNome());
			statement.setInt(2, dado.getCodigo());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void excluir(Integer codigo) {
		try {
			String sql = "delete from cidade where idcidade = ?";
			PreparedStatement statement = ConexaoUtil.getConn().prepareStatement(sql);
			statement.setInt(1, codigo);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Cidade> listar() {
		List<Cidade> cidades = new ArrayList<>();
		try {
			Statement statement = ConexaoUtil.getConn().createStatement();
			ResultSet rs = statement.executeQuery("select * from cidade");
			while (rs.next()) {
				Cidade cidade = new Cidade();
				cidade.setNome(rs.getString("nomcidade"));
				cidade.setCodigo(rs.getInt("idcidade"));
				cidades.add(cidade);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cidades;
	}

	@Override
	public Cidade buscar(Integer codigo) {
		Cidade cidade = null;
		try {
			String sql = "select * from cidade" 
					+ " where idcidade = ?";
			PreparedStatement ps = ConexaoUtil.getConn()
					.prepareStatement(sql);
			ps.setInt(1, codigo);
			ResultSet rs1 = ps.executeQuery();
			while (rs1.next()) {
				cidade = new Cidade();
				cidade.setCodigo(rs1.getInt("idcidade"));
				cidade.setNome(rs1.getString("nomcidade"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cidade;
	}

}
