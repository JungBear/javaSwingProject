package login_form;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class IdFinder extends JFrame {
    private JTextField nametf ,emailtf;
    private JButton findButton ,pwfindbtn;
    private JLabel namelb ,emaillb;
   
    
    //비밀번호 찾기 창을 누를시 현재 창 닫음
    public void close() {
        this.dispose();
    }

   

    public void IdFinderForm() {
    	PwFinder pwFinder = new PwFinder();
        
    	// 이름 라벨
        namelb = new JLabel("이름");
        namelb.setBounds(100, 20, 80, 30);
        
        // 이름 텍스트필드
        nametf = new JTextField();
        nametf.setBounds(100, 50, 200, 30);

        // 이메일 라벨
        emaillb = new JLabel("이메일");
        emaillb.setBounds(100, 100, 200, 30);
        
        // 이메일 텍스트필드
        emailtf = new JTextField();
        emailtf.setBounds(100, 130, 200, 30);

        // 찾기 버튼
        findButton = new JButton("찾기");
        findButton.setBounds(100, 200, 200, 30);
        findButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                String name = nametf.getText();
                String email = emailtf.getText();
                if (name.isEmpty() || email.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "이름과 이메일을 모두 입력하세요.");
                } else {
                    String userId = UserDataReader.FindId(name, email);
                    if (userId != null) {
                        JOptionPane.showMessageDialog(null, "아이디는 : " + userId + "입니다");
                    } else {
                        JOptionPane.showMessageDialog(null, "일치하는 사용자 정보가 없습니다.");
                    }
                }
            }
        });

        // 비밀번호 찾기 버튼
        pwfindbtn = new JButton("비밀번호 찾기");
        pwfindbtn.setBounds(140, 240, 120, 30);
        
        //컴포넌트 추가
        add(namelb);
        add(nametf);
        add(emaillb);
        add(emailtf);
        add(findButton);
        add(pwfindbtn);
        
        // 비밀번호 찾기 누를시 비밀번호 찾기 창으로 이동
        pwfindbtn.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		//기존에 열린 이 창은 닫기
        		close();
        		pwFinder.PwFinderForm();
        		pwFinder.PwFinderFrame();
        	}
        });
        
    }

    
    //프레임
    public void IdFinderFrame() {
    	setTitle("아이디 찾기");
    	setLocation(600,200);
        setSize(400, 550);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    
}
