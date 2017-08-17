package application;

import br.edu.unoesc.revisaoOO.modelo.Agencia;
import br.edu.unoesc.revisaoOO.modelo.SimuladorBD;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AgenciaDialogController {

	@FXML
	private TextField tfNome;

	@FXML
	private TextField tfNumero;

	@FXML
	private Button btnSalvar;

	private Agencia agencia = new Agencia();
	
	private Stage stageDialog;
	private boolean salvarClicked = false;
	
	@FXML
	void initialize(){
	}
	
	@FXML
	void onSalvar(ActionEvent event) {
		agencia.setNome(tfNome.getText());
		agencia.setNumero(Integer.valueOf(tfNumero.getText()));
		SimuladorBD.insert(agencia);
		salvarClicked = true;
		//Fecha o dialog
		stageDialog.close();
	}
	
	@FXML
	void onCancelar(ActionEvent event){
		//Fecha o dialog
		salvarClicked = false;
		stageDialog.close();
	}
	
	public boolean isSalvarClicked(){
		return salvarClicked;
	}
	
	public void setStageDialog(Stage stage){
		this.stageDialog = stage;
	}
}
