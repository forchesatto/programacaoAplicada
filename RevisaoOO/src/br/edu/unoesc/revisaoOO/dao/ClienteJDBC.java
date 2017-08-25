package br.edu.unoesc.revisaoOO.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.edu.unoesc.revisaoOO.modelo.Agencia;
import br.edu.unoesc.revisaoOO.modelo.Cliente;

public class ClienteJDBC implements ClienteDAO {

	@Override
	public void inserir(Cliente cliente) {
		try {
			Connection con = ConexaoUtil.getCon();
			String insert = "insert into cliente values(codigo,?,?,?,?)";
			PreparedStatement insertStmt = con.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
			insertStmt.setString(1, cliente.getNome());
			insertStmt.setString(2, cliente.getCpf());
			insertStmt.setDate(3, Date.valueOf(cliente.getDataNascimento()));
			insertStmt.setLong(4, cliente.getAgenciaPreferencial().getCodigo());
			insertStmt.executeUpdate();
			ResultSet resultSet = insertStmt.getGeneratedKeys();
			resultSet.next();
			cliente.setCodigo(resultSet.getLong(1));
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}

	@Override
	public void alterar(Cliente cliente) {
		try {
			Connection con = ConexaoUtil.getCon();
			String update = "update cliente set nome = ?, " + "cpf = ?, dataNascimento = ?, codagencia = ?"
					+ " where codigo = ? ";
			PreparedStatement updateStmt = con.prepareStatement(update);
			updateStmt.setString(1, cliente.getNome());
			updateStmt.setString(2, cliente.getCpf());
			updateStmt.setDate(3, Date.valueOf(cliente.getDataNascimento()));
			updateStmt.setLong(4, cliente.getAgenciaPreferencial().getCodigo());
			updateStmt.setLong(5, cliente.getCodigo());
			updateStmt.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}

	@Override
	public void excluir(Long codigo) {
		try {
			Connection con = ConexaoUtil.getCon();
			String update = "delete from cliente where codigo = ? ";
			PreparedStatement updateStmt = con.prepareStatement(update);
			updateStmt.setLong(1, codigo);
			updateStmt.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}

	@Override
	public List<Cliente> listar() {
		List<Cliente> clientes = new ArrayList<>();
		try {
			Connection con = ConexaoUtil.getCon();
			// Classe que sabe executar comandos SQL
			Statement stmt = con.createStatement();
			// Comando sql que desejo executar
			String sql = "select * from cliente";
			// Execução do comando e o resultado é
			// armazenado no ResultSet
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Cliente cliente = new Cliente();
				cliente.setCodigo(rs.getLong("codigo"));
				cliente.setNome(rs.getString("nome"));
				cliente.setCpf(rs.getString("cpf"));
				cliente.setDataNascimento(rs.getDate("dataNascimento").toLocalDate());
				Agencia agencia = new Agencia();
				agencia.setCodigo(rs.getLong("codagencia"));
				cliente.setAgenciaPreferencial(agencia);
				clientes.add(cliente);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return clientes;
	}

	@Override
	public Cliente get(Long codigo) {
		Cliente cliente = null;
		try {
			Connection con = ConexaoUtil.getCon();
			// Classe que sabe executar comandos SQL
			Statement stmt = con.createStatement();
			// Comando sql que desejo executar
			String sql = "select * from cliente where codigo=" + codigo;
			// Execução do comando e o resultado é
			// armazenado no ResultSet
			ResultSet rs = stmt.executeQuery(sql);
			rs.next();
			cliente = new Cliente();
			cliente.setCodigo(rs.getLong("codigo"));
			cliente.setNome(rs.getString("nome"));
			cliente.setCpf(rs.getString("cpf"));
			cliente.setDataNascimento(rs.getDate("dataNascimento").toLocalDate());
			Agencia agencia = new Agencia();
			agencia.setCodigo(rs.getLong("codagencia"));
			cliente.setAgenciaPreferencial(agencia);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cliente;
	}

}
