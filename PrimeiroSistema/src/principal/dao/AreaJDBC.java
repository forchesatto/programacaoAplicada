package principal.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import principal.conexao.ConexaoUtil;
import principal.model.Area;

public class AreaJDBC implements AreaDAO{

	@Override
	public void inserir(Area dado) {
		try {
			String sql = "insert into area values (?,?)";
			PreparedStatement statement = ConexaoUtil.getConn().prepareStatement(sql);
			statement.setInt(1, dado.getCodigo());
			statement.setString(2, dado.getNome());
			statement.executeUpdate();
			
			// Popular o objeto com o código gerado.
			// Somente nos caso de campo auto-incremento
			//ResultSet rs = statement.getGeneratedKeys();
			//rs.next();
			//dado.setCodigo(rs.getInt(1));
			//---->
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void alterar(Area dado) {
		try {
			String sql = "update area set nomarea = ?" 
						+ " where idarea = ?";
			PreparedStatement statement = ConexaoUtil.getConn().prepareStatement(sql);
			statement.setString(1, dado.getNome());
			statement.setInt(2, dado.getCodigo());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void excluir(Area dado) {
		try {
			String sql = "delete from area where idarea = ?";
			PreparedStatement statement = ConexaoUtil.getConn().prepareStatement(sql);
			statement.setInt(1, dado.getCodigo());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Area> listar() {
		List<Area> areas = new ArrayList<>();
		try {
			Statement statement = ConexaoUtil.getConn().createStatement();
			ResultSet rs = statement.executeQuery("select * from area");
			while (rs.next()) {
				Area area = new Area();
				area.setNome(rs.getString("nomarea"));
				area.setCodigo(rs.getInt("idarea"));
				areas.add(area);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return areas;
	}

}
