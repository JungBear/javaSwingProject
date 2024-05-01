package platform;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import product.ProductService;

public class TopNavBtnEventListener implements ActionListener{
	SmallCategoryPreviewPanel scpp;
	MainFrame mainF;
	
	public TopNavBtnEventListener(SmallCategoryPreviewPanel scpp, MainFrame mainF) {
		this.scpp = scpp;
		this.mainF = mainF;
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		mainF.hideVisiblePanelExceptHeader();
		scpp.setVisible(true);
		
		
	}

}
