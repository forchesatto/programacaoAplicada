package br.edu.unoesc.revisaoOO.modelo;

import java.time.LocalDate;

public class Cliente {

	private String nome;
	private String cpf;
	private LocalDate dataNascimento;
	
	private Agencia agenciaPreferencial;
	

	public Cliente() {

	}

	public Cliente(String nome, String cpf, LocalDate dataNascimento) {
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	/**
	 * Sobreescreve o método toString do Object, 
	 * fazendo com que seja impresso o
	 * nome e cpf no lugar do pacote da classe
	 */
	@Override
	public String toString() {
		return this.nome + " " + this.cpf;
	}

	public Agencia getAgenciaPreferencial() {
		return agenciaPreferencial;
	}

	public void setAgenciaPreferencial(Agencia agenciaPreferencial) {
		this.agenciaPreferencial = agenciaPreferencial;
	}
}
