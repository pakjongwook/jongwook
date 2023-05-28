package com.kh.test.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OrderServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException  {
		  String name = req.getParameter("name");
	      int blackPen = Integer.parseInt(req.getParameter("blackPen"));
	      int redPen = Integer.parseInt(req.getParameter("redPen"));
	      int bluePen = Integer.parseInt(req.getParameter("bluePen"));
	      int whitePen = Integer.parseInt(req.getParameter("white"));

		
	      int total = blackPen + redPen + bluePen + whitePen;
	      
	      if(total != 0) {
	    	  req.setAttribute("name", name);
	    	  req.setAttribute("blackPen", blackPen);
	    	  req.setAttribute("redPen", redPen);
	    	  req.setAttribute("bluePen", bluePen);
	    	  req.setAttribute("whitePen", whitePen);
	    	  req.setAttribute("total", total);
	    	  
	    	  RequestDispatcher dispatcher 
	    	  = req.getRequestDispatcher("/WEB-INF/views/resultPage.jsp");
	    	  
	      } else {
	    	  resp.sendRedirect("/WEB-INF/views/errorPage.jsp");
	    	  
	      }
	      
	}
	
	

}
