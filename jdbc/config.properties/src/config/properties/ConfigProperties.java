package config.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class ConfigProperties {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url1="jdbc:postgresql://localhost:5432/postgres?user=postgres&password=root";
//		String user="postgres";
//		String password="root";
		Driver driver = new org.postgresql.Driver();
		try {
		DriverManager.registerDriver(driver);
		FileInputStream f=new FileInputStream("config.properties");
		Properties properties =new Properties();
		properties.load(f);
		Connection connection =DriverManager.getConnection(url1,properties);
		System.out.println("driver registered");
		System.out.println(connection);
//		step 3
		
	 Statement statement=connection.createStatement();
	 
	 ResultSet set= statement.executeQuery("select * from student");
	// ResultSet set= statement.getResultSet()
		while(set.next())
		{
			System.out.println(set.getInt(1));
			System.out.println(set.getString(2));
		}
		//statement.execute("insert into student values(7,'raj', 1200.03, 321654987);");
		
		//inbuilt methods
//		execute(String query)
//		executeUpdate(String query)
//		executeQuery()
		System.out.println("data inserted");
		}
		catch (SQLException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

}
