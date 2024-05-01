package shoppingCart;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class TableEventAdepter extends JPanel implements MouseListener{
	DefaultTableModel tableModel;
	
	@Override
	public void mouseClicked(MouseEvent e) {
	int row = tableModel.getRowCount();
	int clo = tableModel.getColumnCount();
	
	for(int i = 0; i < tableModel.getColumnCount(); i++) {
		//System.out.println(tableModel.get);
	}
		
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	//0501 수정 전 코드 
	
//	TableModel tableModel;
//	ArrayList<Orders> orders;
//	TotalOrderPanel totalOrderPanel;
//	
//	public TableEventAdepter(TableModel tableModel, ArrayList<Orders> orders, TotalOrderPanel totalOrderPanel) {
//		this.tableModel = tableModel;
//		this.orders = orders;
//		this.totalOrderPanel = totalOrderPanel;
//		
//	}
//	
//	
//	@Override
//	public void tableChanged(TableModelEvent e) {
//		int row = e.getFirstRow();
//		int cloumn = e.getColumn();
//		
//		
//		if(cloumn == 0 && row >= 0) {
//			
//			boolean selected = (boolean) tableModel.getValueAt(row, cloumn);
//			System.out.println("selected값 " + selected);
//			
//			if(selected) { //selected의 값이 1인 경우(주문건이 선택 된 경우) 합산 
//				Orders order = orders.get(row);
//				System.out.println(order);
//				
//				
//				totalOrderPanel.setTotalPayment(totalOrderPanel.getTotalPayment()+order.getTotalPrice()); 
//			}else {
//				Orders order = orders.get(row);
//				totalOrderPanel.setTotalPayment(totalOrderPanel.getTotalPayment()-order.getTotalPrice()); 
//				
//			}
//			
//			totalOrderPanel.updateTotalPayment();
//			
//		}
//		
//	}
}


