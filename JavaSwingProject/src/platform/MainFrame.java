package platform;

import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import login_form.LoginForm;
import shoppingCart.ShoppingCartPanel;
import userDTO.UserDTO;

public class MainFrame extends JFrame implements MainHeaderListener{

	ShoppingCartPanel shoppingCartGUI = new ShoppingCartPanel();
	MainHeader mainHeader = new MainHeader(this);
	MainPreView mainPreView = new MainPreView(mainHeader, this);
	LoginForm loginFrame = new LoginForm(this);
	UserDTO user = LoginForm.getLoginUser();
//	ProductDetailPanel pdp;
	





	public MainFrame() {
		
		loginFrame.setVisible(false);
		setBounds(150, 70, 1280, 960);
		setLayout(null);
		add(mainHeader);
		add(mainPreView);
		add(shoppingCartGUI);
//		scrollPane = new JScrollPane(mainPreView, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
//		mainPreView.setBounds(0, 0, 1280, 200);
//		mainPreView.setBounds(0, 1000, 1270, 760);
//		scrollPane.setBounds(0, 200, 1270, 760);
//		add(scrollPane);		
		
		shoppingCartGUI.setVisible(false);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
//		System.out.println(mainPreView.isVisible());
//		System.out.println(mainHeader.isVisible());
		System.out.println("메인프레임의 유저 : " + user);
	}

		
	public void setMainFrame() {
//	    scrollPane.setVisible(true);
	    mainPreView.setVisible(true);
	}

	@Override
	public void onLogoClicked() {
		hideVisiblePanelExceptHeader();
	    setMainFrame(); // 메인 프레임 설정만 실행
	    mainPreView.setVisible(true);

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
	
    public MainHeader getMainHeader() {
    	return mainHeader;
    }
    
    
    public void setMainHeader(MainHeader mainHeader) {
    	this.mainHeader = mainHeader;
    }
				
		
	
}
