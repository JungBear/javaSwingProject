package userDTO;

public class UserDTO {
	//���̵�(�ߺ�üũ) , ��й�ȣ(����, ���� ȥ��), �̸���(�ߺ�Ȯ��), �̸�,  ����ó(�ߺ�Ȯ��), �ּ�,
	private String id;
	private String pwd;
	private String email;
	private String name;
	private int phoneNum;
	private String address;
	
	public UserDTO(String id, String pwd, String email, String name, int phoneNum, String address) {
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
	public int getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(int phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

}
