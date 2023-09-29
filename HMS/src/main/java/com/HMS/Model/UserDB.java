package com.HMS.Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.HMS.Beans.user;
import com.mysql.jdbc.PreparedStatement;

public class UserDB {
	String s1 = null;

	public String insertUser(user rb) {
		myDatabase db = new myDatabase();
		Connection con = db.getCon();
		try {
			Statement stat = con.createStatement();
			stat.executeUpdate("insert into user(name,email,password) values('" + rb.getName() + "','" + rb.getEmail()
					+ "','" + rb.getPassword() + "')");
			s1 = "Data Insert Successfully";
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return s1;
	}

	public String readData(user user) {
		myDatabase db = new myDatabase();
		Connection con = db.getCon();
		ResultSet rs = null;
		try {
			Statement stat = con.createStatement();
			rs = stat.executeQuery("select email,password from user where email='" + user.getEmail()
					+ "' and password='" + user.getPassword() + "'");
			rs.next();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return "Success";
	}

	public static user userLogin(String email, String password) {
		myDatabase db = new myDatabase();
		Connection con = db.getCon();
		user user = null;
		try {
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement(
					"Select * from user where email='" + email + "' and password = '" + password + "'");
//	      stmt.setString(1,login);
//	      stmt.setString(2,password);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				user = new user();
				// System.out.println(user);
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setName(rs.getString("name"));
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return user;
	}


}
