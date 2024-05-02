package platform;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BtnMouseAdapter extends MouseAdapter{
	MainFrame mainf;
	MainDownPanel mdp;
	
	public BtnMouseAdapter(MainDownPanel mdp, MainFrame mainF) {
		this.mdp = mdp;
		this.mainf = mainF;

	}
	@Override
	public void mouseEntered(MouseEvent e) {
		super.mouseEntered(e);
//		 clothBtn에 마우스가 올라갔을 때 clothDownPanel을 보이도록 설정
		mdp.setVisible(true);
		mdp.smallCategoryBtn1.setEnabled(true);
		System.out.println("마우스 들어왔다");
	}
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// clothBtn을 클릭했을 때도 clothDownPanel을 보이도록 설정
		super.mouseClicked(e);
		mdp.setVisible(true);
		
	}
}


