package com.sdl.portal.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.sdl.portal.dao.UserDao;
import com.sdl.portal.model.User;

public class LoginProcess implements SessionAware{  
	
		private String email,pass;  


		SessionMap<String,String> sessionmap;  
		UserDao userdao=null;
		User user;
		
		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		public void setSession(Map map) {  
		    sessionmap=(SessionMap)map;  
		    sessionmap.put("login","true");  
		}  
		   
		public String execute() throws Exception{  
	
			userdao = new UserDao();
			user=userdao.getUserByEmail(email,pass);
			if(user!=null) {
			System.out.println("User is "+user.getEmail()+","+user.getFirstName()+","+user.getRole_id());
			
			sessionmap.put("user_id",String.valueOf(user.getId()));
			sessionmap.put("email", user.getEmail());
			sessionmap.put("role_id",String.valueOf(user.getRole_id()));
			
			
			return "login_success";
			}
			return "login_fail";
		     
		}  
		  
		/* For Logout */ 
		public String logout(){  
		    sessionmap.invalidate();  
		    System.out.println("At Logout Action Method");
		    return "success";  
		}
		
		
		/* For Forget Password */ 
		
		public String findemail() throws SQLException {
			
		
			userdao = new UserDao();
			user=userdao.checktUserByEmail(email);
			if(user!=null) 
			 return "success";
			else
				return "fail";
		}
		
		
		private String hiddenemail;
		
		public String getHiddenemail() {
			return hiddenemail;
		}

		public void setHiddenemail(String hiddenemail) {
			this.hiddenemail = hiddenemail;
		}
		
		
		
		public String updatePassword() throws SQLException, Exception {

			userdao = new UserDao();
			System.out.println("Action Update Password "+pass);
			System.out.println("Action Update Email "+hiddenemail);
			
			int i=userdao.updatePassword(pass,hiddenemail);

			return "success";
		
		}
		
		
		/* End Forget Password  */ 
		
		
	  
		
		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPass() {
			return pass;
		}

		public void setPass(String pass) {
			this.pass = pass;
		}
		
}
