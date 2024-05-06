package login_form;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import platform.MainFrame;
import userDTO.UserDTO;

public class LoginForm extends JFrame {
    private JTextField idtf;
    private JPasswordField pwpf;
    private JButton loginbtn, registerbtn, idfindbtn, pwfindbtn;
    private JLabel idlb, pwlb;
    private static UserDTO LoginUser = null;
    MainFrame mainF;

    public LoginForm(MainFrame mainF) {
    	RegisterForm registerFrame = new RegisterForm();
    	IdFinder idFinder = new IdFinder();
    	PwFinder pwFinder = new PwFinder();
    	
    	this.mainF = mainF;
    	
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
        
        // 로그인 버튼 액션
        loginbtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                String id = idtf.getText();
                String password = String.valueOf(pwpf.getPassword());
               
                if (id.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "아이디를 입력하세요");
                } else if  (password.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "비밀번호를 입력하세요");
                } else {
                	LoginUser = UserDataReader.loginUser(id, password);
                    if (LoginUser != null) {
                    	//로그인된 유저의 데이터
                    	setVisible(false);
                        JOptionPane.showMessageDialog(null, "로그인 했습니다");
                    } 
                    else {
                        JOptionPane.showMessageDialog(null, "아이디 또는 비밀번호가 일치하지 않습니다");
                    }
                }
                mainF.getMainHeader().refresh();
                mainF.revalidate();
                mainF.repaint();
                    
                
                }
            }
        
        
        );
        
        
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
        setLocation(600,200);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }


	public static UserDTO getLoginUser() {
		return LoginUser;
	}


	public static void setLoginUser(UserDTO loginUser) {
		LoginUser = loginUser;
	}
    
    
}
