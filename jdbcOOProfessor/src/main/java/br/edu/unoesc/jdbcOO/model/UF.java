package br.edu.unoesc.jdbcOO.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UF {

	private Long codigo;
	private String nome;
	
	public UF(Long codigo){
		this.codigo = codigo;
	}
}
