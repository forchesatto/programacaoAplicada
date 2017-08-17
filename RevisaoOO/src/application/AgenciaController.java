package application;

import java.util.Optional;

import br.edu.unoesc.revisaoOO.dao.AgenciaDAO;
import br.edu.unoesc.revisaoOO.modelo.Agencia;
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

public class AgenciaController {

	@FXML
	private TextField tfNome;

	@FXML
	private TextField tfNumero;

	@FXML
	private Button btnSalvar;

	@FXML
	private TableView<Agencia> tblAgencia;
	
	@FXML
	private TableColumn<Agencia, Number> tbcNumero;
	
	@FXML
	private TableColumn<Agencia, String> tbcNome;
	
	@FXML
	private TableColumn<Agencia, String> tbcCliente;
	
	@FXML
	private Button btnNovo;

	@FXML
	private Button btnExcluir;
	
	private Agencia agencia;
	private boolean editando;
	
	private AgenciaDAO agenciaDao = new AgenciaDAO();
	
	@FXML
	void initialize(){
		tbcNumero.setCellValueFactory(new PropertyValueFactory<>("numero"));
		tbcNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		tblAgencia.setItems(FXCollections
				.observableArrayList(agenciaDao.listar()));
		novo();
	}
	
	private void novo(){
		agencia = new Agencia();
		editando = false;
		limparCampos();
	}
	
	private void limparCampos(){
		tfNome.setText("");
		tfNumero.setText("");
	}

	@FXML
	void onEditar(MouseEvent event) {
		if(event.getEventType().equals(MouseEvent.MOUSE_CLICKED)){
			agencia = tblAgencia.getSelectionModel().getSelectedItem();
			editando = true;
			tfNome.setText(agencia.getNome());
			tfNumero.setText(agencia.getNumero().toString());
		}
	}

	@FXML
	void onExcluir(ActionEvent event) {
		Alert alerta = new Alert(AlertType.CONFIRMATION,
				"Deseja realmente excluir?",
				ButtonType.CANCEL, ButtonType.OK);
		// Desativando o comportamento padrão.
		Button okButton = (Button) alerta.getDialogPane()
				.lookupButton(ButtonType.OK);
		okButton.setDefaultButton(false);

		// Optional do Java 8 executa o show e fica aguardando o click do botão.
		final Optional<ButtonType> result = alerta.showAndWait();
		// Se o click foi no ok executa os comandos abaixo
		if (result.get() == ButtonType.OK) {
			tblAgencia.getItems().remove(agencia);
			agenciaDao.delete(agencia.getCodigo());
			limparCampos();
		}
	}

	@FXML
	void onNovo(ActionEvent event) {
		novo();
	}

	@FXML
	void onSalvar(ActionEvent event) {
		agencia.setNome(tfNome.getText());
		agencia.setNumero(Integer.valueOf(tfNumero.getText()));
		if(editando){
			agenciaDao.update(agencia);
			tblAgencia.refresh();
		} else {
			agenciaDao.insert(agencia);
			tblAgencia.getItems().add(agencia);
		}
		novo();
	}
}
