package shoppingCart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class JFrameCart extends JPanel {
	DefaultTableModel table;
	JTable jTable;
	JScrollPane jsp;
	ArrayList<Orders> orders;
	JButton selcetButton, deleteButton;
	
	// int count[] = {1,2,3,4,5,6,7,8,9,10}; 수량 리스트박스 
	
	
	   public JFrameCart() {
		   //행과 열을 table에 집어 넣기
		   table = new DefaultTableModel(getColumnNames(),0);
		   orders = getOrders();
		   setRows();
		   
		   jTable = new JTable(table);
		   
		   jsp = new JScrollPane(jTable);
		   add(jsp);
		   
		   //setSize(400,300);
		   setBounds(201, 0, 1280, 200);
		   setVisible(true);
		   
		   
		   
		   //수량 선택리스트
		   
	   }
	   
	   
	   //칼럼 세팅
	   public Vector<String> getColumnNames(){
		   Vector<String> cloumnNames = new Vector<>();
		   cloumnNames.add("선택");
		   cloumnNames.add("상품 정보");
		   cloumnNames.add("구매가");
		   cloumnNames.add("수량");
		   cloumnNames.add("구매가");
		   cloumnNames.add("배송 정보");
		   cloumnNames.add("삭제");
		   
		   return cloumnNames;
		   
	   }
	   
	   //행 세팅 
	   public void setRows() {
		   
		   
		   //System.out.println(row.length);
		   Object[] row = new Object[orders.size()*7];
		   for(int i = 0; i < orders.size(); i+=7) {
			   
			   row[i]=orders.get(i).getSelect();
			   row[i+1]=orders.get(i).getInfo();
			   row[i+2]=orders.get(i).getPrice();
			   row[i+3]=orders.get(i).getQuantity();
			   row[i+4]=orders.get(i).getAllPrice();
			   row[i+5]=orders.get(i).getDelivery();
			   row[i+6]=orders.get(i).getDelete();
//			   
//			   row.add(orders.get(i).getSelect());
//			   row.add(orders.get(i).getInfo());
//			   row.add(orders.get(i).getPrice());
//			   row.add(orders.get(i).getQuantity()+"원");
//			   row.add(orders.get(i).getAllPrice());
//			   row.add(orders.get(i).getDelivery());
//			   row.add(orders.get(i).getDelete());
//			   
			   
		   }
		   table.addRow(row);
	   }
	   
	   //장바구니 담은 데이터 가져오기 
	   //데이터 임의 test
	   public ArrayList<Orders> getOrders(){
		   ArrayList<Orders> orders = new ArrayList<>();
		   orders.add(new Orders(true,"아우터",90_000,"2개","180,000원","3,000원","삭제"));
		   return orders;
	   }
	   
	   public static void main(String[] args) {
		new JFrameCart();
	}
}
