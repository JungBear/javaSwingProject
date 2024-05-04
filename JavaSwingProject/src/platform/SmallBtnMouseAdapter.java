package platform;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SmallBtnMouseAdapter extends MouseAdapter{
	
	SmallCategoryPreviewPanel scpp;
	MainDownPanel mdp;
	MainFrame mainF;

	public SmallBtnMouseAdapter( SmallCategoryPreviewPanel scpp, MainDownPanel mdp, MainFrame mainF) {
		this.scpp = scpp;
		this.mdp = mdp;
		this.mainF = mainF;

	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
		mdp.setVisible(true);
		super.mouseEntered(e);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
//		System.out.println("마우스 클릭!");
		super.mouseClicked(e);
		scpp.setSmallCatogrtyPreviewPanel();
		
	}
	
	
	
}
