package login_form;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class PwFinder extends JFrame {
    private JTextField idtf;
    private JTextField nametf;
    private JButton findButton;
    private JButton idfindbtn;
    private JLabel idlb ,namelb;
    
    //아이디 찾기 누를시 현재창 닫음
    public void close() {
        this.dispose();
    }

   

    public void PwFinderForm() {
    	IdFinder idFinder = new IdFinder();
    	
        // 아이디 라벨
        idlb = new JLabel("아이디");
        idlb.setBounds(100, 20, 80, 30);
        // 아이디 입력창
        idtf = new JTextField();
        idtf.setBounds(100, 50, 200, 30);

        // 이름 라벨
        namelb = new JLabel("이름");
        namelb.setBounds(100, 100, 200, 30);
        // 이름 입력창
        nametf = new JTextField();
        nametf.setBounds(100, 130, 200, 30);

        // 찾기 버튼
        findButton = new JButton("찾기");
        findButton.setBounds(100, 200, 200, 30);

        // 아이디 찾기 버튼
        idfindbtn = new JButton("아이디 찾기");
        idfindbtn.setBounds(140, 240, 120, 30);
        
        
        // 컴포넌트 추가
        add(idlb);
        add(idtf);
        add(namelb);
        add(nametf);
        add(findButton);
        add(idfindbtn);
        
        // 찾기 버튼 액션
        findButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                String id = idtf.getText();
                String name = nametf.getText();
                if (id.isEmpty() || name.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "아이디와 이름을 모두 입력하세요.");
                } else {
                    String userPw = UserDataReader.FindPw(id, name);
                    if (userPw != null) {
                        JOptionPane.showMessageDialog(null, "비밀번호는 : " + userPw + "입니다");
                        //비밀번호는 찾은후 로그인 창으로 바로 들어가게끔 설정
                        setVisible(false); 
                    } else {
                        JOptionPane.showMessageDialog(null, "가입 정보와 일치하지 않습니다.");
                    }
                }
        		nametf.setText("");
        		idtf.setText("");
            }
        });
        
        
        
        
        //아이디 찾기 버튼 누를시 아이디 찾기로 이동
        idfindbtn.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		close();
        		idFinder.IdFinderForm();
        		idFinder.IdFinderFrame();
        	
        		
        	}
        });
    }

   
    // 프레임
    public void PwFinderFrame() {
    	setTitle("비밀번호 찾기");
    	setLocation(600,200);
        setSize(400, 550);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
    
}
