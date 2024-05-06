package shoppingCart;

import java.awt.Component;

import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

//JTable에서 체크박스를 사용하려면 체크박스를 렌더링 해주는 과정이 필요함 

public class CheckBoxRenderer extends JCheckBox implements TableCellRenderer{
	public CheckBoxRenderer() {
		setHorizontalAlignment(JLabel.CENTER);
	}
	
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		setSelected((Boolean) value);
		return this;
	}
}

class CheckBoxEditor extends DefaultCellEditor{
	public CheckBoxEditor() {
		super(new JCheckBox());
	}
	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		JCheckBox checkBox = (JCheckBox) editorComponent;
		checkBox.setSelected((Boolean) value);
		return editorComponent;
	}
	
	@Override
	public Object getCellEditorValue() {
		return((JCheckBox) editorComponent).isSelected();
	}
}
