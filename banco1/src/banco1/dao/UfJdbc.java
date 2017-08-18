package banco1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import banco1.conexao.ConexaoUtil;
import banco1.model.Uf;

public class UfJdbc implements UfDao {

	@Override
	public List<Uf> listar() {
		List<Uf> ufs = new ArrayList<>();
		try {
			Connection con = ConexaoUtil.getCon();
			// Classe que sabe executar comandos SQL
			Statement stmt = con.createStatement();
			// Comando sql que desejo executar
			String sql = "select * from uf";
			// Execução do comando e o resultado é
			// armazenado no ResultSet
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Uf uf = new Uf();
				uf.setCodigo(rs.getLong("codigo"));
				uf.setNome(rs.getString("nome"));
				ufs.add(uf);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ufs;
	}

	@Override
	public void inserir(Uf uf) {
		try {
			Connection con = ConexaoUtil.getCon();
			// comando de insert
			String insert = "insert into uf (nome) values(?)";
			// novo statement para executar o insert
			PreparedStatement insertStmt = con.prepareStatement(insert);
			insertStmt.setString(1, uf.getNome());
			// execução do insert
			insertStmt.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void alterar(Uf uf) {
		try {
			Connection con = ConexaoUtil.getCon();
			String update = "update uf set nome = ? where codigo = ? ";
			PreparedStatement updateStmt = con.prepareStatement(update);
			updateStmt.setString(1, uf.getNome());
			updateStmt.setLong(2, uf.getCodigo());
			updateStmt.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void excluir(Long codigo) {
		try {
			Connection con = ConexaoUtil.getCon();
			String update = "delete from uf where codigo = ? ";
			PreparedStatement updateStmt = con.prepareStatement(update);
			updateStmt.setLong(1, codigo);
			updateStmt.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public Uf get(Long codigo) {
		try {
			Connection con = ConexaoUtil.getCon();
			Statement stmt = con.createStatement();
			String sql = "select * from uf where codigo = " 
													+ codigo;
			ResultSet rs = stmt.executeQuery(sql);
			rs.next();
			Uf uf = new Uf();
			uf.setCodigo(rs.getLong("codigo"));
			uf.setNome(rs.getString("nome"));
			return uf;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
