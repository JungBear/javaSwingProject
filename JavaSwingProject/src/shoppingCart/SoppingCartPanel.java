package shoppingCart;

import java.awt.BorderLayout;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

public class SoppingCartPanel extends JPanel{
    private int totalPayment = 0;
	
	public SoppingCartPanel() {
		ShoppingListPanel shoppingListPanel = new ShoppingListPanel();
		
		TotalOrderPanel totalOrderPanel = new TotalOrderPanel(totalPayment);
		
		//tableModel 액션리스너 
		// tableModel.addTableModelListener(new TableEventAdepter());2024.04.30수정중 
		

		//총 결제 금액을 표시하는 totalOrderPanel을 생성해서 JPanel을 추가 
		add(totalOrderPanel, BorderLayout.SOUTH);
		
	}
	
	
    
	
}
	
	
	
	
	