package com.ada.api.domain.person;

public enum UserRole {
	
	ADMIN("admin"),
	FUNCIONARIO("funcionario");
	
	private String role;

	UserRole(String role) {
		this.role = role;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
}
