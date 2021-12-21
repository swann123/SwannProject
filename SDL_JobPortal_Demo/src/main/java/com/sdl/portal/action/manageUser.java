package com.sdl.portal.action;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import com.opensymphony.xwork2.ActionSupport;
import com.sdl.portal.dao.UserDao;
import com.sdl.portal.model.User;

public class manageUser extends ActionSupport {

	private static final long serialVersionUID = 6329394260276112660L;
	ResultSet rs = null;
	User userbean = null;
	List<User> beanList = null;
	UserDao userdao = new UserDao();
	private boolean noData = false;
	

	@Override
	public String execute() throws Exception {
		try {
			beanList = new ArrayList<User>();
			rs = userdao.getAllUser();
			int i = 0;
			if (rs != null) {
				while (rs.next()) {
					i++;
					userbean = new User();
					userbean.setSrNo(i);
					userbean.setFirstName(rs.getString("firstName"));
					userbean.setLastName(rs.getString("lastName"));
					userbean.setPassword(rs.getString("password").replaceAll("(?s).", "*"));
					userbean.setEmail(rs.getString("email"));
					userbean.setEducation(rs.getString("education"));
					beanList.add(userbean);
				}
			}
			if (i == 0) {
				noData = false;
			} else {
				noData = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}
	
	
	private String email,msg;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String deleteUser() {
		try {
			int isDeleted = userdao.deleteUserDetails(email);
			if (isDeleted > 0) {
				msg = "Record deleted successfully";
			} else {
				msg = "Some error";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "del_success";
	}
	
	


	public User getUserbean() {
		return userbean;
	}


	public void setUserbean(User userbean) {
		this.userbean = userbean;
	}


	public List<User> getBeanList() {
		return beanList;
	}

	public void setBeanList(List<User> beanList) {
		this.beanList = beanList;
	}

	public boolean isNoData() {
		return noData;
	}

	public void setNoData(boolean noData) {
		this.noData = noData;
	}



}
