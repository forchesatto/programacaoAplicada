package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class MenuController {

	@FXML
	private BorderPane bpPrincipal;

	@FXML
	private MenuItem miAgencia;

	@FXML
	private MenuItem miCliente;
	
	@FXML
	void onAgencia(ActionEvent event) {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("agenciaForm.fxml"));
		try {
			AnchorPane agenciaView = (AnchorPane) loader.load();
			bpPrincipal.setCenter(agenciaView);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	@FXML
	void onCliente(ActionEvent event) {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("clienteForm.fxml"));
		try {
			AnchorPane agenciaView = (AnchorPane) loader.load();
			bpPrincipal.setCenter(agenciaView);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

}
