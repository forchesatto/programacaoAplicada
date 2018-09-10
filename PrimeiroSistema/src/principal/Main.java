package principal;
	
import javafx.application.Application;
import javafx.stage.Stage;
import principal.conexao.TipoConexao;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("menu.fxml"));
			Scene scene = new Scene(root,800,600);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		System.setProperty("tipoPersistencia", 
				TipoPersistencia.BANCO.name());
		if(args.length > 0){
			System.setProperty("tipoConexao", args[0]);
		}
		launch(args);
	}
}
