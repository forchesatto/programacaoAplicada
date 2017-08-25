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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Agencia other = (Agencia) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
	

}
