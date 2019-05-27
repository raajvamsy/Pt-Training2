package com.Resume.Parse;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.tika.Tika;


public class DocParse 
{

	
	public static void main(String args[]) throws IOException {
		List<String> lan = new ArrayList<String>();
		Constants con = new Constants();
//		File Document = new File("C:\\Users\\raajvamsy\\Downloads\\SINDUJA SUNDER.pdf");
//		System.out.println(Document.exists());
//		File Document = new File("C:\\Users\\raajvamsy\\Downloads\\Resume.pdf");
//		File Document = new File("C:\\Users\\raajvamsy\\Downloads\\RESUME(santosh).docx");
		File Document = new File("C:\\Users\\raajvamsy\\Downloads\\RESUME(chowdary).docx");
		String parsedText = null;
		try
		{
			parsedText = new Tika().parseToString(Document);
		}
		catch(Exception e)
		{
			System.out.println("Error reading file");
		}
		String Name,Email;
		Long PhoneNo;
		
		Name = con.Find(Pattern.compile(con.NAME),parsedText);
		Email = con.Find(Pattern.compile(con.EMAIL),parsedText);
		PhoneNo = Long.parseLong(con.Find(Pattern.compile(con.PHONENO), parsedText));
		for(String s:con.languages)
		{
			String temp = con.Find(Pattern.compile(s,Pattern.CASE_INSENSITIVE), parsedText);
			if(!lan.contains(temp) && temp!=null)
			{
				lan.add(temp);
			}
		}
		String l = String.join(",",lan);
		System.out.println(Name+'\n'+Email+'\n'+PhoneNo+'\n'+l);
		con.insert(Name, Email, PhoneNo, l);
		
	}
}

