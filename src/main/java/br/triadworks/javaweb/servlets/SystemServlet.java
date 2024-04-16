package br.triadworks.javaweb.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import br.triadworks.javaweb.dao.CaloteiroDAO;
import br.triadworks.javaweb.exceptions.CaloteiroServletException;
import br.triadworks.javaweb.model.Caloteiro;
import br.triadworks.javaweb.model.IncludeCaloteiroLogic;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/system")
public class SystemServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		String action = request.getParameter("resource");
		
		if (action.equals("adicionarCaloteiro")) {
			try {
				new IncludeCaloteiroLogic().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			RequestDispatcher rd = 
				request.getRequestDispatcher("/error-default.jsp");
		}
	}
}
