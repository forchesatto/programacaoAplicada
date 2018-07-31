package conexaoJDBC.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import conexaoJDBC.conexao.ConexaoUtil;
import conexaoJDBC.dao.CidadeJDBC;
import conexaoJDBC.model.Cidade;
import conexaoJDBC.dao.CidadeDAO;

public class TesteConexao {

	public static void main(String[] args) {
		try (
				Connection connection = ConexaoUtil.getConn()
			){
			
			CidadeDAO cidadeDAO = new CidadeJDBC();
			cidadeDAO.listar().forEach(cidade->{
				System.out.println(cidade.getCodigo()
						+" - "+cidade.getNome());
			});
			
			
				
			//Leitura da estrutura dos dados de retorno
//			ResultSetMetaData metaData = rs.getMetaData();
//			int totalColunas = metaData.getColumnCount();
//			for(int i=1; i<=totalColunas; i++){
//				System.out.print(metaData.getColumnName(i));
//				System.out.println(" - "+metaData.getColumnTypeName(i));
//			}
			
			Cidade cidade = cidadeDAO.buscar(1);
			System.out.println(cidade.getNome());
			
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Digite o id da cidade");
			Integer idCid = sc.nextInt();
			sc.nextLine();
			
			System.out.println("Digite o nome da cidade");
			String nomCid = sc.nextLine();
			
			Cidade cidadeInsert = new Cidade();
			cidadeInsert.setCodigo(idCid);
			cidadeInsert.setNome(nomCid);
			cidadeDAO.inserir(cidadeInsert);
			
			sc.close();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
