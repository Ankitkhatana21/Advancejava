package studentdetails;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PreparedStatementInput {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner sc = new Scanner(System.in);
		 System.out.println("Enter ID");
			int id = sc.nextInt();
			System.out.println("Enter Name");
			String name = sc.next();
			System.out.println("Email");
			String email = sc.next();
			System.out.println("phn name");
			long phn = sc.nextLong();
			System.out.println("marks");
			double marks=sc.nextDouble();
			System.out.println("school name");
			String schoolname=sc.next();
	    	
		try {
			Class.forName("org.postgresql.Driver");
		
		
	     Connection connection=DriverManager.getConnection
			("jdbc:postgresql://localhost:5432/student","postgres","root");
	     
	     
	     	PreparedStatement preparedStatement = connection.prepareStatement
	     			("insert into student values(?,?,?,?,?,?)");
	     	preparedStatement.setInt(1,id);
	     	preparedStatement.setString(2,name);
	     	preparedStatement.setString(3, email);
	     	preparedStatement.setDouble(4,phn);
	     	preparedStatement.setDouble(5,marks);
	     	preparedStatement.setString(6,schoolname);
	     	
	     	preparedStatement.executeUpdate();
//	     	PreparedStatement preparedStatement2 = connection.prepareStatement
//	     			+("delete from student where id=?)");
	     	
	     	System.out.println("operation done");
	     	connection.close();
	     	
		}

  catch (ClassNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
  }
	catch(SQLException e) {
		e.printStackTrace();
	}
	}
}

	
