package com.ResumeParse.controller;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.regex.Pattern;
import org.apache.tika.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ResumeParse.DAOIMPL.DataDAOIMPL;


@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
         String[] filepaths = request.getParameter("data").split(",");
         //DataDAOIMPL obj = new DataDAOIMPL();
         try
 		{
     		File Document = new File("C:\\Users\\raajvamsy\\Downloads\\RESUME(chowdary).docx");
 			 String parsedText = new Tika().parseToString(Document);
 			 System.out.println(parsedText);
 		}
 		catch(Exception e)
 		{
 			System.out.println("Error reading file");
 		}
         //obj.UploadFiles(filepaths);
    }


		
}

