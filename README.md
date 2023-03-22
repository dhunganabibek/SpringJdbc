# SpringJdbc

## Implemented CRUD operation using jdbc Template

```
1. maven project
2. build uber jar with apache shade plugin
3. add dependency for spring core, context and jdbc template
4. use of BeanPropertyRowMapper to map to the row class
```

## Model class

```java
package com.model;

public class Employee {

	private int employeeId;
	private String employeeName;
	private int salry;
	private String emailId;
	private String password;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(int employeeId, String employeeName, int salry, String emailId, String password) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.salry = salry;
		this.emailId = emailId;
		this.password = password;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public int getSalry() {
		return salry;
	}
	public void setSalry(int salry) {
		this.salry = salry;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", salry=" + salry
				+ ", emailId=" + emailId + ", password=" + password + "]";
	}
}
```

## CREATE

```java
String insertQuery = "insert into employee(employeeId,employeeName,salary,emailId,password) values(?,?,?,?,?)";
jdbcTemplate.update(insertQuery, new Object[] { 1, "Bibek", 8500,"bidhunga@ttu.edu", "TestinG123@" });
```

## DELETE

```java
String deleteQuery = "delete from employee where employeeId = ?";
jdbcTemplate.update(deleteQuery, new Object[] { 7 });
```

## READ

```java
String selectQuery = "SELECT * from employee";
List<Employee> employees = (List<Employee>) jdbcTemplate.query(selectQuery,new BeanPropertyRowMapper(Employee.class));
System.out.println(employees);
```
