package br.triadworks.javaweb.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/HelloWorld")
public class MyFirstServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		PrintWriter sysout = response.getWriter();
		
		sysout.println("<html>");
		sysout.println("<body>");
		sysout.println("Wooow, my first servlet :D!");
		sysout.println("</body>");
		sysout.println("</html>");
	}
}
 