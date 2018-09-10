package principal.conexao;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropriedadesConexao {

	private String user;
	private String pass;
	private String url;
	private String path;
	
	public PropriedadesConexao(String nomeArquivo){
		this.path = System.getProperty("user.home")
				+"/"+nomeArquivo;
		Properties properties = new Properties();
		try {
			FileInputStream inStream = new FileInputStream(path);
			properties.load(inStream);
			this.url = properties.getProperty("url");
			this.pass = properties.getProperty("pass");
			this.user = properties.getProperty("user");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getUser() {
		return user;
	}

	public String getPass() {
		return pass;
	}

	public String getUrl() {
		return url;
	}

	public String getPath() {
		return path;
	}
}
