package shoppingCart;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

public class ShoppingCartPanel extends JPanel{
    private int totalPayment = 0;
	
	public ShoppingCartPanel() {
		ShoppingListPanel shoppingListPanel = new ShoppingListPanel();
		
		TotalOrderPanel totalOrderPanel = new TotalOrderPanel();
		
		//tableModel 액션리스너 
		// tableModel.addTableModelListener(new TableEventAdepter());2024.04.30수정중 
		

		//총 결제 금액을 표시하는 totalOrderPanel을 생성해서 JPanel을 추가 
		setLayout(null);
		add(shoppingListPanel);
		add(totalOrderPanel);
		
		setBackground(Color.black);//장바구니panel전체 
		setBounds(0,201,1280,760);
		
	}
	
	
    
	
}
	
	
	
	
	