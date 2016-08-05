package main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MainConexao {

	/**
	 * Primeiro exemplo de conexão ao banco de dados mysql
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			//Faz a conexão com o banco de dados informado nas variáveis.
			Connection connection = ConexaoUtil.get();
			//Imprime se conseguiu se conectar
			System.out.println(connection.toString());
			//Criar um executor de comando SQL
			Statement stmt = connection.createStatement();
			//Executa o select no banco e armazena o resultado no ResultSet
			ResultSet rs = stmt.executeQuery("Select * from medico");
			//Percore cada linha do retorno do banco
			while(rs.next()){
				//rs.getString() pega o valor de uma coluna de texto do banco
				System.out.println("Nome: "+rs.getString("nommedico"));
				System.out.println("Código: "+rs.getInt("codmedico"));
			}
		} catch (SQLException e) {
			//Erro na conexão
			System.out.println("Erro de conexão ao banco de dados");
			//Imprime o erro que deu na conexão
			e.printStackTrace();
		} finally {
			ConexaoUtil.close();
		}
	}

}
