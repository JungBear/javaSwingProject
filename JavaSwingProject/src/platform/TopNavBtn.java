package platform;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

public class TopNavBtn extends JButton{
	TopNavBtnEventListener eventListener;
	
	

	public TopNavBtn(String name, int x, int y) {
		super(name);
		setBounds(x, y, 60, 40);
		setBackground(Color.GRAY);
		setBorder(new EmptyBorder(5,3,5,3));
		
		setVisible(true);
	}
	
		
}
	
		

