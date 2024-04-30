package login_form;



import javax.swing.*;
import java.awt.event.*;

public class LoginForm extends JFrame {
	public LoginForm() {
		// 프레임 생성
		JFrame f = new JFrame("로그인");
		// 아이디 라벨 = li
		JLabel li = new JLabel("아이디");
		li.setBounds(100, 20, 80, 30);
		// 아이디 입력창 = id
		JTextField id = new JTextField();
		id.setBounds(100, 50, 200, 30);
		// 비밀번호 라벨 = pw
		JLabel pw = new JLabel("비밀번호");
		pw.setBounds(100, 80, 200, 30);
		//비밀번호 입력창 = value
		JPasswordField value = new JPasswordField();
		value.setBounds(100, 110, 200, 30);
		//로그인 버튼 = lb
		JButton lb = new JButton("로그인");
		lb.setBounds(100, 150, 200, 30);
		//회원가입 버튼 = sb
		JButton sb = new JButton("회원가입");
		sb.setBounds(150, 300, 100, 30);
		//아이디 찾기 버튼
		JButton idsearch = new JButton("아이디 찾기");
		idsearch.setBounds(50, 200, 120, 30);
		//비밀 번호 찾기 버튼
		JButton pwsearch = new JButton("비밀번호 찾기");
		pwsearch.setBounds(230, 200, 120, 30);
		
		f.add(li); // 아이디 라벨              
		f.add(id); // 아이디 입력창
		f.add(pw); // 비밀번호 라벨
		f.add(value); // 비밀번호 입력창
		f.add(sb); //회원가입 버튼
		f.add(lb); //로그인 버튼
		f.add(idsearch);//아이디 찾기 버튼
		f.add(pwsearch);//비밀번호 찾기 버튼
		
		// 프레임
		f.setSize(400, 550); 
		f.setLayout(null);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
                
		//회원가입 버튼 누를시 RegisterFrame클래스(회원가입 폼)으로 이동
		sb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
             JFrame registerFrame = new RegisterFrame();
             // 회원가입 폼 표시
             // 로그인 화면 닫기
             f.setVisible(false); // 로그인 화면 닫기
      
            }
        });
		idsearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
             JFrame idFinder = new IdFinder();
             // 회원가입 폼 표시
             idFinder.setVisible(true);
             // 로그인 화면 닫기
             f.setVisible(false); // 로그인 화면 닫기
      
            }
        });
		pwsearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
             PwFinder pwFinder = new PwFinder();
             // 회원가입 폼 표시
             pwFinder.setVisible(true);
             // 로그인 화면 닫기
             f.setVisible(false); // 로그인 화면 닫기
      
            }
        });
		
				
	
	
	
	}

}
