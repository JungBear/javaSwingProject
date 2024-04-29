package platform;

import javax.swing.BoxLayout;
import javax.swing.JFrame;

import shoppingCart.JFrameCart;

public class MainFrame extends JFrame {

	private JFrame mainF = new JFrame("홈쇼핑");
	
	
	
	public void setMainFrame() {
		mainF.setBounds(150, 70, 1280, 960);
		
		MainHeader mainHeader = new MainHeader();
		MainDetail mainDetail = new MainDetail();
		JFrameCart jFramCart = new JFrameCart();
		
		
		mainF.setLayout(new BoxLayout(mainF.getContentPane(), BoxLayout.Y_AXIS));
		mainF.add(mainHeader.setMainHeader(this));
		//mainF.add(mainDetail.setMainDetail());
//		mainF.add(jFramCart);
		mainF.setVisible(true);
		mainF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	
				
		
	
}
