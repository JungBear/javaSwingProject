package shoppingCart;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class ShoppingListPanel extends JPanel {
	JTable table;//장바구니 헤더, 리스트를 담을 테이블 
    public static DefaultTableModel tableModel;
     static ArrayList<Orders> orders = new ArrayList<>();
    int selectOrdersAdd=0;
	private TotalOrderPanel totalOrderPanel;
    	
    
    	public ArrayList<Orders> getOrders() {
    		return orders;
    	}
    	
   
    	public void add(Orders order) {
    		orders.add(order);
    	}
    	
    	public static void clear() {
    		orders.clear();
    	}
    	

    	public ShoppingListPanel(TotalOrderPanel totalOrderPanel)    {   
    		//주문 정보를 담을 ArrayList생성 
    		orders = new ArrayList<>();
    		
    		//장바구니 컬럼명
    		String[] cartHeader = {"선택", "상품 정보", "금액", "수량", "전체 금액", "배송비", "삭제"};
    		tableModel = new DefaultTableModel(null, cartHeader ) {
    			@Override
    			public Class<?> getColumnClass(int columnIndex) {
    				if (columnIndex == 0) {
    					return Boolean.class; // 선택열은 불린형
    				} else if (columnIndex == 3) {
    					return Integer.class;//수량 열은 정수형 
    				} else if(columnIndex == 6) {
    					return JButton.class;//삭제 열은 버튼타입 
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
    		

    			//order데이터가 있을 때 테이블 목록 생성
    			//주문 데이터를 테이블에 추가 
    			for (Orders order : orders) {
    			    
    				Object[] row = {order.getSelect(), order.getInfo(), order.getPrice(), order.getQuantity(),
    						order.getTotalPrice(), order.getDelivery(), order.getDelete()};
    				tableModel.addRow(row);
    			}
    			
    		table = new JTable(tableModel);//장바구니 table 생성
    		
    		 // 테이블에 테두리 설정
            Border tableBorder = BorderFactory.createLineBorder(Color.BLACK); // 테두리 색을 검정색으로 설정
            table.setBorder(tableBorder);

    	    JTableHeader header = table.getTableHeader();
    	    header.setPreferredSize(new Dimension(header.getWidth(), 40)); // 헤더의 높이
    	    header.setDefaultRenderer(new CenterHeaderRenderer());
    	    
    		table.setRowHeight(50);//각 행의 높이
    			
    		//선택열 체크박스 생성 및 추가
    		table.getColumnModel().getColumn(0).setPreferredWidth(5);//체크박스 열의 넓이
    		table.getColumnModel().getColumn(0).setCellRenderer(new CheckBoxRenderer());//체크박스 렌더링
    		table.getColumnModel().getColumn(0).setCellEditor(new CheckBoxEditor());//체크박스 에디터
    		table.getColumnModel().getColumn(0).getCellEditor().addCellEditorListener(new CellEditorListener() {//체크박스 리스너
				
				@Override
				public void editingStopped(ChangeEvent e) {
					 int row = table.getSelectedRow();
				        boolean isSelected = (Boolean) table.getValueAt(row, 0);
				        orders.get(row).setSelect(isSelected);
				        System.out.println(orders);
				        totalOrderPanel.updateSelectPayment(orders); // 선택 변경 후 총 결제 금액 업데이트
//				        totalOrderPanel.updateTotalPayment(orders); // 선택 변경 후 총 결제 금액 업데이트
					
				}
				
				@Override
				public void editingCanceled(ChangeEvent e) {
					
					
				}
			});
    		
    		//상품정보 열 
    		table.getColumnModel().getColumn(3).setPreferredWidth(70);//상품정보 열의 넓이
    		
    		//금액열 
    		table.getColumnModel().getColumn(3).setPreferredWidth(20);//금액 열의 넓이
    		
    		//수량에 콤보박스 추가 
    		table.getColumnModel().getColumn(3).setCellEditor(new QuantityComboBox(table, tableModel, orders, totalOrderPanel));
    		table.getColumnModel().getColumn(3).setPreferredWidth(5);//수량 열의 넓이
    		
    		//전체금액열 
    		table.getColumnModel().getColumn(5).setPreferredWidth(20);//금액 열의 넓이
    		
    		//배송비 열 
    		table.getColumnModel().getColumn(6).setPreferredWidth(10);//금액 열의 넓이

    		
    		//삭제열에 삭제버튼 추가 
    		DeleteButton deleteButtonAction = new DeleteButton(table, 6, totalOrderPanel,orders);
    		table.getColumnModel().getColumn(6).setPreferredWidth(10);//삭제버튼 열의 넓이
    		
    		//모든 셀의 폰트는 중앙정렬
    		for (int i = 0; i < table.getColumnCount(); i++) {
    	        table.getColumnModel().getColumn(i).setCellRenderer(new CenterRenderer());
    	    }
    		
    		// 스크롤에 테이블 추가
    		JScrollPane scrollPane = new JScrollPane(table);
    		scrollPane.setPreferredSize(new Dimension(800,400));
    		setBackground(Color.blue);
    		setBounds(0,0,1280,450);
    		add(scrollPane, BorderLayout.CENTER);
    		


    	}
    	
    	
    	
    	
    	//장바구니 첫 화면에서 보이는 하단 상품의 결제 금액 부분 
    	public int selectAdd() {
    		
    		for (Orders orders : orders) {
    			if(orders.getSelect()) {
    				selectOrdersAdd += orders.getTotalPrice();
    			}
			}
    		return selectOrdersAdd;
    	}

        public static void updateTable() {
            // 테이블 모델을 초기화합니다.
            tableModel.setRowCount(0);

            // orders 리스트에 있는 모든 주문을 테이블에 추가합니다.
            for (Orders order : orders) {
                Object[] row = new Object[]{order.getSelect(), order.getInfo(), order.getPrice(), order.getQuantity(),
                        order.getTotalPrice(), order.getDelivery(), order.getDelete()};
                tableModel.addRow(row);
            }

            // 테이블 모델 변경 사항을 알립니다.
            tableModel.fireTableDataChanged();
        }
        
        //선택한 상품의 주문건은 테이블에서 삭제하기
        public static void removeSelectedOrders() {
            for (int i = orders.size() - 1; i >= 0; i--) {
                if (orders.get(i).getSelect()) {
                    tableModel.removeRow(i); // 테이블에서 삭제
                    orders.remove(i); // 주문 목록에서 삭제
                }
            }
        }
        
        
        
		public JTable getTable() {
			return table;
		}

		public void setTable(JTable table) {
			this.table = table;
		}

		public DefaultTableModel getTableModel() {
			return tableModel;
		}

		public void setTableModel(DefaultTableModel tableModel) {
			this.tableModel = tableModel;
		}

		public int getSelectOrdersAdd() {
			return selectOrdersAdd;
		}

		public void setSelectOrdersAdd(int selectOrdersAdd) {
			this.selectOrdersAdd = selectOrdersAdd;
		}

		public void setOrders(ArrayList<Orders> orders) {
			this.orders = orders;
		}

}
