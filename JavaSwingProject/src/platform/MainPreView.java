package platform;



import java.awt.TextArea;

import javax.swing.JPanel;

public class MainPreView extends JPanel{
	
	final int KIND = 4;
	String[] kinds = {"의류", "화장품", "신발", "가방"};
	
	public MainPreView() {
		setBounds(200, 0, 1280, 760);
		for (String kind : kinds) {
			TextArea title = new TextArea();
			
			
			add(title);
		}
	}
}
