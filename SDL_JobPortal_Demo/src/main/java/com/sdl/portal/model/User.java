package com.sdl.portal.model;

public class User {
	
	private int srNo;
	
	public int getSrNo() {
		return srNo;
	}
	public void setSrNo(int srNo) {
		this.srNo = srNo;
	}
	private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private int role_id;
    private String jobexperience;
    private String education;
    
	public String getJobexperience() {
		return jobexperience;
	}
	public void setJobexperience(String jobexperience) {
		this.jobexperience = jobexperience;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
