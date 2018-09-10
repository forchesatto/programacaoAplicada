package principal.conexao;

public enum TipoConexao {

	TESTES(new PropriedadesConexao("teste.properties")), 
	DESENVOLVIMENTO(new PropriedadesConexao("desenvolvimento.properties")), 
	CLIENTE(new PropriedadesConexao("cliente.properties"));
	
	TipoConexao(PropriedadesConexao propriedadesConexao) {
		this.propriedadesConexao = propriedadesConexao;
	}
	
	private PropriedadesConexao propriedadesConexao;
	
	public String getUser() {
		return propriedadesConexao.getUser();
	}
	public String getPass() {
		return propriedadesConexao.getPass();
	}
	public String getUrl() {
		return propriedadesConexao.getUrl();
	}
	
	
}
