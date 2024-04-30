package login_form;

import javax.swing.*;
import java.awt.event.*;

public class LoginForm extends JFrame {
    private JTextField idtf;
    private JPasswordField pwpf;
    private JButton loginbtn, registerbtn, idfindbtn, pwfindbtn;
    private JLabel idlb, pwlb;
    

    public void initializeUI() {
    	RegisterForm registerFrame = new RegisterForm();
    	IdFinder idFinder = new IdFinder();
    	PwFinder pwFinder = new PwFinder();
    	
    	//아이디 라벨
        idlb = new JLabel("아이디");
        idlb.setBounds(100, 20, 80, 30);
        
        // 아이디 텍스트 필드
        idtf = new JTextField();
        idtf.setBounds(100, 50, 200, 30);
        
        // 비밀번호 라벨
        pwlb = new JLabel("비밀번호");
        pwlb.setBounds(100, 80, 200, 30);
        
        // 비밀번호 텍스트필드
        pwpf = new JPasswordField();
        pwpf.setBounds(100, 110, 200, 30);
        
        // 로그인 버튼
        loginbtn = new JButton("로그인");
        loginbtn.setBounds(100, 150, 200, 30);
        
        //회원 가입 버튼
        registerbtn = new JButton("회원가입");
        registerbtn.setBounds(150, 300, 100, 30);
        
        // 아이디 찾기 버튼
        idfindbtn = new JButton("아이디 찾기");
        idfindbtn.setBounds(50, 200, 120, 30);
        
        // 비밀번호 찾기 버튼
        pwfindbtn = new JButton("비밀번호 찾기");
        pwfindbtn.setBounds(230, 200, 120, 30);
        
        //컴포넌트 추가
        add(idlb);
        add(idtf);
        add(pwlb);
        add(pwpf);
        add(loginbtn);
        add(registerbtn);
        add(idfindbtn);
        add(pwfindbtn);
        
        // 아이디 찾기 버튼 누를시 아이디찾기로 이동
        idfindbtn.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		idFinder.IdFinderForm();
        		idFinder.IdFinderFrame();
        	
        		
        	}
        });
        
        // 회원가입 버튼 누를시 회원가입으로 이동
        registerbtn.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		registerFrame.RegisterForm();
        		registerFrame.RegisterFrame();
        	
        		
        	}
        });
        
        // 비밀번호 찾기 누를시 비밀번호 찾기로 이동
        pwfindbtn.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		pwFinder.PwFinderForm();
        		pwFinder.PwFinderFrame();
        	
        		
        	}
        });
    }


   //프레임
    public void finalizeFrame() {
    	setTitle("로그인");
        setSize(400, 550);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    
}
