package com.boray.model;

public class User {
	private int id;
	private String userName;
	private String password;
	private String roles;
	private String tenantName;
	private String isDelete;
	
	public User() {
		super();
	}

	public User(int id, String userName, String password, String roles, String tenantName, String isDelete) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.roles = roles;
		this.tenantName = tenantName;
		this.isDelete = isDelete;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	
	
	@Override
	public String toString() {
		return "{id:"+id+","+
			   "userName:"+userName+","+
			   "password:"+password+","+
			   "roles:"+roles+","+
			   "tenantName:"+tenantName+","+
			   "isDelete:"+isDelete+"}";
	}
}
