package banco1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;

public class Main {

	private static UfDAO ufDao = new UfDAO();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("digite o nome da uf");
		Uf ufInsert = new Uf();
		ufInsert.setNome(sc.nextLine());
		ufDao.insert(ufInsert);
		listar();
		System.out.println("Digite um código para alterar:");
		Uf ufUpdate = new Uf();
		ufUpdate.setCodigo(sc.nextLong());
		System.out.println("Digite o novo nome:");
		ufUpdate.setNome(sc.next());
		ufDao.update(ufUpdate);
		listar();
		sc.close();
	}
	
	public static void listar(){
		List<Uf> lista = ufDao.listar();
		for (Uf uf : lista) {
			System.out.println(uf.getCodigo() 
					+ " - " + uf.getNome());
		}
	}
	
	

}
