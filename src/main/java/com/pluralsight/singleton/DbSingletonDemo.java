package com.pluralsight.singleton;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DbSingletonDemo 
{
	public static void main(String args[])
	{
		long timeBefore = 0;
		long timeAfter = 0;
		
		DbSingleton instance = DbSingleton.getInstance();
		
		timeBefore = System.currentTimeMillis();
		Connection conn = instance.getConnection();	
		timeAfter = System.currentTimeMillis();
		
		System.out.println(timeAfter - timeBefore);
		
		Statement stmt = null;
		
		try
		{
			stmt = conn.createStatement();
			String sql = "CREATE TABLE Address (ID INT, StreetName VARCHAR(20), City VARCHAR(20))";
			int count = stmt.executeUpdate(sql);
			System.out.println("table created.");
			stmt.close();
		}
		catch(SQLException e)
		{
			System.out.println(e);
			e.printStackTrace();
		}
		
		timeBefore = System.currentTimeMillis();
		conn = instance.getConnection();	
		timeAfter = System.currentTimeMillis();
		
		System.out.println(timeAfter - timeBefore);
	}
}
