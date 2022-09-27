package com.latihan.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.latihan.model.Database;
import com.latihan.model.Employee;
import com.latihan.model.EmployeeRepository;

/**
 * Servlet implementation class EmployeeServlet
 */
@WebServlet("/welcome.do")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EmployeeServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		EmployeeRepository empRepo = new EmployeeRepository();
		String action = request.getParameter("action");
		String id = request.getParameter("id");
		if ("delete".equals(action) && id != null && !id.equals("")) {
			int result = empRepo.delete(Integer.parseInt(id));

			if (result > 0) {
				response.sendRedirect("welcome.do");
			} else {
				//
			}

		} else if (id != null && !id.equals("")) {
			Employee employee = empRepo.findById(Integer.parseInt(id));

			request.setAttribute("employee_data", employee);
			RequestDispatcher rd = request.getRequestDispatcher("view_employee_form.jsp");
			rd.include(request, response);
		} else {
			ArrayList<Employee> empList = empRepo.findAll();
			request.setAttribute("employee_list", empList);
			RequestDispatcher rd = request.getRequestDispatcher("employee_List.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		EmployeeRepository empRepo = new EmployeeRepository();

		String id = request.getParameter("id");
		String action = request.getParameter("action");
		if (id != null && !id.equals("")) {
			String name = request.getParameter("name");
			String gender = request.getParameter("gender");
			String role = request.getParameter("role");
			String age = request.getParameter("age");
			String dependent = request.getParameter("dependent");
			String location = request.getParameter("location");
			Employee employee = new Employee(Integer.parseInt(id), name, gender, role, age, dependent, location);
			int rs = empRepo.update(employee);
			if (rs > 0) {
				response.sendRedirect("welcome.do");
			} else {
				//
			}
		} else {

			String name = request.getParameter("name");
			String gender = request.getParameter("gender");
			String role = request.getParameter("role");
			String age = request.getParameter("age");
			String dependent = request.getParameter("dependent");
			String location = request.getParameter("location");

			Employee employee = new Employee(0, name, gender, role, age, dependent, location);
			int rs = empRepo.save(employee);
			if (rs > 0) {
				response.sendRedirect("welcome.do");
			} else {
				// gagal
			}
		}
	}
}