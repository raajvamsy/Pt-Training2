package com.ResumeParse.DAOIMPL;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.tika.*;

import com.ResumeParse.DAO.ParseDataDAO;
import com.ResumeParse.DTO.UserVO;
import com.ResumeParse.Parse.SqlConn;

public class DataDAOIMPL implements ParseDataDAO {

	private Connection con;
	public DataDAOIMPL()
	{
		SqlConn sqlobj = SqlConn.getobj();
		con = sqlobj.getCon();
	}
	@Override
	public String Find(Pattern p,String text)
	{
		try
		{
			text = text.replace("\\",",");
			Matcher m = p.matcher(text);
			m.find();
			return m.group(0).replace(",","");
		}
		catch(Exception e)
		{
			return null;
		}
	}
	@Override
	public void insert(UserVO user) {
		try
		{

			PreparedStatement ps = con.prepareStatement("INSERT INTO data(name,email,phoneno,skills) VALUES(?,?,?,?)");
			ps.setString(1, user.getName());
			ps.setString(2, user.getEmail());
			ps.setLong(3, user.getPhoneNo());
			ps.setString(4, user.getSkills());
			ResultSet rs = ps.executeQuery();
			System.out.println(rs);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}

	@Override
	public Map<String, Integer> TotalSkills(UserVO user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Integer> GetUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void UploadFiles(String[] Filepaths) {
		for(String source:Filepaths)
        {
       	 	 String filename = Find(Pattern.compile(Constants.FILENAME),source); 
   	 		 String dest="C:\\Users\\raajvamsy\\Desktop\\Postgres\\volumes\\postgres\\"+filename;
	         InputStream is = null;
	         OutputStream os = null;
	         try 
	         {
	             is = new FileInputStream(source);
	             os = new FileOutputStream(dest);
	             byte[] buffer = new byte[1024];
	             int length;
	             while ((length = is.read(buffer)) > 0)
	             {
	                 os.write(buffer, 0, length);
	             }
	             is.close();
	             os.close();
	             insert(GetData(filename));
         	 } 
	         catch(Exception e) 
	         {
	        	 System.out.println(e);
	         }
        }
		
	}

	@Override
	public UserVO GetData(String Filename) {
		try
		{
			UserVO user = new UserVO();
			File Document = new File("C:\\Users\\raajvamsy\\Desktop\\Postgres\\volumes\\postgres\\"+Filename);
			List<String> lan = new ArrayList<String>();
			String parsedText = null;
			try	
			{
				parsedText = new Tika().parseToString(Document);
			}
			catch(Exception e)
			{
				System.out.println("Error reading file");
			}
			String Name,Email,Skills;
			Long PhoneNo;
			Name = Find(Pattern.compile(Constants.NAME),parsedText);
			Email = Find(Pattern.compile(Constants.EMAIL),parsedText);
			PhoneNo = Long.parseLong(Find(Pattern.compile(Constants.PHONENO), parsedText));
			for(String s:Constants.languages)
			{
				String temp = Find(Pattern.compile(s,Pattern.CASE_INSENSITIVE), parsedText);
				if(!lan.contains(temp) && temp!=null)
				{
					lan.add(temp);
				}
			}
			Skills  = String.join(",",lan);
			user.setName(Name);
			user.setEmail(Email);
			user.setPhoneNo(PhoneNo);
			user.setSkills(Skills);
			return user;
		}
		catch(Exception e)
		{
			return null;
		}
	}

}
