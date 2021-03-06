package br.edu.unoesc.jdbcOO.controller;

import java.net.URL;
import java.util.Collection;
import java.util.List;

import br.edu.unoesc.jdbcOO.dao.UFDAO;
import br.edu.unoesc.jdbcOO.factory.DAOFactory;
import br.edu.unoesc.jdbcOO.model.UF;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

public class UFController {

	@FXML
	private TextField tfCodigo;

	@FXML
	private TextField tfNome;

	@FXML
	private TextField tfPesquisa;

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
		// tcCodigo.setCellValueFactory(uf ->
		// uf.getValue().getCodigoProperty());
		// tcNome.setCellValueFactory(uf -> uf.getValue().getNomeProperty());
		tcCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
		tcNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		atualizaTabela();
		ouvirSelecaoTabela();
	}

	private void ouvirSelecaoTabela() {
		tblUf.getSelectionModel().selectedItemProperty().addListener((observable, ufVelha, ufSelecionada) -> {
			if (ufSelecionada != null) {
				populaTela(ufSelecionada);
			}
		});
	}

	private void atualizaTabela() {
		Collection<UF> ufs = ufDAO.todos();
		tblUf.setItems(FXCollections.observableArrayList(ufs));
	}

	private void populaTela(UF ufSelecionada) {
		tfCodigo.setText(ufSelecionada.getCodigo().toString());
		tfNome.setText(ufSelecionada.getNome());
	}

	@FXML
	void onSalvar(ActionEvent event) {
		UF uf = criaUf();
		ufDAO.salvar(uf);
		atualizaTabela();
		tfCodigo.setText(uf.getCodigo().toString());
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

	@FXML
	void onPesquisar(KeyEvent event) {
		/*
		 * Dentro do tfPesquisa.getText() tem as letras antes da que esta no
		 * "event" por esse motivo preciso concatenar com o event.
		 */
		String pesquisa = tfPesquisa.getText() + event.getText();
		if (pesquisa.length() > 2) {
			List<UF> ufs = ufDAO.getPorNome(pesquisa);
			tblUf.setItems(FXCollections.observableArrayList(ufs));
		}
		if (pesquisa.length() < 2) {
			atualizaTabela();
		}
	}

	@FXML
	void onRelatorio(ActionEvent event) {
		URL url = getClass().getResource("/relatorio/relatorioUFDataSource.jasper");
//		 try {
//			 Map<String, Object> parametros = new HashMap<>();
//			 parametros.put("nomeUf", "%sa%");
//			 JasperPrint jasperPrint = JasperFillManager
//					 .fillReport(
//							 url.getPath(),
//							 parametros, 
//							 new ConexaoMysqlProducao().get());
//			 JasperViewer.viewReport(jasperPrint);
//			// JasperExportManager.exportReportToPdfFile(jasperPrint,
//			// "relatorio.pdf");
//		 } catch (JRException e) {
//		 e.printStackTrace();
//		 }
		try {

			JRDataSource dataSource = 
					new JRBeanCollectionDataSource(ufDAO.todos()); // dados do relatório

			JasperPrint jasperPrint = JasperFillManager
					.fillReport(url.getPath(), null, dataSource);
			JasperViewer.viewReport(jasperPrint);
		} catch (JRException e) {
			e.printStackTrace();
		}
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
