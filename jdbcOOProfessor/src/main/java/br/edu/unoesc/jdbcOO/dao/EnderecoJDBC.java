package br.edu.unoesc.jdbcOO.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;

import br.edu.unoesc.jdbcOO.conexao.ConexaoUtil;
import br.edu.unoesc.jdbcOO.model.Endereco;

public class EnderecoJDBC implements EnderecoDAO{

	@Override
	public void inserir(Endereco objeto) {
		Connection conn = ConexaoUtil.get();
		String insert = "insert into endereco values(?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(insert);
			ps.setLong(1, objeto.getCodigo());
			ps.setString(2, objeto.getRua());
			ps.setString(3, objeto.getBairro());
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Endereco get(Long codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Endereco> getPorRua(String rua) {
		// TODO Auto-generated method stub
		return null;
	}

}
