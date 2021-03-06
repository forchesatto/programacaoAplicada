package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexaoUtil {

	private static Connection connection;

	static {
		String url = "jdbc:mysql://localhost:3306/medico_2016";
		String user = "root";
		String password = "";
		try {
			connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println("Erro de conexão com o banco de dados");
		}
	}
	
	public static Connection get(){
		return connection;
	}
	
	public static void close(){
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Erro ao fechar conexão");
		}
	}

}
