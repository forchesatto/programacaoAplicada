package principal.conexao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class ConexaoUtil {
	private static Connection connection;
	
	static{
		TipoConexao tipoConexao = TipoConexao
				.valueOf(System.getProperty("tipoConexao"));
		try{
			connection = 
					DriverManager.getConnection(
							tipoConexao.getUrl(),
							tipoConexao.getUser(), 
							tipoConexao.getPass());
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public static Connection getConn(){
		return connection;
	}
}
