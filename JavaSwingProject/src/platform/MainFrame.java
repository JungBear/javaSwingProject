package platform;

import javax.swing.BoxLayout;
import javax.swing.JFrame;

import shoppingCart.SoppingCartPanel;

public class MainFrame extends JFrame implements MainHeaderListener{

	MainHeader mainHeader = new MainHeader(this);
	MainDetail mainDetail = new MainDetail();
		
	public void setMainFrame() {
		setBounds(150, 70, 1280, 960);
		
		
		
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		add(mainHeader);
		add(mainDetail);
		
//		mainF.add(jFramCart);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	@Override
	public void onLogoClicked() {
		setMainFrame();
		
	}
	
    public void showShoppingCartPanel() {
    	SoppingCartPanel shoppingCartGUI = new SoppingCartPanel();
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        add(mainHeader);
        add(shoppingCartGUI); // ShoppingCartPanel로 대체
        setVisible(true);
        
    }
	
				
		
	
}
