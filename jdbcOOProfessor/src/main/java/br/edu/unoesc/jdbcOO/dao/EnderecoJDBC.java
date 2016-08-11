package br.edu.unoesc.jdbcOO.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import br.edu.unoesc.jdbcOO.conexao.ConexaoUtil;
import br.edu.unoesc.jdbcOO.model.Endereco;

public class EnderecoJDBC implements EnderecoDAO{

	@Override
	public void inserir(Endereco objeto) {
		Connection conn = ConexaoUtil.get();
		String insert = "insert into endereco (rua,bairro) values(?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(insert);
			ps.setString(1, objeto.getRua());
			ps.setString(2, objeto.getBairro());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConexaoUtil.close();
		}
	}

	@Override
	public void alterar(Endereco objeto) {
		Connection conn = ConexaoUtil.get();
		String update = "update endereco set rua=?, bairro=? "
				+ "where codendereco = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(update);
			ps.setString(1, objeto.getRua());
			ps.setString(2, objeto.getBairro());
			ps.setLong(3, objeto.getCodigo());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConexaoUtil.close();
		}
		
	}

	@Override
	public void excluir(Long codigo) {
		Connection conn = ConexaoUtil.get();
		String delete = "delete from endereco "
				+ "where codendereco = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(delete);
			ps.setLong(1, codigo);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConexaoUtil.close();
		}
	}

	@Override
	public Collection<Endereco> todos() {
		Connection conn = ConexaoUtil.get();
		String sql = "select * from Endereco";
		List<Endereco> enderecos = new ArrayList<>();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			//Passa por todos os registros que vieram do banco.
			while(rs.next()){
				//Cria um objeto endereco por vez
				Endereco endereco = new Endereco(
							rs.getLong("codendereco"),
							rs.getString("rua"),
							rs.getString("bairro"));
				//adiciona na lista de retorno
				enderecos.add(endereco);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConexaoUtil.close();
		}
		return enderecos;
	}

	@Override
	public Endereco get(Long codigo) {
		Connection conn = ConexaoUtil.get();
		String sql = "select * from Endereco where codendereco = ?";
		Endereco endereco = null;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setLong(1, codigo);
			ResultSet rs = ps.executeQuery();
			//Passa por todos os registros que vieram do banco.
			while(rs.next()){
				//Cria um objeto endereco por vez
				endereco = new Endereco(
							rs.getLong("codendereco"),
							rs.getString("rua"),
							rs.getString("bairro"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConexaoUtil.close();
		}
		return endereco;
	}

	@Override
	public Collection<Endereco> getPorRua(String rua) {
		return null;
	}

}