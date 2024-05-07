package executebatch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class BatchExecution {

	public static void main(String[] args) {
		
			// TODO Auto-generated method stub
			 
		    	
			try {
				Class.forName("org.postgresql.Driver");
			
			
		     Connection connection=DriverManager.getConnection
				("jdbc:postgresql://localhost:5432/student","postgres","root");
		     
		     
		     	PreparedStatement preparedStatement = connection.prepareStatement
		     			("insert into student values(?,?,?,?,?,?)");
		     	preparedStatement.setInt(1,121);
		     	preparedStatement.setString(2,"sana");
		     	preparedStatement.setString(3, "sana@32gmail.com");
		     	preparedStatement.setDouble(4,987412563);
		     	preparedStatement.setDouble(5,82.5);
		     	preparedStatement.setString(6,"noida public school");
		     	
		     	preparedStatement.addBatch();
		     	
		     	int [] a= preparedStatement.executeBatch();
		     	for(int i:a)
		     	{
		     		System.out.println(i);
			}
			PreparedStatement preparedStatement2=connection.prepareStatement("select * from student where sid>120");
		 
			ResultSet resultSet= preparedStatement2.executeQuery();
			
			while(resultSet.next()) {
				System.out.println(resultSet.getInt(1));
				System.out.println("...............");
			}
			
//		     	PreparedStatement preparedStatement3 = connection.prepareStatement
//		     			("delete from student where id=121)");
//		     	
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

