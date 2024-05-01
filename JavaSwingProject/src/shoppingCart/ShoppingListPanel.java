package shoppingCart;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class ShoppingListPanel extends JPanel {
	JTable table;//장바구니 헤더, 리스트를 담을 테이블 
    DefaultTableModel tableModel;
    private ArrayList<Orders> orders;

    
    	public ArrayList<Orders> getOrders() {
    		return orders;
    	}
    
    	public ShoppingListPanel()    {   
	
    		//주문 정보를 담을 ArrayList생성 
    		orders = new ArrayList<>();
	
	
    		// 임의 데이터 
    		orders.add(new Orders(true, " 상품 1 ", 10000, 1, 5, false));
    		orders.add(new Orders(true, " 상품 2 ", 5000, 1, 5, false));
	 
    		//장바구니 컬럼명
    		String[] cartHeader = {"선택", "상품 정보", "금액", "수량", "전체 금액", "배송비", "삭제"};
    		tableModel = new DefaultTableModel(null, cartHeader ) {
    			@Override
    			public Class<?> getColumnClass(int columnIndex) {
    				if (columnIndex == 0 || columnIndex == 6) {
    					return Boolean.class; // 선택, 삭제 열은 불린타입
    				} else if (columnIndex == 3) {
    					return Integer.class;//수량 열은 정수형 
    				}
    				else {
    					return getValueAt(0, columnIndex).getClass(); 
    				}
    			}
    	
    			// 특정 열만 편집 가능하도록 iCellEditable 재정의
    			@Override
    			public boolean isCellEditable(int row, int column) {
    				//선택, 수량, 삭제 열만 편집 가능
    				return column == 0 || column == 3 || column == 6;
    			}
    		};
    
    		if(orders.size() == 0) {
    			//order데이터가 없을 때 나타내는 메세지 
    			setLayout(new BorderLayout());
    			JLabel nullMessageLabel = new JLabel("장바구니에 넣은 상품이 없습니다.");
    			nullMessageLabel.setHorizontalAlignment(SwingConstants.CENTER);
    			add(nullMessageLabel, BorderLayout.CENTER);
    	
    		} else {
    			//order데이터가 있을 때 테이블 목록 생성
    			//주문 데이터를 테이블에 추가 
    			for (Orders order : orders) {
    				Object[] row = {order.getSelect(), order.getInfo(), order.getPrice(), order.getQuantity(),
    						order.getTotalPrice(), order.getDelivery(), order.getDelete()};
    				tableModel.addRow(row);
    			}

    		}
    		
    		//장바구니 table 생성
    		table = new JTable(tableModel);
    		
    		//수량에 콤보박스 추가 
    		table.getColumnModel().getColumn(3).setCellEditor(new QuantityComboBox(table, tableModel, orders));
    		
    		// 스크롤에 테이블 추가
    		JScrollPane scrollPane = new JScrollPane(table);
//    		scrollPane.setPreferredSize(new Dimension(800,400));
    		setBackground(Color.blue);
    		setBounds(0,0,1280,550);
    		add(scrollPane, BorderLayout.CENTER);

    	}
    	
    	
}
