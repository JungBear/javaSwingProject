package shoppingCart;

import java.awt.Component;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

public class CenterHeaderRenderer extends DefaultTableCellRenderer {
	
	private Font font;
	
	 public CenterHeaderRenderer(Font font) {
	        this.font = font;
		 	setHorizontalAlignment(SwingConstants.CENTER); //ㅌ스트를 중앙 정렬
	        
	    }

	 
	 @Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		 	JTableHeader header = table.getTableHeader();
	        setForeground(header.getForeground());
	        setBackground(header.getBackground());
	        setFont(font);
	        setText(value != null ? value.toString() : "");
	        return this;
	}
	 
	 
}
