package com.bibekdhungana;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.model.Employee;

public class Main {

	public static void main(String[] args) {

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("emp-db.xml");

		JdbcTemplate jdbcTemplate = (JdbcTemplate) applicationContext.getBean("jdbcTemplate");

		// insert operation - way3
		// String insertQuery = "insert into
		// employee(employeeId,employeeName,salary,emailId,password) values(?,?,?,?,?)";
		// jdbcTemplate.update(insertQuery, new Object[] { 1, "Bibek", 8500,
		// "bidhunga@ttu.edu", "TestinG123@" });
		// System.out.println("Records inserted successfully");

		// // delete operation
		// String deleteQuery = "delete from employee where employeeId = ?";
		// jdbcTemplate.update(deleteQuery, new Object[] { 7 });
		// System.out.println("Records deleted successfully");

		// retrieve all the records from Employee table
		String selectQuery = "SELECT * from employee";
		List<Employee> employees = (List<Employee>) jdbcTemplate.query(selectQuery,
				new BeanPropertyRowMapper(Employee.class));
		System.out.println(employees);
	}

}
