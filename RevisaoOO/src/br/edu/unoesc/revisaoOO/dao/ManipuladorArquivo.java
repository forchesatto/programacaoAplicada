package br.edu.unoesc.revisaoOO.dao;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ManipuladorArquivo {

	/**
	 * Serializa objetos de uma lista em um arquivo.
	 * 
	 * @param dados
	 *            List extends serializable.
	 * @param pathFile
	 *            String caminho do arquivo que deseja gravar.
	 */
	public void gravar(List<? extends Serializable> dados, String pathFile) {
		try {
			// Cria o arquivo que será utilizado
			FileOutputStream file = new FileOutputStream(pathFile);
			// Cria um manipulador de arquivo
			ObjectOutputStream out = new ObjectOutputStream(file);
			// Escreve os objetos dentro do arquivo.
			out.writeObject(dados);
			// fecha o manipulador de arquivo
			out.close();
			// fecha o arquivo
			file.close();
		} catch (IOException e) {
			// imprime se deu erro.
			e.printStackTrace();
		}
	}
	
	/**
	 * Recupera do arquivos os dados que foram armazenados.
	 * @param pathFile String nome do arquivo.
	 * @return List<T> 
	 */
	public <T extends Serializable> List<T> recuperar(String pathFile) {
		List<T> retorno = new ArrayList<>();
		try {
			//Cria ou encontra arquivo
			FileInputStream file = new FileInputStream(pathFile);
			//Manipulador de arquivo
			ObjectInputStream ois = new ObjectInputStream(file);
			//Recupera do arquivos os objetos serializados.
			retorno = (List) ois.readObject();
			ois.close();
			file.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (ClassNotFoundException c) {
			c.printStackTrace();
		}
		return retorno;
	}
}
