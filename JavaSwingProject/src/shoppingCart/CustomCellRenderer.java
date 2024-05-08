package shoppingCart;

import java.awt.Color;
import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class CustomCellRenderer implements TableCellRenderer{
	private TableCellRenderer defaultCellRenderer;
	
	public CustomCellRenderer(TableCellRenderer defaulCellRenderer) {
		this.defaultCellRenderer = defaulCellRenderer;
	}
	
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		Component c = defaultCellRenderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        

        // 주문 행마다 테두리 추가
		// 주문이 선택된 경우 해당 행에 테두리를 추가
        if (isSelected) {
            ((JComponent) c).setBorder(BorderFactory.createLineBorder(Color.gray));
        } else {
            ((JComponent) c).setBorder(null); // 선택되지 않은 행은 테두리 없음
        }

        return c;

	}
}
