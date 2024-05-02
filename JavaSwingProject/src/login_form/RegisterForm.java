package login_form;

import javax.swing.*;

import userDTO.UserDTO;

import java.awt.event.*;


public class RegisterForm extends JFrame {
    private JTextField idtf, emailtf, nametf, addresstf, phonenumtf;
    private JPasswordField pwpf, pwcheckpf;
    private JLabel idlb ,pwlb ,pwchecklb ,emaillb ,name ,phonenumlb ,addresslb;
    private boolean idCheck, emailCheck, phoneCheck = false;
	private JButton emailcheckbtn , idcheckbtn ,phonecheckbtn ,registerbtn;
    
    public void RegisterForm() {
        

        // 아이디 라벨
        idlb = new JLabel("아이디");
        idlb.setBounds(50, 20, 80, 30);
        
        // 아이디 텍스트필드
        idtf = new JTextField();
        idtf.setBounds(50, 60, 200, 30);
        
        // 아이디 중복확인버튼
        idcheckbtn = new JButton("중복 확인");
        idcheckbtn.setBounds(260, 60, 100, 30);
        idcheckbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String id = idtf.getText();
                if (id.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "아이디를 입력하세요.");
                } else if (UserDataReader.checkDuplicate(id, 0)) { 
                    JOptionPane.showMessageDialog(null, "이미 사용중인 아이디 입니다.");
                } else {
                    JOptionPane.showMessageDialog(null, "사용 가능한 아이디 입니다.");
                    idCheck = true;
                }
            }
        });


        // 비밀번호 라벨
        pwlb = new JLabel("비밀번호");
        pwlb.setBounds(50, 100, 80, 30);
        
        // 비밀번호 패스워드필드
        pwpf = new JPasswordField();
        pwpf.setBounds(50, 140, 310, 30);

        // 비밀번호 확인 라벨
        pwchecklb = new JLabel("비밀번호 확인");
        pwchecklb.setBounds(50, 180, 120, 30);
        
        // 비밀번호 확인 패스워드 필드
        pwcheckpf = new JPasswordField();
        pwcheckpf.setBounds(50, 220, 310, 30);

        // 이메일 라벨과 입력창
        emaillb = new JLabel("이메일");
        emaillb.setBounds(50, 260, 80, 30);
        
        // 이메일 텍스트필드
        emailtf = new JTextField();
        emailtf.setBounds(50, 300, 200, 30);
        
        // 이메일 중복확인 버튼
        emailcheckbtn = new JButton("중복 확인");
        emailcheckbtn.setBounds(260, 300, 100, 30);
        emailcheckbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String email = emailtf.getText();
                if (email.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "이메일을 입력하세요.");
                } else if (UserDataReader.checkDuplicate(email, 2)) { 
                    JOptionPane.showMessageDialog(null, "이미 사용중인 이메일 입니다.");
                } else {
                    JOptionPane.showMessageDialog(null, "사용 가능한 이메일 입니다.");
                    emailCheck = true;
                }
            }
        });

        // 이름 라벨
        name = new JLabel("이름");
        name.setBounds(50, 340, 80, 30);
        
        // 이름 텍스트필드
        nametf = new JTextField();
        nametf.setBounds(50, 380, 310, 30);

        // 전화번호 라벨
        phonenumlb = new JLabel("연락처");
        phonenumlb.setBounds(50, 420, 80, 30);
        
        // 전화번호 텍스트 필드
        phonenumtf = new JTextField();
        phonenumtf.setBounds(50, 460, 200, 30);
        
        // 전화번호 중복확인 버튼
        phonecheckbtn = new JButton("중복 확인");
        phonecheckbtn.setBounds(260, 460, 100, 30);
        phonecheckbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String phonenum = phonenumtf.getText();
                if (phonenum.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "연락처를 입력하세요.");
                } else if (UserDataReader.checkDuplicate(phonenum, 4)) { 
                    JOptionPane.showMessageDialog(null, "이미 사용중인 연락처 입니다.");
                } else {
                    JOptionPane.showMessageDialog(null, "사용 가능한 연락처 입니다.");
                    phoneCheck = true;
                }
            }
        });

        // 주소 라벨과 입력창
        addresslb = new JLabel("주소");
        addresslb.setBounds(50, 500, 80, 30);
        
        // 주소 텍스트필드
        addresstf = new JTextField();
        addresstf.setBounds(50, 540, 310, 30);

        // 회원가입 버튼
        registerbtn = new JButton("회원가입");
        registerbtn.setBounds(105, 600, 200, 30);
        registerbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                createUserAccount();
            }
        });

        // 컴포넌트 추가
        add(idlb);
        add(idtf);
        add(idcheckbtn);
        add(pwlb);
        add(pwpf);
        add(pwchecklb);
        add(pwcheckpf);
        add(emaillb);
        add(emailtf);
        add(emailcheckbtn);
        add(name);
        add(nametf);
        add(phonenumlb);
        add(phonenumtf);
        add(phonecheckbtn);
        add(addresslb);
        add(addresstf);
        add(registerbtn);
        
    }
    //프레임 설정
    public void RegisterFrame() {
    	 setTitle("회원가입");
         setSize(410, 700);
         setLocation(600,200);
         setLayout(null);
         setVisible(true);
         setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
    }
    // UserData 저장
    private void createUserAccount() {
        String id = idtf.getText(); // 아이디
        String pwd = new String(pwpf.getPassword());// 패스워드
        String pwc = new String(pwcheckpf.getPassword());//패스워드 확인
        String email = emailtf.getText();// 이메일
        String name = nametf.getText();// 이름
        String phone = phonenumtf.getText();// 연락처
        String address = addresstf.getText(); // 주소
        		
        
        
        // 아이디 입력확인
        if (id.isEmpty()) {
            JOptionPane.showMessageDialog(this, "아이디를 입력하세요.");
            return;
        }
        
        // 아이디 중복확인 버튼 클릭 확인
        if (idCheck != true) {
            JOptionPane.showMessageDialog(this, "아이디 중복확인을 하세요.");
            return;
        }
        
        
        //비밀번호 입력 확인
        if (pwd.isEmpty()) {
            JOptionPane.showMessageDialog(this, "비밀번호를 입력하세요.");
            return;
        }
        
        // 비밀번호 숫자 영문 포함 6자 이상 확인
        if (!pwd.matches("^(?=.*[0-9])(?=.*[a-zA-Z]).{6,}$")) {
            JOptionPane.showMessageDialog(this, "비밀번호는 6자 이상의 영문자와 숫자를 포함해야 합니다.");
            return;
        }
        //비밀번호 확인 입력창 입력 확인
        if (pwd.isEmpty()) {
            JOptionPane.showMessageDialog(this, "비밀번호를 입력하세요.");
            return;
        }
        
        // 비밀번호와 비밀번호 확인이 일치하는지 확인
        if (!pwd.equals(pwc)) {
            JOptionPane.showMessageDialog(this, "비밀번호가 일치하지 않습니다.");
            return;
        }

        
        // 이메일 입력확인
        if (email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "이메일을 입력하세요.");
            return;
        }
        
        //이메일 @ .com 입력 확인
        if (!email.matches("[\\w.\\-]+@\\w+\\.com")) {
            JOptionPane.showMessageDialog(this, "이메일은 '@'와 '.com'을 포함해야 합니다.");
            return;
        }
        
        // 이메일 중복확인 버튼 클릭 확인
        if (emailCheck != true) {
            JOptionPane.showMessageDialog(this, "이메일 중복확인을 하세요.");
            return;
        }
        
        // 이름 입력확인
        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "이름을 입력하세요.");
            return; 
        }
        // 연락처 입력확인
        if (phone.isEmpty()) {
            JOptionPane.showMessageDialog(this, "연락처를 입력하세요.");
            return;
        }
        
        // 연락처 숫자만 입력했는지 확인
        if (!phone.matches("\\d+")) {
            JOptionPane.showMessageDialog(this, "연락처는 번호만 입력하세요.");
            return;
        }
        
        // 연락처 중복확인 버튼 클릭 확인
        if (phoneCheck != true) {
            JOptionPane.showMessageDialog(this, "연락처 중복확인을 하세요.");
            return;
        }

        
        // 주소 입력 확인
        if (address.isEmpty()) {
            JOptionPane.showMessageDialog(this, "주소를 입력하세요.");
            return;
        }
        
        
        
        
        
        // 회원가입 정보 UserDTO로 보내기 (Phone int로 변환)
        UserDTO user = new UserDTO(id, pwd, email, name, Integer.parseInt(phone), address);
        
        // 회원가입 데이터 UserDataWriter로 저장
        try {
           
            UserDTO newUser = new UserDTO(idtf.getText(), new String(pwpf.getPassword()),
            		emailtf.getText(), nametf.getText(), 
            		// 연락처 정수 변환후 넣기
            		Integer.parseInt(phonenumtf.getText()), addresstf.getText());
            UserDataWriter.writeDataToFile(newUser); // 회원가입 데이터를 UserDataWriter로 텍스트 저장
            JOptionPane.showMessageDialog(this, "회원가입 하였습니다.");
            this.dispose();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "회원가입이 완료되지 않았습니다. " + e.getMessage()); // 회원가입이 되지 않을경우
            }
    }

	
    
    
    
    

	

        
        
}


