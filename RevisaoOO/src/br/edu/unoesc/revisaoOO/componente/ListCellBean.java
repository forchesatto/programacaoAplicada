package br.edu.unoesc.revisaoOO.componente;

import javafx.scene.control.ListCell;

public class ListCellBean<T extends RenderizaCombo> extends ListCell<T> {

	@Override
	protected void updateItem(T item, boolean empty) {
		super.updateItem(item, empty);
		if (item == null || empty) {
			setText(null);
		} else {
			setText(item.getText());
		}
	}
}
