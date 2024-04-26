package platform;

import javax.swing.JFrame;

public class MainFrame extends JFrame {

	private JFrame mainF = new JFrame("홈쇼핑");

	
	
	public void setMainFrame() {
		mainF.setBounds(150, 70, 1280, 960);
		
		MainHeader mainHeader = new MainHeader();
		MainDetail mainDetail = new MainDetail();
		
		
		
		mainF.add(mainHeader.setMainHeader(this));
		mainF.add(mainDetail.setMainDetail());
		mainF.setVisible(true);
		mainF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	
				
		
	
}
