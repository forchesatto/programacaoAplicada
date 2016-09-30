package br.edu.unoesc.jdbcOO.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;

public class MenuPrincipalController {

	@FXML
	private SplitPane panelPrincipal;

	@FXML
	void onActionCidade(ActionEvent event) {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/telas/CidadeForm.fxml"));
		try {
			AnchorPane cidadeView = (AnchorPane) loader.load();
			if(panelPrincipal.getItems().size() == 2){
				panelPrincipal.getItems().remove(1);
			}
			panelPrincipal.getItems().add(cidadeView);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	@FXML
	void onActionOrcamento(ActionEvent event) {

	}

	@FXML
	void onActionUF(ActionEvent event) {

	}

	@FXML
	void onActionVenda(ActionEvent event) {

	}
}
