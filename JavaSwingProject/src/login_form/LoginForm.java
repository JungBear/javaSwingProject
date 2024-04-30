package login_form;

import javax.swing.*;
import java.awt.event.*;

public class LoginForm extends JFrame {
    private JTextField id;
    private JPasswordField value;
    private JButton lb, sb, idsearch, pwsearch;
    private JLabel li, pw;

    public LoginForm() {
//        super("로그인");
//        initializeUI();
//        setupListeners();
//        finalizeFrame();
    }

    public void initializeUI() {
        li = new JLabel("아이디");
        li.setBounds(100, 20, 80, 30);
        
        id = new JTextField();
        id.setBounds(100, 50, 200, 30);
        
        pw = new JLabel("비밀번호");
        pw.setBounds(100, 80, 200, 30);
        
        value = new JPasswordField();
        value.setBounds(100, 110, 200, 30);
        
        lb = new JButton("로그인");
        lb.setBounds(100, 150, 200, 30);
        
        sb = new JButton("회원가입");
        sb.setBounds(150, 300, 100, 30);
        
        idsearch = new JButton("아이디 찾기");
        idsearch.setBounds(50, 200, 120, 30);
        
        pwsearch = new JButton("비밀번호 찾기");
        pwsearch.setBounds(230, 200, 120, 30);

        add(li);
        add(id);
        add(pw);
        add(value);
        add(lb);
        add(sb);
        add(idsearch);
        add(pwsearch);
    }

    private void setupListeners() {
    	//회원가입 버튼 누를시 이동
        sb.addActionListener(e -> {
            JFrame registerFrame = new RegisterFrame();
            registerFrame.setVisible(true);
            setVisible(false);
        });
        // 아이디 찾기 버튼 누를시 이동
        idsearch.addActionListener(e -> {
            JFrame idFinder = new IdFinder();
            idFinder.setVisible(true);
            setVisible(false);
        });
        
        // 비밀번호 찾기 버튼 누를시 이동
        pwsearch.addActionListener(e -> {
            PwFinder pwFinder = new PwFinder();
            pwFinder.setVisible(true);
            setVisible(false);
        });
    }
   //프레임 설정
    public void finalizeFrame() {
        setSize(400, 550);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    
}
