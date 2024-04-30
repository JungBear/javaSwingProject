package login_form;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PwFinder {
    public void setupUI() {
        JFrame f = new JFrame("비밀번호 찾기");
        // 이름 라벨 = li
        JLabel li = new JLabel("이름");
        li.setBounds(100, 20, 80, 30);
        // 이름 입력창 = id
        JTextField id = new JTextField();
        id.setBounds(100, 50, 200, 30);
        // 이메일 라벨 = nm
        JLabel nm = new JLabel("이메일");
        nm.setBounds(100, 100, 200, 30);
        // 이메일 입력창 = email
        JPasswordField name = new JPasswordField();
        name.setBounds(100, 130, 200, 30);
        // 아이디 찾기 버튼 = find
        JButton find = new JButton("찾기");
        find.setBounds(100, 200, 200, 30);
        // 비밀번호 찾기 버튼
        JButton idfind = new JButton("아이디 찾기");
        idfind.setBounds(140, 240, 120, 30);

        f.add(li); // 이름 라벨 
        f.add(id); // 이름 입력창
        f.add(nm); // 이메일 라벨
        f.add(name); // 이메일 입력창
        f.add(find); // 찾기 버튼
        f.add(idfind);//비밀번호 찾기 버튼
        //프레임
        f.setSize(400, 550); 
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // 비밀번호 찾기 버튼에 대한 ActionListener 추가
        idfind.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
             JFrame idFinder = new IdFinder();
             
            idFinder.setVisible(true);
             
             f.setVisible(false);
      
            }
        });
    }

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}

	

	
}