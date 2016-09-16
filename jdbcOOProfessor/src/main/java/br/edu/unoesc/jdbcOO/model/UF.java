package br.edu.unoesc.jdbcOO.model;

import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UF implements Entidade{

	private Long codigo;
	private String nome;
	
	public UF(Long codigo){
		this.codigo = codigo;
	}
	
	public SimpleLongProperty getCodigoProperty(){
		return new SimpleLongProperty(this.getCodigo());
	}
	
	public SimpleStringProperty getNomeProperty(){
		return new SimpleStringProperty(this.getNome());
	}
}
