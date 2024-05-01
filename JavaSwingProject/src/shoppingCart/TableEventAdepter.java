package shoppingCart;

import java.util.ArrayList;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class TableEventAdepter implements TableModelListener {
	TableModel tableModel;
	ArrayList<Orders> orders;
	TotalOrderPanel totalOrderPanel;
	
	public TableEventAdepter(TableModel tableModel, ArrayList<Orders> orders, TotalOrderPanel totalOrderPanel) {
		this.tableModel = tableModel;
		this.orders = orders;
		this.totalOrderPanel = totalOrderPanel;
		
	}
	
	
	@Override
	public void tableChanged(TableModelEvent e) {
		int row = e.getFirstRow();
		int cloumn = e.getColumn();
		
		
		if(cloumn == 0 && row >= 0) {
			
			boolean selected = (boolean) tableModel.getValueAt(row, cloumn);
			System.out.println("selected값 " + selected);
			
			if(selected) { //selected의 값이 1인 경우(주문건이 선택 된 경우) 합산 
				Orders order = orders.get(row);
				System.out.println(order);
				
				
				totalOrderPanel.setTotalPayment(totalOrderPanel.getTotalPayment()+order.getTotalPrice()); 
			}else {
				Orders order = orders.get(row);
				totalOrderPanel.setTotalPayment(totalOrderPanel.getTotalPayment()-order.getTotalPrice()); 
				
			}
			
//			totalOrderPanel.updateTotalPayment();
			
		}
		
	}
}


