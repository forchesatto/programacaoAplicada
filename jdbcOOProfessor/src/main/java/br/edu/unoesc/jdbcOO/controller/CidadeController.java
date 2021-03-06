package br.edu.unoesc.jdbcOO.controller;

import java.util.Collection;

import br.edu.unoesc.jdbcOO.componente.ListCellBean;
import br.edu.unoesc.jdbcOO.componente.StringConverterBean;
import br.edu.unoesc.jdbcOO.dao.CidadeDAO;
import br.edu.unoesc.jdbcOO.dao.UFDAO;
import br.edu.unoesc.jdbcOO.factory.DAOFactory;
import br.edu.unoesc.jdbcOO.model.Cidade;
import br.edu.unoesc.jdbcOO.model.UF;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class CidadeController {

	@FXML
    private TextField tfCodigo;

    @FXML
    private TextField tfNome;

    @FXML
    private ComboBox<UF> cbUF;
    
    @FXML
    private TableView<Cidade> tblCidade;

    @FXML
    private TableColumn<Cidade, Number> tcCodigo;

    @FXML
    private TableColumn<Cidade, String> tcNome;

    @FXML
    private TableColumn<Cidade, String> tcUF;
    
    private UFDAO ufDAO;
    private CidadeDAO cidadeDAO;

	public CidadeController() {
		ufDAO = DAOFactory.get().ufDAO();
		cidadeDAO = DAOFactory.get().cidadeDAO();
	}
    
	private void ouvirSelecaoTabela() {
		tblCidade.getSelectionModel().selectedItemProperty().addListener((observable, cidadeVelha, cidadeSelecionada) -> {
			if (cidadeSelecionada != null) {
				populaTela(cidadeSelecionada);
			}
		});
	}
    
    @FXML
	public void initialize() {
		tcCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
		tcNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		tcUF.setCellValueFactory(new PropertyValueFactory<>("nomeUF"));
		atualizaTabela();
		ouvirSelecaoTabela();
		montaComboUF();
	}
    private void atualizaTabela() {
		Collection<Cidade> cidades = cidadeDAO.todosComUf();
		tblCidade.setItems(FXCollections.observableArrayList(cidades));
	}

	private void populaTela(Cidade cidade) {
		tfCodigo.setText(cidade.getCodigo().toString());
		tfNome.setText(cidade.getNome());
		cbUF.setValue(cidade.getUf());
	}
	
	private void montaComboUF(){
		cbUF.getItems().addAll(ufDAO.todos());
		cbUF.setCellFactory((comboBox) ->{return new ListCellBean<UF>();});
		cbUF.setConverter(new StringConverterBean<>());
	}

	@FXML
	void onSalvar(ActionEvent event) {
		Cidade cidade = criaCidade();
		cidadeDAO.salvar(cidade);
		atualizaTabela();
		tfCodigo.setText(cidade.getCodigo().toString());
	}

	@FXML
	void onNovo(ActionEvent event) {
		limparCampos();
	}

	@FXML
	void onExcluir(ActionEvent event) {
		ufDAO.excluir(Long.valueOf(tfCodigo.getText()));
		atualizaTabela();
		limparCampos();
	}

	private void limparCampos() {
		tfCodigo.setText("");
		tfNome.setText("");
	}

	private Cidade criaCidade() {
		String codigo = tfCodigo.getText();
		Cidade cidade = new Cidade();
		cidade.setNome(tfNome.getText());
		if (!codigo.isEmpty()) {
			cidade.setCodigo(Long.valueOf(codigo));
		}
		cidade.setUf(cbUF.getValue());
		return cidade;
	}

}
