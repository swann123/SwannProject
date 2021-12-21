package com.sdl.portal.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sdl.portal.config.DBConfig;
import com.sdl.portal.model.User;

import java.sql.PreparedStatement;
import java.sql.Connection;

public class UserDao {
	Connection con;
	PreparedStatement pst;
	User user;
	List<User> users;

	public UserDao() {
		this.user = null;
		this.users = null;
		this.con = DBConfig.getConnection();
	}

	///////////// For Login Process //////////////////////////////

	public User getUserByEmail(String email, String pass) throws SQLException {

		System.out.println("login user DAO");
		System.out.println("Login Email is " + email);
		System.out.println("Login Password is " + pass);

		User user = null;
		try {
			String sql = "select * from user where email=? and password=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				user = new User();
				user.setId(rs.getInt("user_id"));
				user.setFirstName(rs.getString("firstName"));
				user.setLastName(rs.getString("lastName"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setRole_id(rs.getInt("role_id"));
			}

			System.out.println("login user row is " + user);
			return user;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (con != null) {
				con.close();
				System.out.println("Connectoin close");
			}
		}
	}

	///////////// End Login Process //////////////////////////////

	////////////////// Register //////////////////////////////////

	public int registerUser(String fname, String lname, String email, String password) {
		// TODO Auto-generated method stub
		int flag = 0;
		try {
			String sql = "insert into user(firstName,lastName,email,password,role_id) values(?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, fname);
			ps.setString(2, lname);
			ps.setString(3, email);
			ps.setString(4, password);
			ps.setInt(5, 2);

			flag = ps.executeUpdate();
			if (flag > 0) {
				System.out.println("User Register Successful");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	////////////////// End Register/////////////////////////////////

	/////////////////////// Profile //////////////////////////////

	public User getUserById(int userid) throws SQLException {

		System.out.println("Get User by Dao Method");
		User user = null;
		try {
			String sql = "select * from user where user_id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, userid);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				user = new User();
				user.setId(rs.getInt("user_id"));
				user.setFirstName(rs.getString("firstName"));
				user.setLastName(rs.getString("lastName"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setRole_id(rs.getInt("role_id"));
				user.setJobexperience(rs.getString("jobexperience"));
				user.setEducation(rs.getString("education"));
			}

			System.out.println("Profile User is " + user);
			return user;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (con != null) {
				con.close();
				System.out.println("Connectoin close");
			}
		}
	}

	public int updateUser(User user) {
		System.out.println(" Update User DAO");
		int flag = 0;
		try {
			String sql = "update user set firstName=? , lastName=? , email=?, password=?, jobexperience=?, education=? where user_id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, user.getFirstName());
			ps.setString(2, user.getLastName());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getPassword());
			ps.setString(5, user.getJobexperience());
			ps.setString(6, user.getEducation());
			ps.setInt(7, user.getId());
			flag = ps.executeUpdate();

			if (flag > 0) {
				System.out.println("User Update is Successful");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;

	}

//////////////////////////////End Profile ////////////////////////////////////////////////

	///////////////////////////////////////// Search
	///////////////////////////////////////// //////////////////////////////////////////

	public ResultSet findbykeyword(String keyword) throws SQLException, Exception {
		ResultSet rs = null;
		try {

			System.out.println("At Search by keyward Fucntion");
			String sql = "SELECT * FROM user where firstName Like'%" + keyword + "%'";
			PreparedStatement ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			System.out.println("RS Is " + rs);

			return rs;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

//////////////////////////////////////////End Search/////////////////////////////////////////

/////////////////////////////////////////Forget Password /////////////////////////////////////

	public User checktUserByEmail(String email) throws SQLException {

		System.out.println("Check user email  DAO");
		System.out.println("check Email is " + email);

		User user = null;
		try {
			String sql = "select * from user where email=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				user = new User();
				user.setId(rs.getInt("user_id"));
				user.setFirstName(rs.getString("firstName"));
				user.setLastName(rs.getString("lastName"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setRole_id(rs.getInt("role_id"));
			}

			System.out.println("Check user is " + user);
			return user;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (con != null) {
				con.close();
				System.out.println("Connectoin close");
			}
		}
	}
	
	
	public int updatePassword(String password, String email)
			throws SQLException, Exception {
		
		int i = 0;
		try {
			System.out.println("Update Password "+password);
			System.out.println("Update Email "+email);
			
			String sql = "UPDATE user SET password=? WHERE email=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, password);
			ps.setString(2, email);
			i = ps.executeUpdate();
			return i;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}

//////////////////////////////////////End Forget Password/////////////////////////////////////
	
	
	
//////////////////////////////////////Manage Users /////////////////////////////////////


	public ResultSet getAllUser() throws SQLException, Exception {
		ResultSet rs = null;
		try {
			String sql = "Select * from user";
			PreparedStatement ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} 
		
	}

	
	public int deleteUserDetails(String email) throws SQLException, Exception {
		int i = 0;
		try {
			String sql = "DELETE from user WHERE email=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, email);
			i = ps.executeUpdate();
			return i;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}
	
//////////////////////////////////////Manage Users /////////////////////////////////////
	
}