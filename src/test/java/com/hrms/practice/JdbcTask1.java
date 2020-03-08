package com.hrms.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class JdbcTask1 {
	
	
	//Create connection to db and retrieve all job titles and store them inside arraylist


	public static String dbUsername = "syntax_hrm";
	
	public static String dbPassword = "syntaxhrm123";
	//jdbc : type of driver : host : port / name of the database 
	public static String dbUrl = "jdbc:mysql://54.167.125.15:3306/syntaxhrm_mysql";
	
	public static Connection con;
	
	@Test
	public void getJobTitlesFromDB() throws SQLException {
		List<String> jTitles = new ArrayList();
		try {
			con = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
			Statement st = con.createStatement();
			ResultSet rset = st.executeQuery("select job_title from ohrm_job_title");
			
			while(rset.next()) {
				jTitles.add(rset.getString("job_title"));
		}

	rset.close();
	st.close();
	con.close();
	
		}catch(SQLException e) {
			e.printStackTrace();
			}
		System.out.println(jTitles);
		}

	}

