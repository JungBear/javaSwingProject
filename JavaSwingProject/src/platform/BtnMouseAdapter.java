package platform;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BtnMouseAdapter extends MouseAdapter{
	MainDownPanel mdp;
	
	public BtnMouseAdapter(MainDownPanel mdp) {
		this.mdp = mdp;
	}
	@Override
	public void mouseEntered(MouseEvent e) {
//		super.mouseEntered(e);
		// clothBtn에 마우스가 올라갔을 때 clothDownPanel을 보이도록 설정
		mdp.setVisible(true);
//		System.out.println("마우스 들어왔다");
	}
	
//	@Override
//	public void mouseExited(MouseEvent e) {
////		super.mouseExited(e);
//		// clothBtn에서 마우스가 내려갔을 때 clothDownPanel을 숨기도록 설정
//		mdp.setVisible(false);
////		System.out.println("마우스 나간다");
//	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// clothBtn을 클릭했을 때도 clothDownPanel을 보이도록 설정
//		super.mouseClicked(e);
		mdp.setVisible(true);
//		System.out.println("마우스 클릭했어");
		
	}
}


