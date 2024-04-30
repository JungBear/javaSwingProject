package login_form;

import javax.swing.*;

public class PwFinder extends JFrame {
    private JTextField id;
    private JTextField name;
    private JButton findButton;
    private JButton idFindButton;

    public PwFinder() {
//        initializeUI(); 
//        setupListeners();
//        finalizeFrame();
    }

    public void initializeUI() {
        // 아이디 라벨
        JLabel li = new JLabel("아이디");
        li.setBounds(100, 20, 80, 30);
        // 아이디 입력창
        id = new JTextField();
        id.setBounds(100, 50, 200, 30);

        // 이름 라벨
        JLabel nm = new JLabel("이름");
        nm.setBounds(100, 100, 200, 30);
        // 이름 입력창
        name = new JTextField();
        name.setBounds(100, 130, 200, 30);

        // 찾기 버튼
        findButton = new JButton("찾기");
        findButton.setBounds(100, 200, 200, 30);

        // 아이디 찾기 버튼
        idFindButton = new JButton("아이디 찾기");
        idFindButton.setBounds(140, 240, 120, 30);

        add(li);
        add(id);
        add(nm);
        add(name);
        add(findButton);
        add(idFindButton);
    }

    private void setupListeners() {
        idFindButton.addActionListener(e -> {
            IdFinder idFinder = new IdFinder();
            idFinder.setVisible(true);
            setVisible(false); // 현재 창 숨기기
        });
    }

    private void finalizeFrame() {
        setSize(400, 550);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
    
}
