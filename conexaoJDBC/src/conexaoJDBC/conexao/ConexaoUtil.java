package conexaoJDBC.conexao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class ConexaoUtil {
	private static final  String USER = "root";
	private static final String PASS = "";
	private static final String URL = "jdbc:mariadb:"
			+ "//localhost:3307/aula01"
			+ "?useSSL=false&useTimezone=true&serverTimezone=UTC";
	
	private static Connection connection;
	
	static{
		try{
			connection = 
					DriverManager.getConnection(URL, USER, PASS);
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public static Connection getConn(){
		return connection;
	}
}
