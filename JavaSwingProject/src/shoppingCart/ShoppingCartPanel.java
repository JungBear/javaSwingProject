package shoppingCart;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

public class ShoppingCartPanel extends JPanel{
    private int totalPayment = 0;
    DefaultTableModel tableModel;
    public TotalOrderPanel totalOrderPanel;
    ShoppingListPanel shoppingListPanel;
	
	public ShoppingCartPanel() {
		
		//1. 마우스 이벤트에 추가하기 위한 기본 Panel생성 
		this.totalOrderPanel = new TotalOrderPanel();
		this.shoppingListPanel = new ShoppingListPanel(totalOrderPanel);//수량이 변경될 때 마우스이벤트에 기본 Panel추가 
		totalOrderPanel.setOrders(shoppingListPanel.getOrders());
		
		int priceAdd = shoppingListPanel.selectAdd();//마우스 이벤트 발생한 값을 priceAdd에 넣기
		
		totalOrderPanel.setTotalProductPayment(priceAdd);	//그 값을 totalOrderPanel로 보내주기 
		totalOrderPanel.setTotalOrderPanel();// Panel 그리기 
		
		


		//총 결제 금액을 표시하는 totalOrderPanel을 생성해서 JPanel을 추가 
		setLayout(null);
		add(shoppingListPanel);
		add(totalOrderPanel);
		
		//장바구니 패널 전체 영역 사이즈
		setBounds(0,201,1280,760);

		
		
		
	}

	public ShoppingListPanel getShoppingListPanel() {
		return shoppingListPanel;
	}
	
	
    
	
}
	
	
	
	
	