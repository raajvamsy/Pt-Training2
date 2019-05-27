package com.Resume.Parse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Constants {
	public String[] languages = new String[]{"Python","C,","C..,","Java","C#","Shell","Android","PHP","SQL","JavaScript","Angular js2","HTML","CSS","Ajax","XAMPP","MySQL"};
	final public String PHONENO = "[0-9]{10}";
	final public String EMAIL = "[a-zA-Z0-9._-]+@[a-zA-Z0-9]+.[a-zA-Z]+";
	final public String NAME = "[A-Z].*";
	public static Connection connect() {
        Connection conn = null;
        String url = "jdbc:postgresql://localhost:5432/parse";
    	String user = "postgres";
    	String password = "docker";
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
 
        return conn;
    }
	public void insert(String Name,String Email,Long PhoneNo,String Skills)
	{
		Connection conn = connect();
		try
		{

			PreparedStatement ps = conn.prepareStatement("INSERT INTO data(name,email,phoneno,skills) VALUES(?,?,?,?)");
			ps.setString(1, Name);
			ps.setString(2, Email);
			ps.setLong(3, PhoneNo);
			ps.setString(4, Skills);
			ResultSet rs = ps.executeQuery();
			System.out.println(rs);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public String Find(Pattern p,String text)
	{
		try
		{
			Matcher m = p.matcher(text);
			m.find();
			return m.group(0).replace(",","");
		}
		catch(Exception e)
		{
//			System.out.print("Not Found");
			return null;
		}
	}
}
