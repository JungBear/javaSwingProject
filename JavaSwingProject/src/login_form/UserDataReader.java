package login_form;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import userDTO.UserDTO;


// User_Data.txt 읽기
public class UserDataReader {
	public static boolean checkDuplicate(String id, int fieldIndex) {
	    try (BufferedReader reader = new BufferedReader(new FileReader("user_data.txt"))) {
	        String line;
	        while ((line = reader.readLine()) != null) {
	            String[] userData = line.split(",");
	            if (userData[fieldIndex].equals(id)) {
	                return true; // 중복 발견
	            }
	        }
	    } catch (IOException e) {
	        System.err.println("파일 읽기 중 오류 발생: " + e.getMessage());
	    }
	    return false; // 중복 없음
	}
		
		// User_Data 아이디 찾기
		public static String FindId(String name, String email) {
	        try (BufferedReader reader = new BufferedReader(new FileReader("user_data.txt"))) {
	            String line;
	            while ((line = reader.readLine()) != null) {
	                String[] userData = line.split(",");
	                if (userData[3].equals(name) && userData[2].equals(email)) {
	                    return userData[0];
	                }
	            }
	        } catch (IOException e) {
	            System.err.println("파일 읽기 중 오류 발생: " + e.getMessage());
	        }
	        return null;
	    }
		
		// User_Data 비밀번호 찾기
		public static String FindPw(String id, String name) {
	        try (BufferedReader reader = new BufferedReader(new FileReader("user_data.txt"))) {
	            String line;
	            while ((line = reader.readLine()) != null) {
	                String[] userData = line.split(",");
	                if (userData[0].equals(id) && userData[3].equals(name)) {
	                    return userData[1];
	                }
	            }
	        } catch (IOException e) {
	            System.err.println("파일 읽기 중 오류 발생: " + e.getMessage());
	        }
	        return null;
	    }
		
		// 로그인 성공시 userdata 를 UserDTO로 보내기
		public static UserDTO loginUser(String id, String password) {
	        try (BufferedReader reader = new BufferedReader(new FileReader("user_data.txt"))) {
	            String line;
	            while ((line = reader.readLine()) != null) {
	                String[] userData = line.split(",");
	                if (userData[0].equals(id) && userData[1].equals(password)) {
	                   
	                    return new UserDTO(userData[0], userData[1], userData[2], userData[3], Integer.parseInt(userData[4]), userData[5]);
	                }
	            }
	        } catch (IOException e) {
	            System.err.println("파일 읽기 중 오류 발생: " + e.getMessage());
	        }
	        return null;
	    }
}