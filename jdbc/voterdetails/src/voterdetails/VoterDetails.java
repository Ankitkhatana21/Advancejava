package voterdetails;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class VoterDetails {
	

	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 
			System.out.println("Enter Name");
			String name = sc.next();
			System.out.println("Email");
			String email = sc.next();
			System.out.println("phn");
			long phn = sc.nextLong();
			System.out.println("age");
			double marks=sc.nextDouble();
			System.out.println("school name");
			String schoolname=sc.next();
	    	
		{
			//step 1
			try {
				Class.forName("org.postgresql.Driver");
			
			// step 2
			Connection connection = DriverManager.getConnection
					("jdbc:postgresql://localhost:5432/voter","postgres","root");
			// step 3
			Statement statement = connection.createStatement();
			// step 4
			String query ="insert into book values( 'Ankit','akhatana955@gmail.com', 9873373832,24,'indian','Gurugram');";
		
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




