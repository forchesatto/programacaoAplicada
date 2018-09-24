package principal;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AreaDialogFabrica {
	
	private Stage stageDono;

	public AreaDialogFabrica(Stage stageDono) {
		this.stageDono = stageDono;
	}

	public boolean showDialog() {
		boolean clicadoSalvar = true;
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("areaForm.fxml"));
		try {
			AnchorPane areaDialog = (AnchorPane) loader.load();
			
			// Cria o palco dialogStage.
	        Stage dialogStage = new Stage();
	        dialogStage.setTitle("Nova Area");
	        dialogStage.initModality(Modality.WINDOW_MODAL);
	        dialogStage.initOwner(stageDono);
	        Scene scene = new Scene(areaDialog);
	        dialogStage.setScene(scene);
	        
	        AreaController controller = loader
	        		.getController();
	        controller.setStageDialog(dialogStage);
	        
	        dialogStage.showAndWait();

	        clicadoSalvar = controller.clicadoSalvar();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		return clicadoSalvar;
	}

}
