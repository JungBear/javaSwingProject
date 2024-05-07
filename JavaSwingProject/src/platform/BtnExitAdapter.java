package platform;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BtnExitAdapter extends MouseAdapter{

	MainDownPanel mdp;
	
	public BtnExitAdapter( MainDownPanel mdp) {
		this.mdp = mdp;

	}
	
	@Override
	public void mouseExited(MouseEvent e) {
		super.mouseExited(e);
		mdp.setVisible(false);
	}
}
