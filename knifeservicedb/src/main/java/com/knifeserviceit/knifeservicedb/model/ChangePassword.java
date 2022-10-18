package com.knifeserviceit.knifeservicedb.model;

public class ChangePassword {
	private String password;
	private String newpassword;
	public ChangePassword(String password, String newpassword) {
		super();
		this.password = password;
		this.newpassword = newpassword;
	}
	public ChangePassword() {} //constructor para creacion de nueva clase
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNewpassword() {
		return newpassword;
	}
	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}
	@Override
	public String toString() {
		return "ChangePassword [password=" + password + ", newpassword=" + newpassword + "]";
	}
	
	
}//class changepassword
