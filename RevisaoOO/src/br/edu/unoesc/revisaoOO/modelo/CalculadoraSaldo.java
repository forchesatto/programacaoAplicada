package br.edu.unoesc.revisaoOO.modelo;

import java.util.ArrayList;
import java.util.List;

public class CalculadoraSaldo {

	private List<Conta> contas;
	
	public CalculadoraSaldo(){
		this.contas = new ArrayList<>();
	}
	
	public void addConta(Conta conta){
		contas.add(conta);
	}
	
	public Double calcular(){
//		Double saldo = 0.0;
		//percorrer todas as contas pegando 
		//o saldo de cada uma e somando na variável
		//JAVA > 1.4 && < 8
		// percorre todas as linhas da List contas 
		// pegando uma conta por vez e populando a variável conta. 
//		for(Conta conta: contas){
//			saldo += conta.getSaldo();
//		}
		// Java >=8
		return contas.stream().mapToDouble(Conta::getSaldo).sum();
//		return saldo;
		
		
	}
}
