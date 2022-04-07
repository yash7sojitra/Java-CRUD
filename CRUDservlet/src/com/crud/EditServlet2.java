package com.crud;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditServlet2
 */
@WebServlet("/EditServlet2")
public class EditServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			
		
			int id = Integer.parseInt(request.getParameter("id"));
			String name=request.getParameter("name");
			String password = request.getParameter("password");
			String email= request.getParameter("email");
			String country = request.getParameter("country");
			
			Emp  e = new Emp();
			e.setId(id);
			e.setName(name);
			e.setPassword(password);
			e.setEmail(email);
			e.setCountry(country);
			
			int status=0;
				 try {
					status= empDAO.update(e);
				} catch (Exception e1) {
					System.out.println(e1);
				}
			if(status>0) {
				response.sendRedirect("ViewServlet.jsp");
			}else {
				out.print("Unable to update record..");
			}
			out.close();
	}

}
