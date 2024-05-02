package shoppingCart;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class TableEventAdepter extends JPanel implements MouseListener{
	JTable table;
	TotalOrderPanel totalOrderPanel;
	
	public TableEventAdepter(JTable table, TotalOrderPanel totalOrderPanel) {
        this.table = table;
        this.totalOrderPanel = totalOrderPanel;

    }
	
	@Override
	public void mouseClicked(MouseEvent e) {
		//선택한 셀의 행 번호 계산
		int rowCount = table.getRowCount();
		int totalPrice = 0;
		
		for (int i = 0; i < rowCount; i++) {
            boolean isSelected = (boolean) table.getValueAt(i, 0);
            if (isSelected) {
                int productPrice = (int) table.getValueAt(i, 2); // 상품 금액
                int productQuantity = (int) table.getValueAt(i, 3); // 상품 수량
                totalPrice += productPrice * productQuantity;
            }
        }
		// totalOrderPanel.setTotalProductPayment(totalProductPayment);
	    // totalOrderPanel.updateTotalPayment();
	    
	
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


