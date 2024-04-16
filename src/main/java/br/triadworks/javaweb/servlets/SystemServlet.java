package br.triadworks.javaweb.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import br.triadworks.javaweb.dao.CaloteiroDAO;
import br.triadworks.javaweb.exceptions.CaloteiroServletException;
import br.triadworks.javaweb.model.Caloteiro;
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

			CaloteiroDAO dao = new CaloteiroDAO();
			dao.includeCaloteiro(caloteiro);
			
			RequestDispatcher rd = 
				request.getRequestDispatcher("/caloteiro-adicionado.jsp");
			rd.forward(request, response);
		
		} else {
			RequestDispatcher rd = 
				request.getRequestDispatcher("/error-default.jsp");
		}
	}
}
