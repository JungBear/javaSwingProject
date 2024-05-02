package login_form;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import userDTO.UserDTO;

public class UserDataWriter {
		
	
    public static void writeDataToFile(UserDTO user) {
    	
    	// 데이터간 , 로 구분 마지막 데이터 /로 표시 밑 밑줄 바꿈
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("user_data.txt", true))) {
            writer.write(user.getId() + ",");
            writer.write(user.getPwd() + ",");
            writer.write(user.getEmail() + ",");
            writer.write(user.getName() + ",");
            writer.write(user.getPhoneNum() + ",");
            writer.write(user.getAddress() + "/");
            writer.newLine();
            writer.flush();
        } catch (IOException e) {
            System.err.println("파일 쓰기 중 오류 발생: " + e.getMessage());
        }
        
    }

	

}
