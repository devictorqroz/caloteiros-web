package br.triadworks.javaweb.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import br.triadworks.javaweb.dao.CaloteiroDAO;
import br.triadworks.javaweb.exceptions.CaloteiroServletException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UpdateCaloteiroLogica implements Logica {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		Long caloteiroID = Long.parseLong(request.getParameter("id"));
		
		Caloteiro caloteiro = null;
		try {
			CaloteiroDAO dao = new CaloteiroDAO();
			caloteiro = dao.getCaloteiroByID(caloteiroID);
		} catch (Exception e) {
			throw new CaloteiroServletException();
		}
		
		request.setAttribute("caloteiro", caloteiro);
		
		RequestDispatcher rd = request.getRequestDispatcher("/updateCaloteiroByID.jsp");
		rd.forward(request, response);
	}
}
