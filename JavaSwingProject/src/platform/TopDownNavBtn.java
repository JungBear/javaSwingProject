package platform;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

public class TopDownNavBtn extends JButton{
	public TopDownNavBtn(String name,int x, int y) {
		setName(name);
		this.setBounds(x, y, 60, 40);
		this.setBackground(Color.DARK_GRAY);
		this.setBorder(new EmptyBorder(5,3,5,3));
	}

}
