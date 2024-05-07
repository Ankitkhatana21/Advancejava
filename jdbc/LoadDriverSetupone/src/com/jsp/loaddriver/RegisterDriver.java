package com.jsp.loaddriver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.postgresql.Driver;

public class RegisterDriver {

	public static void main(String[] args) {

		//one way		
		
//		String url="jdbc:postgresql://localhost:5432/postgres";    
		String url2="jdbc:postgresql://localhost:5432/postgres?user=postgres&password=root";
		String user="postgres";
		String password="root";
//		Step 2: load or register the driver
		Driver driver=new Driver();
		try {
			DriverManager.registerDriver(new Driver());
			
//			2nd way
//			Connection connection =DriverManager.getConnection(url,user,password);  
			Connection connection =DriverManager.getConnection(url2);
			System.out.println("driver registered and loaded");
			System.out.println(connection);
		}
		catch(SQLException e) {
			
			e.printStackTrace();
			
		}
	}

}
