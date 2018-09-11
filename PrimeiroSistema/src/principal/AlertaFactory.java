package principal;

import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;

public class AlertaFactory {
	
	public boolean confirmaExclusao(){
		Optional<ButtonType> result = 
				criarAlert("Deseja realmente excluir?")
				.showAndWait();
		return ButtonType.OK.equals(result.get());
	}
	//TODO: Como podemo ainda melhorar?????
	private Alert criarAlert(String mensagem){
		Alert alerta = new Alert(AlertType.CONFIRMATION,
				mensagem,
					ButtonType.CANCEL, ButtonType.OK);

		// Desativando o comportamento padrão.
		Button okButton = (Button) alerta.getDialogPane()
				.lookupButton(ButtonType.OK);
		okButton.setDefaultButton(false);
		okButton.setText("Sim");
		
		Button cancelButton = (Button) alerta.getDialogPane()
				.lookupButton(ButtonType.CANCEL);
		cancelButton.setText("Não");
		return alerta;
	}
}
