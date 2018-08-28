package principal.conexao;

public enum TipoConexao {

	TESTES(new PropriedadesConexao("/Users/forchesatto/teste.properties")), 
	DESENVOLVIMENTO(new PropriedadesConexao("caminho")), 
	CLIENTE(new PropriedadesConexao("caminho"));
	
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
