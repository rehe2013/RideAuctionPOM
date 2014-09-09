package com.sqa.ra.db;

import java.sql.DriverManager;
import java.sql.*;

public class DemoInsertJDBC {
	
	
	public static void main(String[] args) throws ClassNotFoundException {
		
		try{
		//1.  Register Driver.
			
		Class.forName("com.mysql.jdbc.Driver");
		
		//2nd Get The Connection Object
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
		
		conn.setAutoCommit(false);
		//3rd Create Statement object
		Statement stmt=	conn.createStatement();
		
		String query="insert into user(user_id,password) values ('abc2','pass2')";
		int nofRows=stmt.executeUpdate(query);
		//commit the changes
		conn.commit();
		//close these object
		stmt.close();
		conn.close();
		
		
		
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
	}
	


}
