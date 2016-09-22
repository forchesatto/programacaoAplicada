package br.edu.unoesc.jdbcOO.controller;

import java.util.Collection;

import br.edu.unoesc.jdbcOO.dao.UFDAO;
import br.edu.unoesc.jdbcOO.factory.DAOFactory;
import br.edu.unoesc.jdbcOO.model.UF;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class UFController {

	@FXML
	private TextField tfCodigo;

	@FXML
	private TextField tfNome;

	@FXML
	private TableView<UF> tblUf;

	@FXML
	private TableColumn<UF, Number> tcCodigo;

	@FXML
	private TableColumn<UF, String> tcNome;

	private UFDAO ufDAO;

	public UFController() {
		ufDAO = DAOFactory.get().ufDAO();
	}

	@FXML
	public void initialize() {
//		tcCodigo.setCellValueFactory(uf -> uf.getValue().getCodigoProperty());
//		tcNome.setCellValueFactory(uf -> uf.getValue().getNomeProperty());
		tcCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
		tcNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		Collection<UF> ufs = ufDAO.todos();
		tblUf.getItems().addAll(ufs);
	}

	@FXML
	void onSalvar(ActionEvent event) {
		UF uf = criaUf();
		ufDAO.salvar(uf);
		tfCodigo.setText(uf.getCodigo().toString());
	}

	@FXML
	void onNovo(ActionEvent event) {
		limparCampos();
	}

	private void limparCampos() {
		tfCodigo.setText("");
		tfNome.setText("");
	}

	private UF criaUf() {
		String codigo = tfCodigo.getText();
		UF uf = new UF();
		uf.setNome(tfNome.getText());
		if (!codigo.isEmpty()) {
			uf.setCodigo(Long.valueOf(codigo));
		}
		return uf;
	}
}
