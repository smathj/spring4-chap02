package net.madvirus.spring4.chap02;

public class User {

	private String id;
	private String password;
	
	// 생성자 :: constructor-arg
	public User(String id, String password) {
		this.id = id;
		this.password = password;
	}
	
	// getter
	public String getId() {
		return id;
	}

	
	
	// method
	public boolean matchPassword(String inputPasswd) {
		return password.equals(inputPasswd);
	}
	
	// method
	public void changePassword(String oldPassword, String newPassword) {
		if (!matchPassword(oldPassword)) {
			throw new IllegalArgumentException("illegal password");
		}
		password = newPassword;
	}

}
