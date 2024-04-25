package login_form;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RegistrationForm extends JFrame {
    private JTextField idField, emailField, nameField, addressField;
    private JPasswordField pwdField;
    private JTextField phoneNumField;
    private JButton registerButton;

    public RegistrationForm() {
        setTitle("회원가입 폼");
        setSize(300, 400);
        setLayout(new GridLayout(7, 2));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 필드 초기화 및 레이블 추가
        add(new JLabel("아이디:"));
        idField = new JTextField(20);
        add(idField);

        add(new JLabel("비밀번호:"));
        pwdField = new JPasswordField(20);
        add(pwdField);

        add(new JLabel("이메일:"));
        emailField = new JTextField(20);
        add(emailField);

        add(new JLabel("이름:"));
        nameField = new JTextField(20);
        add(nameField);

        add(new JLabel("연락처:"));
        phoneNumField = new JTextField(20);
        add(phoneNumField);

        add(new JLabel("주소:"));
        addressField = new JTextField(20);
        add(addressField);

        registerButton = new JButton("회원가입");
        add(registerButton);

        // 회원가입 버튼 클릭 이벤트 처리
        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                registerUser();
            }
        });

        setVisible(true);
    }

    private void registerUser() {
        // 입력 값 가져오기
        String id = idField.getText();
        String pwd = new String(pwdField.getPassword());
        String email = emailField.getText();
        String name = nameField.getText();
        String phone = phoneNumField.getText();
        String address = addressField.getText();

        // 입력 검증
        if (!validateInput(id, pwd, email, name, phone, address)) {
            JOptionPane.showMessageDialog(this, "모든 필드를 올바르게 입력하세요.");
            return;
        }

        // UserDTO 객체 생성
        UserDTO user = new UserDTO(id, pwd, email, name, Integer.parseInt(phone), address);
        // 여기서 데이터 저장 로직을 추가할 수 있습니다.
        JOptionPane.showMessageDialog(this, "회원가입 성공!");
    }

    private boolean validateInput(String id, String pwd, String email, String name, String phone, String address) {
        // 실제 애플리케이션에서는 더 엄격한 검증이 필요합니다.
        return !id.isEmpty() && !pwd.isEmpty() && email.contains("@") && !name.isEmpty() && !phone.isEmpty() && !address.isEmpty();
    }

    public static void main(String[] args) {
        new RegistrationForm();
    }
}
