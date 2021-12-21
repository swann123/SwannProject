package com.sdl.portal.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.sdl.portal.dao.UserDao;
import com.sdl.portal.model.User;

public class ProfileProcess extends ActionSupport {

	private UserDao userDao;
	User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String execute() throws Exception {

		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		System.out.println("Sesssionnnnnnn " + session.getAttribute("login"));

		if (session.getAttribute("login") != null) {
			String login = (String) session.getAttribute("login");
			int userid = Integer.parseInt((String) session.getAttribute("user_id"));
			String email = (String) session.getAttribute("email");
			int roleId = Integer.parseInt((String) session.getAttribute("role_id"));

			System.out.println("Login is " + login);
			System.out.println("Userid is " + userid);
			System.out.println("Email is " + email);
			System.out.println("Role id is " + roleId);

			user = new User();
			userDao = new UserDao();
			user = userDao.getUserById(userid);
			System.out.println("User Profile Object is " + user);

			return "success";
		}
		return "error";
	}

	public String updateUser() throws Exception {
		System.out.println("Update Profile Action");
		userDao = new UserDao();
		int i = 0;
		i = userDao.updateUser(user);
		System.out.println(" Update Profile "+i);
		if (i > 0) {
			return "upd_success";
		}
		return "upd_fail";

	}

}
