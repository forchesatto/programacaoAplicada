package principal.dao;

import java.util.List;

public abstract class CrudArquivo<T> implements CrudDAO<T> {

	private ManipuladorArquivo<T> manipulador;

	public CrudArquivo(){
		manipulador = criarManipulador();
	}
	
	protected abstract ManipuladorArquivo<T> criarManipulador();
	
	@Override
	public void inserir(T dado) {
		List<T> dados = manipulador.recuperar();
		dados.add(dado);
		manipulador.gravar(dados);
	}

	@Override
	public void alterar(T dado) {
		List<T> dados = manipulador.recuperar();
		for (T dadoArquivo : dados) {
			if (dadoArquivo.equals(dado)) {
				// tira o dado velho
				dados.remove(dadoArquivo);
				// coloca o dado novo
				dados.add(dado);
				break;
			}
		}
		manipulador.gravar(dados);
	}

	@Override
	public void excluir(T dado) {
		List<T> dados = manipulador.recuperar();
		dados.remove(dado);
		manipulador.gravar(dados);
	}

	@Override
	public List<T> listar() {
		return manipulador.recuperar();
	}

}
