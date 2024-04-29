package platform;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainHeader extends JPanel{
	ImageIcon logoIcon;
	TopNavBtn clothBtn = new TopNavBtn("의류", 500, 20);
	TopNavBtn cosmeticsBtn = new TopNavBtn("화장품", 600, 20);
	TopNavBtn shoesBtn = new TopNavBtn("신발", 700, 20);
	TopNavBtn backpackBtn = new TopNavBtn("가방", 800, 20);
	TopNavBtn cartBtn = new TopNavBtn("장바구니", 400, 200);
	

	public MainHeader(MainFrame mainF) {
		super();
		setBounds(0, 0, 1280, 200);
		setBackground(Color.gray);
		setLayout(new FlowLayout()); // FlowLayout로 변경
        setPreferredSize(getPreferredSize()); // 원래 크기로 설정
        // 로고 이미지 생성
        add(setLogo(mainF));
        add(clothBtn);
        add(shoesBtn);
        add(backpackBtn);
        add(cartBtn);
        
        cartBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // ShoppingCartPanel 표시
                mainF.showShoppingCartPanel();
            }
        });
        
        
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
        logoLabel.setBounds(0, 0, scaledLogoIcon.getIconWidth(), scaledLogoIcon.getIconHeight());
        add(logoLabel);
		return logoLabel;
	}
	
	
	
	
}
