package br.triadworks.javaweb.model;

import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import br.triadworks.javaweb.dao.CaloteiroDAO;
import br.triadworks.javaweb.exceptions.CaloteiroServletException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class IncludeCaloteiroLogica implements Logica {
	
	public void execute(HttpServletRequest request, HttpServletResponse response)
				throws Exception {
		
		String form = request.getParameter("form");
		if (form == null) {
			form = "new";
		}
		
		if (form.equals("new")) {
			RequestDispatcher rd = 
				request.getRequestDispatcher("/includeCaloteiro.jsp");
			rd.forward(request, response);
			
		} else if (form.equals("save")) {
			Connection connection = (Connection) request.getAttribute("connection");
			
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String debt = request.getParameter("debt");
			String debtDate = request.getParameter("debtDate");
			Calendar debtDateParsed = null;
			try {
				Date debtDateFormatted = 
					new SimpleDateFormat("dd/MM/yyyy").parse(debtDate);
				debtDateParsed = Calendar.getInstance();
				debtDateParsed.setTime(debtDateFormatted);
			} catch (ParseException e) {
				throw new CaloteiroServletException();
			}
			
			Caloteiro caloteiro = new Caloteiro();
			caloteiro.setName(name);
			caloteiro.setEmail(email);
			caloteiro.setDebt(new Integer(debt));
			caloteiro.setDebtDate(debtDateParsed);

			CaloteiroDAO dao = new CaloteiroDAO(connection);
			dao.includeCaloteiro(caloteiro);
			
			request.setAttribute("caloteiro", caloteiro);
			RequestDispatcher rd = 
				request.getRequestDispatcher("/caloteiroIncluded.jsp");
			rd.forward(request, response);
			
		} else if (form.equals("update")) {
			Connection connection = (Connection) request.getAttribute("connection");
			
			Long caloteiroID = Long.parseLong(request.getParameter("id"));
			
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String debt = request.getParameter("debt");
			String debtDate = request.getParameter("debtDate");
			Calendar debtDateParsed = null;
			try {
				Date debtDateFormatted = 
					new SimpleDateFormat("dd/MM/yyyy").parse(debtDate);
				debtDateParsed = Calendar.getInstance();
				debtDateParsed.setTime(debtDateFormatted);
			} catch (ParseException e) {
				throw new CaloteiroServletException();
			}
			
			Caloteiro caloteiro = new Caloteiro();
			caloteiro.setId(caloteiroID);
			caloteiro.setName(name);
			caloteiro.setEmail(email);
			caloteiro.setDebt(new Integer(debt));
			caloteiro.setDebtDate(debtDateParsed);

			CaloteiroDAO dao = new CaloteiroDAO(connection);
			dao.updateCaloteiro(caloteiro);
			
			request.setAttribute("caloteiro", caloteiro);
			RequestDispatcher rd = 
				request.getRequestDispatcher("/caloteiroUpdated.jsp");
			rd.forward(request, response);
		} 
			
	}
}
