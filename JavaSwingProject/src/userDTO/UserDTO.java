package userDTO;

public class UserDTO {
	 //아이디(중복체크) , 비밀번호(영문, 숫자 혼합), 이메일(중복확인), 이름,  연락처(중복확인), 주소
	private String id;
	private String pwd;
	private String email;
	private String name = "";
	private String phoneNum;
	private String address;
	
	public UserDTO(String id, String pwd, String email, String name, String phoneNum, String address) {
		this.id = id;
		this.pwd = pwd;
		this.email = email;
		this.name = name;
		this.phoneNum = phoneNum;
		this.address = address;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public static String loginUser(String id, String password) {
		
		return null;
	}

	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", pwd=" + pwd + ", email=" + email + ", name=" + name + ", phoneNum=" + phoneNum
				+ ", address=" + address + "]";
	}

	
	
}
