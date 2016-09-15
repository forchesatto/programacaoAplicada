package br.edu.unoesc.jdbcOO.controller;

import br.edu.unoesc.jdbcOO.factory.DAOFactory;
import br.edu.unoesc.jdbcOO.model.UF;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class UFController {

    @FXML
    private TextField tfCodigo;

    @FXML
    private TextField tfNome;

    @FXML
    void onSalvar(ActionEvent event) {
    		String codigo = tfCodigo.getText();
    		UF uf = new UF();
    		if(!codigo.isEmpty()){
    			uf.setCodigo(Long.valueOf(codigo));
    		}
    		uf.setNome(tfNome.getText());
    		
    		DAOFactory.get().ufDAO().inserir(uf);
    }
}
