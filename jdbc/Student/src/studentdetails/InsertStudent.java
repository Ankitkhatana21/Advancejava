package studentdetails;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class InsertStudent {

	public static void main(String[] args) {
		
		
			
				try {
					Class.forName("org.postgresql.Driver");
				
			     Connection connection=DriverManager.getConnection
					("jdbc:postgresql://localhost:5432/student","postgres","root");
			
			
					Statement statement=connection.createStatement();
					
					Scanner sc = new Scanner(System.in);
					int id = sc.nextInt();
					String name = sc.next();
					String email = sc.next();
					long phn = sc.nextLong();
					double marks=sc.nextDouble();
					String schoolname=sc.next();
					String query="insert into student values ("+id+", '"+name+"','"+email+"',"+phn+","+marks+",'"+schoolname+"');";
//					 String query="delete from student where sid=2;";
					
					statement.execute(query);
					System.out.println("data inserted done ");
					connection.close();
				
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					catch (SQLException e) {
						e.printStackTrace();
						
					}
				
				}
	}
			
		
		


