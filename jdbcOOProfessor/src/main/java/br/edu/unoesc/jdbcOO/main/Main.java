package br.edu.unoesc.jdbcOO.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			/*
			 * Encontra o arquivo fxml com o nome ufForm.fxml e cria o root que é
			 * o AnchorPane adicionado no SceneBuilder.
			 */
//			AnchorPane root = (AnchorPane) FXMLLoader
//					.load(getClass().getResource("/telas/UFForm.fxml"));
			AnchorPane root = (AnchorPane) FXMLLoader
					.load(getClass().getResource("/telas/CidadeForm.fxml"));
			// Cria a cena com base no root(AnchorPane)
			Scene scene = new Scene(root);
			// Seta para o palco a cena
			primaryStage.setScene(scene);
			// Faz mostrar a tela.
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
