package banco1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UfDAO {

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

	public void insert(Uf uf) {
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
	
	public void update(Uf uf) {
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
	
	public void delete(Long codigo) {
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
}
