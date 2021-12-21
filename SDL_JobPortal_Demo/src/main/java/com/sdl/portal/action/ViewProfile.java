package com.sdl.portal.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.sdl.portal.dao.UserDao;
import com.sdl.portal.model.User;

public class ViewProfile extends ActionSupport {

	private UserDao userDao;
	User user;
	int userid;
	

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String execute() throws Exception {

			System.out.println("Search User Id is "+ userid);
			

			user = new User();
			userDao = new UserDao();
			user = userDao.getUserById(userid);
			System.out.println("User Profile Object is " + user);

			return "success";

	}

}
