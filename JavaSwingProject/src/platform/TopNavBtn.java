package platform;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

public class TopNavBtn extends JButton{
	TopNavBtnEventListener eventListener;

	public TopNavBtn(String btnName,int x, int y) {
		this.setName(btnName);
		this.setBounds(x, y, 40, 40);
		this.setBackground(Color.GRAY);
		this.setBorder(new EmptyBorder(5,3,5,3));
	}
	
	
	
	
		
}
