package application;

import br.edu.unoesc.revisaoOO.componente.ListCellBean;
import br.edu.unoesc.revisaoOO.componente.StringConverterBean;
import br.edu.unoesc.revisaoOO.modelo.Agencia;
import br.edu.unoesc.revisaoOO.modelo.Cliente;
import br.edu.unoesc.revisaoOO.modelo.SimuladorBD;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ClienteController {

	@FXML
	private TextField tfNome;

	@FXML
	private TextField tfCpf;

	@FXML
	private DatePicker dtDataNascimento;

	@FXML
	private Button btnSalvar;

	@FXML
	private ListView<Cliente> lvCliente;

	private Cliente cliente;

	private boolean editando;

	@FXML
	private ComboBox<Agencia> cbxAgencia;
	
	@FXML
	private Button btnNovaAgencia;
	
	@FXML
	public void onNovaAgencia(ActionEvent event){
		Stage stageDono = (Stage)btnNovaAgencia.getScene().getWindow();
		AgenciaDialogFabrica agenciaDialogFabrica = 
				new AgenciaDialogFabrica(stageDono);
		boolean salvarClicked = agenciaDialogFabrica.showAgenciaDialog();
		if(salvarClicked){
			cbxAgencia.getItems().clear();
			cbxAgencia.getItems().addAll(SimuladorBD.getAgencias());
		}
	}

	@FXML
	public void initialize() {
		lvCliente.setItems(FXCollections.observableArrayList());
		cbxAgencia.setCellFactory((comboBox) -> {
			return new ListCellBean<Agencia>();
		});
		cbxAgencia.setConverter(new StringConverterBean<>());

		cbxAgencia.setItems(FXCollections.observableArrayList(SimuladorBD.getAgencias()));
		novo();
	}

	@FXML
	void onSalvar(ActionEvent event) {
		cliente.setNome(tfNome.getText());
		cliente.setCpf(tfCpf.getText());
		cliente.setDataNascimento(dtDataNascimento.getValue());
		// pega do combobox e guarda no objeto agencia
		cliente.setAgenciaPreferencial(cbxAgencia.getValue());

		if (editando) {
			lvCliente.refresh();
		} else {
			SimuladorBD.insert(cliente);
			lvCliente.getItems().add(cliente);
		}
		novo();
	}

	private void novo() {
		editando = false;
		cliente = new Cliente();
		limparCampos();
	}

	private void limparCampos() {
		tfNome.setText("");
		tfCpf.setText("");
		dtDataNascimento.setValue(null);
	}

	@FXML
	void onEditar(MouseEvent mouseEvent) {
		if (mouseEvent.getEventType().equals(MouseEvent.MOUSE_CLICKED)) {
			cliente = lvCliente.getSelectionModel().getSelectedItem();
			tfNome.setText(cliente.getNome());
			tfCpf.setText(cliente.getCpf());
			dtDataNascimento.setValue(cliente.getDataNascimento());
			// pega do objeto e coloca no combobox
			cbxAgencia.setValue(cliente.getAgenciaPreferencial());
			editando = true;
		}
	}

	@FXML
	void onNovo(ActionEvent event) {
		novo();
	}

}
