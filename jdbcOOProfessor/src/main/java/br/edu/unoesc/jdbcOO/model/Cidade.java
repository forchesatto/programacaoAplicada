package br.edu.unoesc.jdbcOO.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cidade implements Entidade{

	private Long codigo;
	private String nome;
	private UF uf;
	
	public Cidade(Long codigo) {
		this.codigo = codigo;
	}
	
}
