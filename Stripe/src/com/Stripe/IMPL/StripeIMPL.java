package com.Stripe.IMPL;

import java.util.HashMap;
import java.util.Map;

import com.stripe.Stripe;
import com.stripe.model.Charge;
import com.stripe.model.Customer;
import com.stripe.model.InvoiceItem;
import com.stripe.model.Token;
import com.stripe.model.issuing.Card;

public class StripeIMPL {

	public String CreateCustomer()
	{
		Map<String, Object> customerParams = new HashMap<String, Object>();
	    customerParams.put("description", "Nothing here");
		customerParams.put("email", "nothing@nothing.com");
		String id = null;
		try
		{
			Customer c = Customer.create(customerParams);
			id = c.getId();
			return id;
		}
		catch(Exception e)
		{
			System.out.print(e);
			return null;
		}
	}
	
	public void charge(String price,String token)
	{
		
		Map<String, Object> chargeParams = new HashMap<String, Object>();
		chargeParams.put("amount", price);
		chargeParams.put("currency", "usd");
		chargeParams.put("description", "Monthly Charges");		
		chargeParams.put("source", token);
				
		try 
		{
		  Charge charge = Charge.create(chargeParams);
	      System.out.println(charge);
	      invoice(price);
	    } 
		catch (Exception e) 
		{
		  System.out.println("Message is: " + e.getMessage());
		}
	}
	public void invoice(String price)
	{
		Stripe.apiKey = "sk_test_n6fcqfT9qAtLrUxEXN7TsomR00tikyBcES";

		Map<String, Object> invoiceItemParams = new HashMap<String, Object>();
		invoiceItemParams.put("customer", "cus_FA5ruFlc46YF6d");
		invoiceItemParams.put("amount", price);
		invoiceItemParams.put("currency", "usd");
		invoiceItemParams.put("description", "One-time setup fee");


		try
		{
			InvoiceItem.create(invoiceItemParams);
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public String createcard(String cn,String y,String d,String cvv)
	{
		Map<String, Object> cardParams = new HashMap<String, Object>();
		Map<String, Object> tokenParams = new HashMap<String, Object>();

		cardParams.put("number", cn);
		cardParams.put("exp_month", d);
		cardParams.put("exp_year", y);
		cardParams.put("cvc", cvv);
		cardParams.put("customer","cus_FA5ruFlc46YF6d");
		try
		{
			tokenParams.put("card", cardParams);
			Token tk  = Token.create(tokenParams);
			return tk.getId();
		}
		catch(Exception e)
		{
			System.out.println(e);
			return null;
		}
	}
}
