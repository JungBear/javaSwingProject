package login_form;

import javax.swing.*;

public class IdFinder extends JFrame {
    private JTextField name;
    private JTextField email; 
    private JButton findButton;
    private JButton pwFindButton;

    public IdFinder() {
        super("아이디 찾기");
//        initializeUI(); 
//        setupListeners();
//        finalizeFrame(); 
    }

    public void initializeUI() {
        // 이름 라벨
        JLabel nm = new JLabel("이름");
        nm.setBounds(100, 20, 80, 30);
        name = new JTextField();
        name.setBounds(100, 50, 200, 30);

        // 이메일 라벨
        JLabel em = new JLabel("이메일");
        em.setBounds(100, 100, 200, 30);
        email = new JTextField();
        email.setBounds(100, 130, 200, 30);

        // 찾기 버튼
        findButton = new JButton("찾기");
        findButton.setBounds(100, 200, 200, 30);

        // 비밀번호 찾기 버튼
        pwFindButton = new JButton("비밀번호 찾기");
        pwFindButton.setBounds(140, 240, 120, 30);

        add(nm);
        add(name);
        add(em);
        add(email);
        add(findButton);
        add(pwFindButton);
        pwFindButton.addActionListener(e -> {
            PwFinder pwFinder = new PwFinder();
            pwFinder.setVisible(true);
            setVisible(false);
        });
        
    }

    private void setupListeners() {
        pwFindButton.addActionListener(e -> {
            PwFinder pwFinder = new PwFinder();
            pwFinder.setVisible(true);
            setVisible(false);
        });
    }

    private void finalizeFrame() {
        setSize(400, 550);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    
}
