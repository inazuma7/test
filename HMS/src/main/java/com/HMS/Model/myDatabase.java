package com.HMS.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class myDatabase {
	Connection con = null;
	public Connection getCon() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/HMS?useSSL=false", "root", "1234");
		} catch(ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		return con;
	}
	
	public void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
