package com.ResumeParse.Parse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class SqlConn {
	
	private final static String url = "jdbc:postgresql://localhost:5432/parse";
	private final String user = "postgres";
	private final String password = "docker";
	private static SqlConn obj;
	private Connection con;

	public Connection getCon() {
		return con;
	}
	public static SqlConn getobj()
	{
		if(obj==null)
		{
			obj = new SqlConn();
			return obj;
		}
		else 
		{
			return obj;
		}
	}
	private SqlConn()
	{
		try
		{
			con = DriverManager.getConnection(url, user, password);
			System.out.println("Connected to the PostgreSQL server successfully.");
		}
		catch(SQLException e)
		{
//			System.out.println("Sql:"+e.getMessage());
		}
		catch(Exception e)
		{
//			System.out.println(e.getMessage());
		}
	}

}
