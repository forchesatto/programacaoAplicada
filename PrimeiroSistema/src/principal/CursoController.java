package principal;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import principal.dao.AreaArquivo;
import principal.dao.AreaDAO;
import principal.dao.CursoArquivo;
import principal.dao.CursoDAO;
import principal.model.Area;
import principal.model.Curso;

public class CursoController {

	@FXML
	private TextField tfCodigo;

	@FXML
	private TextField tfNome;

	@FXML
	private Button btnSalvar;

	@FXML
	private TableView<Curso> tblCurso;

	@FXML
	private TableColumn<Curso, Number> tbcCodigo;

	@FXML
	private TableColumn<Curso, String> tbcNome;

	@FXML
	private TableColumn<Curso, String> tbcDataCriacao;

	@FXML
	private DatePicker dtCriacao;
	
	@FXML
	private ComboBox<Area> cbxArea;
	
	private Curso curso;

	private boolean editando;

	private CursoDAO cursoDao = new CursoArquivo();
	
	private AreaDAO areaDao = new AreaArquivo();

	/**
	 * Inicializa a classe controller. Este método é chamado automaticamente
	 * após o arquivo fxml ter sido carregado.
	 */
	@FXML
	private void initialize() {
		// Inicializa a tabela de curso com duas colunas.
		tbcCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
		tbcNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		tbcDataCriacao.setCellValueFactory(new PropertyValueFactory<>("dataCriacao"));
		populaCombo();
		novoCurso();
	}
	
	private void populaCombo(){
		for(Area area: areaDao.listar()){
			cbxArea.getItems().add(area);
		}
	}

	@FXML
	void salvar(ActionEvent event) {

		populaCurso();

		if (editando) {
			cursoDao.alterar(curso);
		} else {
			cursoDao.inserir(curso);				
		}
		novoCurso();
		tblCurso.refresh();
	}

	public void populaCurso() {
		curso.setCodigo(Integer.valueOf(tfCodigo.getText()));
		curso.setNome(tfNome.getText());
		curso.setDataCriacao(dtCriacao.getValue());
		curso.setArea(cbxArea.getValue());
	}

	public void populaTela(Curso curso) {
		tfCodigo.setText(curso.getCodigo().toString());
		tfNome.setText(curso.getNome());
		dtCriacao.setValue(curso.getDataCriacao());
		cbxArea.getSelectionModel().select(curso.getArea());
	}

	@FXML
	void selecionaCurso(MouseEvent event) {
		if (tblCurso.getSelectionModel().getSelectedItem() != null) {
			curso = tblCurso.getSelectionModel().getSelectedItem();
			populaTela(curso);
			editando = true;
		}
	}

	@FXML
	void excluir(ActionEvent event) {
		cursoDao.excluir(curso);
		novoCurso();
	}

	@FXML
	void novo(ActionEvent event) {
		novoCurso();
	}

	void novoCurso() {
		tfNome.clear();
		tfCodigo.clear();
		dtCriacao.setValue(null);
		curso = new Curso();
		editando = false;
		cbxArea.getSelectionModel().clearSelection();
		tblCurso.setItems(FXCollections.observableArrayList(cursoDao.listar()));
	}

}
