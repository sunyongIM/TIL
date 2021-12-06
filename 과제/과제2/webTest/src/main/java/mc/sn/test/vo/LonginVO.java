package mc.sn.test.vo;

import org.springframework.stereotype.Component;

@Component("LonginVO")
public class LonginVO {
	private String id;
	private String password;
	private String userName;

	public LonginVO() {
		
	}
	
	public LonginVO(String id, String password, String userName) {
		this.id = id;
		this.password = password;
		this.userName = userName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	};
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String info = id+","+password+","+userName;
		return info;
	}
	
}