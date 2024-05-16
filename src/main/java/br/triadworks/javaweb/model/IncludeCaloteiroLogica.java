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

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
							throws Exception {
		
		String form = request.getParameter("form");
		
		Connection connection = (Connection) request.getAttribute("connection");
		
		
		if (form.equals("include")) {	
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String debt = request.getParameter("debt");
			String debtDate = request.getParameter("debtDate");
			Calendar debtDateParsed = null;
			try {
				Date debtDateFormatted = new SimpleDateFormat("dd/MM/yyyy").parse(debtDate);
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
					request.getRequestDispatcher("/caloteiro-included.jsp");
			rd.forward(request, response);	
		
		} else if (form.equals("update")) {
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
					request.getRequestDispatcher("/caloteiro-updated.jsp");
			rd.forward(request, response);
			
		}
		
		
	}

}
