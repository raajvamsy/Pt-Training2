package com.RP.DAOIMPL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class SqlConn {
	
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

	

}
