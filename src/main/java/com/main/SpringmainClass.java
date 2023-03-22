package com.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class SpringmainClass {

	public static void main(String[] args) {

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("emp-db.xml");

		JdbcTemplate jdbcTemplate = (JdbcTemplate) applicationContext.getBean("jdbcTemplate");

		// insert operation - way1
		/*
		 * jdbcTemplate.
		 * update("insert into employee(employeeId,employeeName,salry,emailId,password) values(?,?,?,?,?)"
		 * ,5,"Abhirose",8000,"abhi@gmail.com","abhi123");
		 * 
		 * 
		 * //insert operation - way2
		 * String
		 * sql="insert into employee(employeeId,employeeName,salry,emailId,password) values(?,?,?,?,?)"
		 * ;
		 * 
		 * Object[] data= {6,"Raj",7500,"raj@hotmail.com","raj34"};
		 * 
		 * jdbcTemplate.update(sql,data);
		 * System.out.println("Records inserted successfully");
		 */

		// insert operation - way3
		String sql = "insert into employee(employeeId,employeeName,salary,emailId,password) values(?,?,?,?,?)";
		jdbcTemplate.update(sql, new Object[] { 7, "Tulash", 8500, "taulasha@hotmail.com", "t834" });
		System.out.println("Records inserted successfully");

	}

}
