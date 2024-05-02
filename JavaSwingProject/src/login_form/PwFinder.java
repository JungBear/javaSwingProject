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
    	
        setSize(400, 550);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
    
}
