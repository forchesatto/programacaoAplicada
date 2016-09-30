package br.edu.unoesc.jdbcOO.model;

import br.edu.unoesc.jdbcOO.componente.RenderizaCombo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UF implements Entidade, RenderizaCombo{

	private Long codigo;
	private String nome;
	
	public UF(Long codigo){
		this.codigo = codigo;
	}
	
	@Override
	public String getText() {
		return getNome();
	}
}
