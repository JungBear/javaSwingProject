package platform;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

public class TopNavBtn extends JButton{
	
	

	public TopNavBtn(String name, int x, int y) {
		super(name);
		setBounds(x, y, 60, 30);
		setBackground(Color.GRAY);
		setBorder(new EmptyBorder(5,3,5,3));
		setFont(getFont());
		
		setVisible(true);
	}
	
		
}
	
		

