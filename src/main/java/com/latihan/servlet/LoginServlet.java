package com.latihan.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import com.latihan.model.Database;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;

@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		rd.include(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String user = request.getParameter("username");
		String pass = request.getParameter("password");
		String usernameFound = null;
		String passwordFound = null;

		PrintWriter out = response.getWriter();
		try {
			Database db = new Database();
			Connection conn = db.createDatabaseConnection();
			// 4. siapkan sql-nya
			String sql = "SELECT * FROM user_tbl WHERE username =? ";

			// 5. siapkan statement-nya
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, user);

			// 6. eksekusi statement-nya
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				usernameFound = rs.getString("username");
				passwordFound = rs.getString("password");
			}
			if (usernameFound != null) {
				if (passwordFound.equals(pass)) {
					request.getSession().setAttribute("user_login", usernameFound);
					response.sendRedirect("menu.jsp");
				} else {
					request.getSession().setAttribute("user_false", "password anda salah");
					response.sendRedirect("login.jsp");
				}
			} else {
				request.getSession().setAttribute("user_false", "username anda salah");
				response.sendRedirect("login.jsp");
			}
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
