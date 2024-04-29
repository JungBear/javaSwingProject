package platform;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

public class TopNavBtn extends JButton{
	TopNavBtnEventListener eventListener;

	public TopNavBtn(String btnName,int x, int y) {
		super(btnName);
		this.setBounds(x, y, 100, 80);
		this.setBackground(Color.GRAY);
		this.setBorder(new EmptyBorder(5,3,5,3));
	}
	
	
	
	
		
}
