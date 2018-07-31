package principal.model;

import java.io.Serializable;
import java.time.LocalDate;

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
public class Curso implements Serializable {

	private static final long serialVersionUID = -8575749010408733358L;
	private Integer codigo;
	private String nome;
	private LocalDate dataCriacao;
	private Area area;
}
