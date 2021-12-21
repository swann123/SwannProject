package com.sdl.portal.action;


import com.opensymphony.xwork2.ActionSupport;
import com.sdl.portal.dao.UserDao;

public class RegisterProcess extends ActionSupport {
	
	private String fname;
	private String lname;
	private String email;
	private String password;
	 private UserDao userDao;
	 
	
	public String getFname() {
		return fname;
	}


	public void setFname(String fname) {
		this.fname = fname;
	}


	public String getLname() {
		return lname;
	}


	public void setLname(String lname) {
		this.lname = lname;
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

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		
		userDao= new UserDao();
		int i=0;
		i=userDao.registerUser(fname,lname,email,password);
		if (i>0) {
            return "reg_success";
        }

		return "reg_fail";
	}
}
