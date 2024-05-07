package com.infosys.hiring;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class CompanyHiring {

	public static void main(String[] args) {
		
		System.out.println("Enter details");
		
		 Scanner sc = new Scanner(System.in);
		 System.out.println("Enter name");
		 
			String ename = sc.nextLine();
			System.out.println("Enter mail");
			String email = sc.next();
			System.out.println("phn");
			long phn = sc.nextLong();
			System.out.println("age");
			int age=sc.nextInt();
			System.out.println("dob");
			String dob=sc.next(); // yyyy-MM-dd
//			LocalDate date =LocalDate.parse(dob, DateTimeFormatter.ofPattern("dd/mm/yyyy"));
			System.out.println("skills");
			String skills=sc.next();
			System.out.println("experience");
			double exp=sc.nextInt();
			
			
		
		try {
			//load driver
			Class.forName("org.postgresql.Driver");
			
			// create connection
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/student","postgres","root");
			
			//create statement
//			PreparedStatement preparedStatement = connection.prepareStatement("insert into student values(?,?,?,?,?,?)");
			
			if(exp > 2 && skills.equalsIgnoreCase("Spring"))
			{

		     	PreparedStatement preparedStatement = connection.prepareStatement("insert into student values(?,?,?,?,?,?)");
		     	preparedStatement.setString(1,ename);
		     	preparedStatement.setString(2,email);
		     	preparedStatement.setLong(3,phn);
		     	preparedStatement.setDouble(4,age);
		     	preparedStatement.setString(5,dob);
		     	preparedStatement.setString(6,skills);
		     	preparedStatement.setDouble(7,exp);
		     	
		     	preparedStatement.execute();
		     	
				System.out.println("skills matched thanks for apply ! Data added in the database");
			}
			else if(exp <=2)
		    {
				System.out.println("Your experience is not matching with requirement ! thanks");
			}
			else 
			{
				System.out.println("Your skill is not matching with requirement ! thanks");
			}
			
			
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
