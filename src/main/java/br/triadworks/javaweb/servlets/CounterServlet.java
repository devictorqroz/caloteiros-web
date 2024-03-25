package br.triadworks.javaweb.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/counter")
public class CounterServlet  extends HttpServlet {

	private int counter = 0;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		counter ++;
		
		PrintWriter printer = response.getWriter();
		printer.println("<html>");
		printer.println("<body>");
		printer.println("Server number: " + counter);
		printer.println("</body>");
		printer.println("</html>");
		
	}
	
}
