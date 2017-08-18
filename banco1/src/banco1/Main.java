package banco1;

import java.util.List;
import java.util.Scanner;

import banco1.dao.DaoFactory;
import banco1.dao.UfDao;
import banco1.model.Uf;

public class Main {

	private static UfDao ufDao = DaoFactory.get().ufDao();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("digite o nome da uf");
		Uf ufInsert = new Uf();
		ufInsert.setNome(sc.nextLine());
		ufDao.inserir(ufInsert);
		listar();
		System.out.println("Digite um código para alterar:");
		Uf ufUpdate = new Uf();
		ufUpdate.setCodigo(sc.nextLong());
		System.out.println("Digite o novo nome:");
		ufUpdate.setNome(sc.next());
		ufDao.alterar(ufUpdate);
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
