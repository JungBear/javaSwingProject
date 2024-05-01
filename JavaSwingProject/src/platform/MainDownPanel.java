package platform;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MainDownPanel extends JPanel{
	
	TopDownNavBtn top = new TopDownNavBtn("cloth",WIDTH, WIDTH);
	
	public MainDownPanel(String name,int x, int y) {
		setName(name);
		setBounds(x, y, 60, 40);
		this.setBackground(Color.GRAY);
		this.setBorder(new EmptyBorder(5,3,5,3));
	}
	
	
}
