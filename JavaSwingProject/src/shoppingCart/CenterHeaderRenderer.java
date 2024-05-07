package shoppingCart;

import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class CenterHeaderRenderer extends DefaultTableCellRenderer {
	 public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
	        JLabel headerLabel = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
	        headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
	        return headerLabel;
	    }
}
