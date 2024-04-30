package login_form;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class IdFinder extends JFrame{
	   
    public  IdFinder() {
        JFrame f = new JFrame("아이디찾기");
        // 이름 라벨 = nm
        JLabel nm = new JLabel("이름");
        nm.setBounds(100, 20, 80, 30);
        // 이름 입력창 = name
        JTextField name = new JTextField();
        name.setBounds(100, 50, 200, 30);
        // 이메일 라벨 = em
        JLabel em = new JLabel("이메일");
        em.setBounds(100, 100, 200, 30);
        // 이메일 입력창 = email
        JPasswordField email = new JPasswordField();
        email.setBounds(100, 130, 200, 30);
        // 아이디 찾기 버튼 = find
        JButton find = new JButton("찾기");
        find.setBounds(100, 200, 200, 30);
        // 비밀번호 찾기 버튼
        JButton pwfind = new JButton("비밀번호 찾기");
        pwfind.setBounds(140, 240, 120, 30);

        f.add(nm); // 이름 라벨 
        f.add(name); // 이름 입력창
        f.add(em); // 이메일 라벨
        f.add(email); // 이메일 입력창
        f.add(find); // 찾기 버튼
        f.add(pwfind);//비밀번호 찾기 버튼
        //프레임
        f.setSize(400, 550); 
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // 비밀번호 찾기 버튼에 대한 ActionListener 추가
        pwfind.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
             PwFinder pwFinder = new PwFinder();
             // 회원가입 폼 표시
//             pwFinder.setVisible(true);
             // 로그인 화면 닫기
             f.setVisible(false); // 로그인 화면 닫기
    }
        }
    }
}
        
