package com.latihan.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;

public class EmployeeRepository {
	Database db = new Database();
	Connection conn = db.createDatabaseConnection();

	public ArrayList<Employee> findAll() {
		String sql = "SELECT * FROM employee";
		Statement statement;

		ArrayList<Employee> employeeList = new ArrayList<Employee>();
		try {
			statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				Employee emp = new Employee();
				emp.setId(Integer.parseInt(rs.getString("id")));
				emp.setName(rs.getString("name"));
				emp.setGender(rs.getString("gender"));
				emp.setRole(rs.getString("role"));
				emp.setAge(rs.getString("age"));
				emp.setDependent(rs.getString("dependent"));
				emp.setLocation(rs.getString("location"));
				employeeList.add(emp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return employeeList;
	}

	public Employee findById(int id) {
		String sql = "SELECT * FROM employee WHERE id=?";
		PreparedStatement statement;
		String name = "";
		String gender = "";
		String role = "";
		String age = "";
		String dependent = "";
		String location = "";
		Employee employee = null;
		try {
			statement = conn.prepareStatement(sql);

			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				name = rs.getString("name");
				gender = rs.getString("gender");
				role = rs.getString("role");
				age = rs.getString("age");
				dependent = rs.getString("dependent");
				location = rs.getString("location");
			}
			employee = new Employee(id, name, gender, role, age, dependent, location);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return employee;
	}

	public int save(Employee employee) {
		int result = 0;
		String sql = "INSERT INTO employee(name, gender, role, age, dependent, location) VALUES (?,?,?,?,?,?)";
		try {
			PreparedStatement pStatement = conn.prepareStatement(sql);
			pStatement.setString(1, employee.getName());
			pStatement.setString(2, employee.getGender());
			pStatement.setString(3, employee.getRole());
			pStatement.setInt(4, Integer.parseInt(employee.getAge()));
			pStatement.setInt(5, Integer.parseInt(employee.getDependent()));
			pStatement.setString(6, employee.getLocation());

			result = pStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public int update(Employee employee) {
		int result = 0;
		try {

			String sql = "UPDATE employee SET name=?, gender=?, role=?, age=?, dependent=?, location=? WHERE id=? ";

			PreparedStatement pStatement = conn.prepareStatement(sql);
			pStatement.setString(1, employee.getName());
			pStatement.setString(2, employee.getGender());
			pStatement.setString(3, employee.getRole());
			pStatement.setInt(4, Integer.parseInt(employee.getAge()));
			pStatement.setInt(5, Integer.parseInt(employee.getDependent()));
			pStatement.setString(6, employee.getLocation());
			pStatement.setInt(7, employee.getId());

			result = pStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	public int delete(int id) {
		int result = 0;
		try {

			String sql = "DELETE FROM employee WHERE id =? ";

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id);

			result = statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}
}