package br.triadworks.javaweb.model;

import java.sql.Connection;

import br.triadworks.javaweb.dao.CaloteiroDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DeleteCaloteiroLogica implements Logica {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Long caloteiroID = Long.parseLong(request.getParameter("id"));
		
		Connection connection = (Connection) request.getAttribute("connection");
		
		CaloteiroDAO dao = new CaloteiroDAO(connection);
		dao.deleteCaloteiro(caloteiroID);
		
		String message = "Caloteiro deleted";
		
		request.setAttribute("message", message);
		
		RequestDispatcher rd = request.getRequestDispatcher("/caloteiro-deleted.jsp");
		rd.forward(request, response);
		
	}

}
