package com.boray.model;

public class GetUserListCase {
	private String userId;
	private String userName;
	private String roles;
	private String tenantName;
	private String expected;
	
	public GetUserListCase() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public GetUserListCase(String userId, String userName, String roles, String tenantName, String expected) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.roles = roles;
		this.tenantName = tenantName;
		this.expected = expected;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public String getTenantName() {
		return tenantName;
	}

	public void setTenantName(String tenantName) {
		this.tenantName = tenantName;
	}

	public String getExpected() {
		return expected;
	}

	public void setExpected(String expected) {
		this.expected = expected;
	}

	@Override
	public String toString() {
		return "GetUserListCase [userId=" + userId + ", userName=" + userName + ", roles=" + roles + ", tenantName="
				+ tenantName + ", expected=" + expected + "]";
	}



	
	
}
