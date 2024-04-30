package platform;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import login_form.LoginForm;

public class MainHeader extends JPanel{
	ImageIcon logoIcon;
	
	// 버튼들의 위치를 오른쪽에 배치시킨다
	TopNavBtn clothBtn = new TopNavBtn("의류", 900, 20);
	TopNavBtn cosmeticsBtn = new TopNavBtn("화장품",960, 20);
	TopNavBtn shoesBtn = new TopNavBtn("신발", 1020, 20);
	TopNavBtn bagBtn = new TopNavBtn("가방", 1080, 20);
	TopNavBtn loginBtn = new TopNavBtn("로그인",0, 150);
	TopNavBtn cartBtn = new TopNavBtn("장바구니",100, 150);
	
	LoginForm loginFrame = new LoginForm();
	

	public MainHeader(MainFrame mainF) {
		super();
		setName("header");
		setBounds(0, 0, 1280, 200);
		setBackground(Color.gray);
		setLayout(null); // FlowLayout로 변경
        setPreferredSize(getPreferredSize()); // 원래 크기로 설정
        // 로고 이미지 생성
        add(setLogo(mainF));
        add(clothBtn);
        add(cosmeticsBtn);
        add(shoesBtn);
        add(bagBtn);
        add(cartBtn);
        add(loginBtn);
        
        cartBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	mainF.showShoppingCartPanel();
            }
        });
        
        loginBtn.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        	loginFrame.initializeUI();
        	loginFrame.finalizeFrame();
        	
        		
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
            	
            	// 현재 보이는 화면이 무엇인지 보여주는 함수
            	mainF.hideVisiblePanelExceptHeader();
            	mainF.MainPreView.setVisible(true);

            }
        });
        // 이미지의 위치를 맨왼쪽 위에 위치시킨다
        logoLabel.setBounds(0, 0, scaledLogoIcon.getIconWidth(), scaledLogoIcon.getIconHeight());
        add(logoLabel);
		return logoLabel;
	}
	
	
	
	
}
