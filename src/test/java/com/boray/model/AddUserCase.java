package com.boray.model;

public class AddUserCase {
	private String userName;
	private String password;
	private String roles;
	private String tenantName;
	private String isDelete;
	private String expected;
	
	public AddUserCase() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AddUserCase(String userName, String password, String roles, String tenantName, String isDelete,
			String expected) {
		super();
		this.userName = userName;
		this.password = password;
		this.roles = roles;
		this.tenantName = tenantName;
		this.isDelete = isDelete;
		this.expected = expected;
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

	public String getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}

	public String getExpected() {
		return expected;
	}

	public void setExpected(String expected) {
		this.expected = expected;
	}

	@Override
	public String toString() {
		return "AddUserCase [userName=" + userName + ", password=" + password + ", roles=" + roles + ", tenantName="
				+ tenantName + ", isDelete=" + isDelete + ", expected=" + expected + "]";
	}
	
    
	
}
