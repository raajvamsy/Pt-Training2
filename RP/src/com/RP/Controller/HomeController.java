package com.RP.Controller;



import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.RP.DAOIMPL.Constants;
import com.RP.DAOIMPL.DataDAOIMPL;
import com.RP.DTO.UserVO;


@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
         try
         {
			 String[] filepaths = request.getParameter("data").replace("\n", "").replace(" ","").split(",");
	         DataDAOIMPL obj = new DataDAOIMPL();
	         String[] l = Constants.languages;
	         List<UserVO> lu = obj.UploadFiles(filepaths);
	         List<String> users = new ArrayList<String>();;
	         List<String> usercount = new ArrayList<String>();;
	         List<String> languages =new ArrayList<String>();;
	         List<String> lancount = new ArrayList<String>();;
	         Map<String,Integer> map = obj.GetUsers(lu);
	         Map<String,Integer> map1 = obj.TotalSkills(lu);
	         for(Map.Entry m:map1.entrySet())
	 		 {
	        	 users.add((String) m.getKey());
	        	 usercount.add(String.valueOf(m.getValue()));
	 		 }
	         for(Map.Entry m:map.entrySet())
	 		 {
	        	 languages.add((String) m.getKey());
	        	 lancount.add(String.valueOf(m.getValue()));
	 		 }
	         
	         String s = "[" + obj.conv(users) + "]";
	         String sc = "[" + obj.conv(usercount) + "]";
	         String ll ="[" + obj.conv(languages) + "]";
	         String llc = "[" + obj.conv(lancount) + "]";
	         request.getSession().setAttribute("users",s );
	         request.getSession().setAttribute("uc", sc);
	         request.getSession().setAttribute("lan",ll );
	         request.getSession().setAttribute("lc", llc);
	         response.getWriter().write("Charts.jsp");
	         return;
         }
         catch(Exception e)
         {
        	 System.out.println(e);
         }
    }


		
}

