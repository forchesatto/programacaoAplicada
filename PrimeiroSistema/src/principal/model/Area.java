package principal.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="codigo")
@ToString(of={"codigo","nome"})
public class Area implements Serializable{

	private static final long serialVersionUID = -5256702175570155096L;
	
	private Integer codigo;
	private String nome;
}
