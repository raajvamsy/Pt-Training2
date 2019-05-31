package com.Stripe.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Stripe.IMPL.StripeIMPL;
import com.stripe.Stripe;

@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static int i=0;
	public static String price ;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Stripe.apiKey = "sk_test_n6fcqfT9qAtLrUxEXN7TsomR00tikyBcES";
		StripeIMPL impl = new StripeIMPL();
		if(request.getParameter("price")!=null)
			price = request.getParameter("price");
		if(request.getParameter("cardnumber")!=null)
		{
			String cardnumber = request.getParameter("cardnumber");
			String month = request.getParameter("Month");
			String  year = request.getParameter("Year");
			String cvv = request.getParameter("cvv");
			String tk = impl.createcard(cardnumber, year, month, cvv);
			impl.charge(price,tk);
			response.sendRedirect("Success.jsp");
			return;
		}
		else
		{
			try
			{
				
				request.getSession().setAttribute("p","done");
				response.sendRedirect("CreditCard.jsp");
				return;
			}
//			https://rzp.io/l/0yTHFHz
			catch(Exception e)
			{
				System.out.println(e);
				
			}

		}
	}

}
