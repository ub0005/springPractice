package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectToADatabase {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		String url = "jdbc:postgres://localhost:5432/db_example";

		String username = "postgres"; // MySQL credentials
		String password = "root";
		String query = "select * from customer"; // query to be run
		Class.forName("org.postgresql.driver"); // Driver name
		
		Connection con = DriverManager.getConnection(url, username, password);
		System.out.println("Connection Established successfully");
		
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		rs.next();
		String firstName = rs.getString("firstname");
		String lastName = rs.getString("lastname");
		
		System.out.println(firstName);
		System.out.println(lastName);
		
		st.close(); // close statement
        con.close();

	}

}
