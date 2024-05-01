package shoppingCart;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class SoppingCartPanel extends JPanel{
    private int totalPayment = 0;
	
	public SoppingCartPanel() {
		ShoppingListPanel shoppingListPanel = new ShoppingListPanel();
		
		TotalOrderPanel totalOrderPanel = new TotalOrderPanel();
		
		//tableModel 액션리스너 
		// tableModel.addTableModelListener(new TableEventAdepter());2024.04.30수정중 
		

		//총 결제 금액을 표시하는 totalOrderPanel을 생성해서 JPanel을 추가 
		add(shoppingListPanel, BorderLayout.CENTER);
		add(totalOrderPanel);
		
		setBounds(0,200,1280,760);
		
	}
	
	
    
	
}
	
	
	
	
	