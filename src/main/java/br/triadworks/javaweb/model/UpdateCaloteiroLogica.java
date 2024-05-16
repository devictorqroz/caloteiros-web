package br.triadworks.javaweb.model;

import java.sql.Connection;

import br.triadworks.javaweb.dao.CaloteiroDAO;
import br.triadworks.javaweb.exceptions.CaloteiroServletException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UpdateCaloteiroLogica implements Logica {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
							throws Exception {
		
		Long caloteiroID = Long.parseLong(request.getParameter("id"));
		
		Connection connection = (Connection) request.getAttribute("connection");
		
		Caloteiro caloteiro = null;
		
		try {
			CaloteiroDAO dao = new CaloteiroDAO(connection);
			caloteiro = dao.getCaloteiroByID(caloteiroID);
		} catch (Exception e) {
			throw new CaloteiroServletException();
		}
		
		request.setAttribute("caloteiro", caloteiro);
		
		RequestDispatcher rd = request.getRequestDispatcher("/update-caloteiro.jsp");
		rd.forward(request, response);
	}

}
