package com.boray.model;

public class GetUserInfoCase {
	private int userId;
	private String expected;
	public GetUserInfoCase() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GetUserInfoCase(int userId, String expected) {
		super();
		this.userId = userId;
		this.expected = expected;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getExpected() {
		return expected;
	}
	public void setExpected(String expected) {
		this.expected = expected;
	}
	@Override
	public String toString() {
		return "GetUserInfoCase [userId=" + userId + ", expected=" + expected + "]";
	}
	
	
	
	
}
