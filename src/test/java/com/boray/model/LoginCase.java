package com.boray.model;

public class LoginCase {
	private String userName;
	private String password;
	private String expectedMsg;
	private String expectedCode;
	
	public LoginCase() {
		super();
	}

	public LoginCase(String userName, String password, String expectedMsg, String expectedCode) {
		super();
		this.userName = userName;
		this.password = password;
		this.expectedMsg = expectedMsg;
		this.expectedCode = expectedCode;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getExpectedMsg() {
		return expectedMsg;
	}

	public void setExpectedMsg(String expectedMsg) {
		this.expectedMsg = expectedMsg;
	}

	public String getExpectedCode() {
		return expectedCode;
	}

	public void setExpectedCode(String expectedCode) {
		this.expectedCode = expectedCode;
	}

	@Override
	public String toString() {
		return "LoginCase [userName=" + userName + ", password=" + password + ", expectedMsg=" + expectedMsg
				+ ", expectedCode=" + expectedCode + "]";
	}
	



	
	
	
}
