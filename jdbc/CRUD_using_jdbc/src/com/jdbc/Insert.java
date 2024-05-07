package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Insert {

	public static void main(String[] args) {
		
		{
			//step 1
			try {
				Class.forName("org.postgresql.Driver");
			
			// step 2
			Connection connection = DriverManager.getConnection
					("jdbc:postgresql://localhost:5432/postgres","postgres","root");
			// step 3
			Statement statement = connection.createStatement();
			// step 4
//			String query ="insert into book values( 4,'Physics', 1400.20);";
			String query ="delete from book where bid=3;";
			statement.execute(query);
			
			connection.close();
			System.out.println("data insert successfully");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		}
	}
	
}

