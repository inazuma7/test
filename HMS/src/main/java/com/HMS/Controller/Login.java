package com.HMS.Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		RequestDispatcher dispatcher = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/HMS?useSSL=false", "root", "1234");
			Connection con = DatabaseConnection.getConnection();
			PreparedStatement pst = con.prepareStatement("select * from user where email='" + email + "' and password='" + password + "'");
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				session.setAttribute("email", rs.getString("email"));
				session.setAttribute("name", rs.getString("name"));

				dispatcher = request.getRequestDispatcher("jsp/Welcome.jsp");
			}else {
				session.setAttribute("status", "failed");
				System.out.println("Wrong email or password");

				dispatcher = request.getRequestDispatcher("jsp/login.jsp");
			}
			dispatcher.forward(request, response);
		} catch(Exception ex){
			ex.printStackTrace();
		}
	}

}