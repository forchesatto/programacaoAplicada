package principal;

import java.util.Optional;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import principal.dao.AbstractFactory;
import principal.dao.AreaDAO;
import principal.model.Area;

public class AreaController {

	@FXML
	private TextField tfCodigo;

	@FXML
	private TextField tfNome;

	@FXML
	private Button btnSalvar;

	@FXML
	private TableView<Area> tblArea;

	@FXML
	private TableColumn<Area, Number> tbcCodigo;

	@FXML
	private TableColumn<Area, String> tbcNome;

	private Area area;

	private boolean editando;

	private AreaDAO areaDao = AbstractFactory.get().areaDao();

	/**
	 * Inicializa a classe controller. Este método é chamado automaticamente
	 * após o arquivo fxml ter sido carregado.
	 */
	@FXML
	private void initialize() {
		// Inicializa a tabela de area com duas colunas.
		tbcCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
		tbcNome.setCellValueFactory(new PropertyValueFactory<>("nome"));

		novoArea();
	}

	@FXML
	void salvar(ActionEvent event) {

		populaArea();

		if (editando) {
			areaDao.alterar(area);
		} else {
			areaDao.inserir(area);
		}
		novoArea();
		tblArea.refresh();
	}

	public void populaArea() {
		area.setCodigo(Integer.valueOf(tfCodigo.getText()));
		area.setNome(tfNome.getText());
	}

	public void populaTela(Area area) {
		tfCodigo.setText(area.getCodigo().toString());
		tfNome.setText(area.getNome());
	}

	@FXML
	void selecionaArea(MouseEvent event) {
		if (tblArea.getSelectionModel().getSelectedItem() != null) {
			area = tblArea.getSelectionModel().getSelectedItem();
			populaTela(area);
			editando = true;
		}
	}

	@FXML
	void excluir(ActionEvent event) {
		Alert alerta = new Alert(AlertType.CONFIRMATION,
				"Deseja realmente excluir?",
					ButtonType.CANCEL, ButtonType.OK);

		// Desativando o comportamento padrão.
		Button okButton = (Button) alerta.getDialogPane()
				.lookupButton(ButtonType.OK);
		okButton.setDefaultButton(false);
		okButton.setText("Sim");
		
		Button cancelButton = (Button) alerta.getDialogPane()
				.lookupButton(ButtonType.CANCEL);
		cancelButton.setText("Não");

		// Optional do Java 8 executa o show e fica aguardando o click do botão.
		final Optional<ButtonType> result = alerta.showAndWait();
		// Se o click foi no ok executa os comandos abaixo
		if (ButtonType.OK.equals(result.get())) {
			areaDao.excluir(area);
			novoArea();
		}

	}

	@FXML
	void novo(ActionEvent event) {
		novoArea();
	}

	void novoArea() {
		tfNome.clear();
		tfCodigo.clear();
		area = new Area();
		editando = false;
		tblArea.setItems(FXCollections.observableArrayList(areaDao.listar()));
	}

}
