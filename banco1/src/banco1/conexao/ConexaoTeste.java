package banco1.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoTeste implements Conexao {
	
	private static Connection con;
	
	static{
		open();
	}
	
	private static void open(){
		String url = "jdbc:mariadb://localhost:3307/jdbc_test";
		String username = "root";
		String password = "";
		// Vai até o banco de dados e cria uma conexão.
		try {
			con = DriverManager.getConnection(url,
					username, password);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public Connection get() {
		try {
			if(con.isClosed()){
				open();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public void close(){
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
