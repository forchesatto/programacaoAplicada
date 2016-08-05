package main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MainInsert {

	public static void main(String[] args) {
		try {
			//Faz a conexão com o banco de dados informado nas variáveis.
			Connection connection = ConexaoUtil.get();
			String sql = "insert into medico (codmedico,nommedico,crm,codendereco) "
					+ " values (?,?,?,?)";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, 10);
			ps.setString(2, "Médico Java");
			ps.setString(3, "CRM/SC-1234");
			ps.setInt(4, 1);
			ps.executeUpdate();
			System.out.println("Inserido");
		}catch(SQLException ex){
			ex.printStackTrace();
		} finally {
			ConexaoUtil.close();
		}
	}
}
