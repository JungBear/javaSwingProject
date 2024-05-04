package platform;

import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import shoppingCart.ShoppingCartPanel;
import userDTO.UserDTO;

public class MainFrame extends JFrame implements MainHeaderListener{

	UserDTO user;
	ShoppingCartPanel shoppingCartGUI = new ShoppingCartPanel();
	MainHeader mainHeader = new MainHeader(this);
	MainPreView MainPreView = new MainPreView(mainHeader, this);
	
	public MainFrame() {
		setBounds(150, 70, 1280, 960);
		setLayout(null);
		add(mainHeader);
		add(MainPreView);
		add(shoppingCartGUI);
		
//		JScrollPane scrollPane = new JScrollPane(MainPreView);   //<- 생성자에 추가해주는 방법이있고
//		scrollPane.setViewportView(MainPreView);  //setViewportView() 메서드로 추가해주는 방법이있다.
//		add(scrollPane);
		
		
		shoppingCartGUI.setVisible(false);
		
//		mainF.add(jFramCart);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		System.out.println(MainPreView.isVisible());
		System.out.println(mainHeader.isVisible());
	
	}

		
	public void setMainFrame() {
		setVisible(true);
	}

	@Override
	public void onLogoClicked() {
		hideVisiblePanelExceptHeader();
	    setMainFrame(); // 메인 프레임 설정만 실행
	}
	
    public void showShoppingCartPanel() {
//	 	shoppingCartGUI = new ShoppingCartPanel();


	    // 현재 화면에 표시되고 있는 패널을 찾습니다.
	    hideVisiblePanelExceptHeader();
	    // 장바구니 패널을 화면에 추가합니다.
	    setLayout(null);
	    getContentPane().add(shoppingCartGUI);
	    shoppingCartGUI.setVisible(true);
	    shoppingCartGUI.getShoppingListPanel().updateTable();
	    shoppingCartGUI.totalOrderPanel.updateTotalPayment(shoppingCartGUI.getShoppingListPanel().getOrders());
//	    System.out.println("장바구니리스트 : " + shoppingCartGUI.getShoppingListPanel().getOrders());
    
    }
    
    /**
     * 화면을 이동하기 전 현재 보여지는 판넬을 숨기는 함수	
     * 
     * 사용하는 곳에서 보여주려는 panel을 setvisivle(true)를 통해 알려줘야한다
     */

    public void hideVisiblePanelExceptHeader() {
        Component[] components = getContentPane().getComponents();
        for (Component component : components) {
        	// 현재 보여지면서 header인 판넬을 숨긴다
            if (component instanceof JPanel && component.isVisible() && !"header".equals(component.getName())) {
                JPanel visiblePanel = (JPanel) component;
                // 현재 보여지는 패널을 숨깁니다.
                visiblePanel.setVisible(false);
            }
        }
    }
	
				
		
	
}
