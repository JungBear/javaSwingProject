package platform;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

public class TopNavBtn extends JButton{
	TopNavBtnEventListener eventListener;
	// 현재 페이지의 상태를 나타내기 위한 id
	private int id = 0;

	public TopNavBtn(String btnName,int x, int y, int id) {
		super(btnName);
		this.setBounds(x, y, 60, 40);
		this.setBackground(Color.GRAY);
		this.setBorder(new EmptyBorder(5,3,5,3));
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
	
	
		
}
