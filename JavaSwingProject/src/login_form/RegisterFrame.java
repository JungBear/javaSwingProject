package login_form;

import javax.swing.*;

import userDTO.UserDTO;

import java.awt.event.*;


public class RegisterFrame extends JFrame {
    private JTextField idField, emailField, nameField, addressField, phoneField;
    private JPasswordField passwordField, passwordConfirmField;
    
    public RegisterFrame() {
        setTitle("회원가입");
        setSize(410, 700);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 아이디 라벨과 입력창
        JLabel li = new JLabel("아이디");
        li.setBounds(50, 20, 80, 30);
        idField = new JTextField();
        idField.setBounds(50, 60, 200, 30);
        JButton idCheck = new JButton("중복 확인");
        idCheck.setBounds(260, 60, 100, 30);

        // 비밀번호 라벨과 입력창
        JLabel pw = new JLabel("비밀번호");
        pw.setBounds(50, 100, 80, 30);
        passwordField = new JPasswordField();
        passwordField.setBounds(50, 140, 310, 30);

        // 비밀번호 확인 라벨과 입력창
        JLabel pwch = new JLabel("비밀번호 확인");
        pwch.setBounds(50, 180, 120, 30);
        passwordConfirmField = new JPasswordField();
        passwordConfirmField.setBounds(50, 220, 310, 30);

        // 이메일 라벨과 입력창
        JLabel em = new JLabel("이메일");
        em.setBounds(50, 260, 80, 30);
        emailField = new JTextField();
        emailField.setBounds(50, 300, 200, 30);
        JButton emailCheck = new JButton("중복 확인");
        emailCheck.setBounds(260, 300, 100, 30);

        // 이름 라벨과 입력창
        JLabel nm = new JLabel("이름");
        nm.setBounds(50, 340, 80, 30);
        nameField = new JTextField();
        nameField.setBounds(50, 380, 310, 30);

        // 전화번호 라벨과 입력창
        JLabel pn = new JLabel("연락처");
        pn.setBounds(50, 420, 80, 30);
        phoneField = new JTextField();
        phoneField.setBounds(50, 460, 200, 30);
        JButton phoneCheck = new JButton("중복 확인");
        phoneCheck.setBounds(260, 460, 100, 30);

        // 주소 라벨과 입력창
        JLabel add = new JLabel("주소");
        add.setBounds(50, 500, 80, 30);
        addressField = new JTextField();
        addressField.setBounds(50, 540, 310, 30);

        // 회원가입 버튼
        JButton signbtn = new JButton("회원가입");
        signbtn.setBounds(105, 590, 200, 30);
        signbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                createUserAccount();
            }
        });

        // 컴포넌트 추가
        add(li);
        add(idField);
        add(idCheck);
        add(pw);
        add(passwordField);
        add(pwch);
        add(passwordConfirmField);
        add(em);
        add(emailField);
        add(emailCheck);
        add(nm);
        add(nameField);
        add(pn);
        add(phoneField);
        add(phoneCheck);
        add(add);
        add(addressField);
        add(signbtn);

        setVisible(true);
    }

    private void createUserAccount() {
        String id = idField.getText(); // 아이디
        String pwd = new String(passwordField.getPassword());// 패스워드
        String pwc = new String(passwordConfirmField.getPassword());//패스워드 확인
        String email = emailField.getText();// 이메일
        String name = nameField.getText();// 이름
        String phone = phoneField.getText();// 연락처
        String address = addressField.getText(); // 주소
       
        		
        
        
        // 아이디 입력확인
        if (id.isEmpty()) {
            JOptionPane.showMessageDialog(this, "아이디를 입력하세요.");
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

        
        // 주소 입력 확인
        if (address.isEmpty()) {
            JOptionPane.showMessageDialog(this, "주소를 입력하세요.");
            return;
        }
        UserDTO user = new UserDTO(id, pwd, email, name, Integer.parseInt(phone), address);
        
        // 회원가입 데이터 UserDataWriter로 저장
        try {
            int phoneNum1 = Integer.parseInt(phoneField.getText());
            UserDTO newUser = new UserDTO(idField.getText(), new String(passwordField.getPassword()),
                emailField.getText(), nameField.getText(), phoneNum1, addressField.getText());
            UserDataWriter.writeDataToFile(newUser); // 사용자 데이터를 파일로 저장
            JOptionPane.showMessageDialog(this, "회원가입 하였습니다.");
            this.dispose();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "회원가입이 완료되지 않았습니다. " + e.getMessage()); // 오류 메시지 표시
            }
    }
    
    
    
    

	

        
        
}


