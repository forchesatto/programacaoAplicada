package br.edu.unoesc.revisaoOO.modelo;

import java.io.Serializable;

import br.edu.unoesc.revisaoOO.componente.RenderizaCombo;

public class Agencia implements Serializable, RenderizaCombo{

	private static final long serialVersionUID = -7078526979609277117L;
	
	private Long codigo;
	private String nome;
	private Integer numero;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	@Override
	public String toString() {
		return this.nome + " ----- " + this.numero;
	}

	@Override
	public String getText() {
		return this.nome;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

}
