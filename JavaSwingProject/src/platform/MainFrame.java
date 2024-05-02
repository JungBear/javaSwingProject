package platform;

import java.awt.Component;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import shoppingCart.ShoppingCartPanel;

public class MainFrame extends JFrame implements MainHeaderListener{

	MainHeader mainHeader = new MainHeader(this);
	MainPreView MainPreView = new MainPreView();

	ShoppingCartPanel shoppingCartGUI = new ShoppingCartPanel();
		
	public void setMainFrame() {

		setBounds(150, 70, 1280, 960);
		setLayout(null);
		add(mainHeader);
		add(MainPreView);
		add(shoppingCartGUI);
		
		shoppingCartGUI.setVisible(false);
		
//		mainF.add(jFramCart);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		System.out.println(MainPreView.isVisible());
		System.out.println(mainHeader.isVisible());
	}

	@Override
	public void onLogoClicked() {
	    setMainFrame(); // 메인 프레임 설정만 실행
	}
	
    public void showShoppingCartPanel() {
	 	shoppingCartGUI = new ShoppingCartPanel();


	    // 현재 화면에 표시되고 있는 패널을 찾습니다.
	    hideVisiblePanelExceptHeader();

	    // 장바구니 패널을 화면에 추가합니다.
	    setLayout(null);
	    getContentPane().add(shoppingCartGUI);
	    setVisible(true);
    
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
