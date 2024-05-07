package shoppingCart;

import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class CenterRenderer extends DefaultTableCellRenderer{
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
		Component rendererComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        
        // 선택 열과 삭제 열은 중앙 정렬하지 않음
        if (column != 0 && column != 6) {
            ((JLabel) rendererComponent).setHorizontalAlignment(SwingConstants.CENTER);
        }
        
        return rendererComponent;
    }
}
