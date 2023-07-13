package com.boray.model;

public class UpdateUserInfoCase {
	private int id;
	private int userId;
	private String userName;
	private String roles;
	private String tenantName;
	private String idDelete;
	private String expected;
	
	public UpdateUserInfoCase() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UpdateUserInfoCase(int id, int userId, String userName, String roles, String tenantName, String idDelete,
			String expected) {
		super();
		this.id = id;
		this.userId = userId;
		this.userName = userName;
		this.roles = roles;
		this.tenantName = tenantName;
		this.idDelete = idDelete;
		this.expected = expected;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
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
	public String getIdDelete() {
		return idDelete;
	}
	public void setIdDelete(String idDelete) {
		this.idDelete = idDelete;
	}
	public String getExpected() {
		return expected;
	}
	public void setExpected(String expected) {
		this.expected = expected;
	}
	@Override
	public String toString() {
		return "UpdateUserInfoCase [id=" + id + ", userId=" + userId + ", userName=" + userName + ", roles=" + roles
				+ ", tenantName=" + tenantName + ", idDelete=" + idDelete + ", expected=" + expected + "]";
	}

	
	
	
}
