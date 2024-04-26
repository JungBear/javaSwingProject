package platform;

import java.awt.Component;

import javax.swing.JPanel;

public class MainDetail {
	private JPanel mainDetailPanel;
	
	public Component setMainDetail() {
		mainDetailPanel = new JPanel();
		
		mainDetailPanel.setBounds(0, 200, 1280, 300);
		return mainDetailPanel;
	}

}
