package platform;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainHeader {
	private JPanel mainHeader;
	ImageIcon logoIcon;
	
	
	public Component setMainHeader(MainFrame mainF) {
		mainHeader = new JPanel();
		mainHeader.setBounds(0, 0, 1280, 200);
		mainHeader.setBackground(Color.gray);
		mainHeader.setLayout(new FlowLayout(FlowLayout.LEFT)); // FlowLayout로 변경
        mainHeader.setPreferredSize(mainHeader.getPreferredSize()); // 원래 크기로 설정
        // 로고 이미지 생성
        mainHeader.add(setLogo(mainF));
        
        
		return mainHeader;
	}
	
	public JLabel setLogo(MainFrame mainF) {
		logoIcon = new ImageIcon("src/img/logo.png"); // 로고 이미지 파일 경로에 따라 변경하세요
		ImageIcon scaledLogoIcon = new ImageIcon(logoIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
		JLabel logoLabel = new JLabel(scaledLogoIcon);
        // 로고 이미지 클릭 이벤트 처리
        logoLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // 로고 이미지가 클릭되었을 때 처리할 작업
            	mainF.setMainFrame();
            }
        });
        mainHeader.add(logoLabel);
		return logoLabel;
	}
	
	
}
