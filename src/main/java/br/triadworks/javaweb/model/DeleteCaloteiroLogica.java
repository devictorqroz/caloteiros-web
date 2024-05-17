package br.triadworks.javaweb.model;

import java.sql.Connection;

import br.triadworks.javaweb.dao.CaloteiroDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DeleteCaloteiroLogica implements Logica {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Connection connection = (Connection) request.getAttribute("connection");

		Long caloteiroID = Long.parseLong(request.getParameter("id"));
		String caloteiroName = request.getParameter("name");
		
		CaloteiroDAO dao = new CaloteiroDAO(connection);
		dao.deleteCaloteiro(caloteiroID);
		
		request.setAttribute("name", caloteiroName);
		
		RequestDispatcher rd = request.getRequestDispatcher("/caloteiro-deleted.jsp");
		rd.forward(request, response);
		
	}

}
