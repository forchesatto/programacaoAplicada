package application;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AgenciaDialogFabrica {

	private Stage stageDono;

	public AgenciaDialogFabrica(Stage stageDono) {
		this.stageDono = stageDono;
	}
	
	/**
	 * Abre uma janela para editar detalhes para a pessoa especificada. Se o usuário clicar
	 * OK, as mudanças são salvasno objeto pessoa fornecido e retorna true.
	 * 
	 * @return true Se o usuário clicou OK,  caso contrário false.
	 */
	public boolean showAgenciaDialog() {
	    try {
	        // Carrega o arquivo fxml e cria um novo stage para a janela popup.
	        FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(getClass().getResource("agenciaDialog.fxml"));
	        AnchorPane page = (AnchorPane) loader.load();

	        // Cria o palco dialogStage.
	        Stage dialogStage = new Stage();
	        dialogStage.setTitle("Nova Agência");
	        dialogStage.initModality(Modality.WINDOW_MODAL);
	        dialogStage.initOwner(stageDono);
	        Scene scene = new Scene(page);
	        dialogStage.setScene(scene);

	        // Define a pessoa no controller.
	        AgenciaDialogController controller = loader.getController();
	        controller.setStageDialog(dialogStage);

	        // Mostra a janela e espera até o usuário fechar.
	        dialogStage.showAndWait();

	        return controller.isSalvarClicked();
	    } catch (IOException e) {
	        e.printStackTrace();
	        return false;
	    }
	}
	
}
