package com.latihan.model;

public class Employee {
	private int id;
	private String name;
	private String gender;
	private String role;
	private String age;
	private String dependent;
	private String location;
	
	public Employee() {
	}

	public Employee(int id, String name, String gender, String role, String age, String dependent, String location) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.role = role;
		this.age = age;
		this.dependent = dependent;
		this.location = location;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getDependent() {
		return dependent;
	}

	public void setDependent(String dependent) {
		this.dependent = dependent;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	

}
