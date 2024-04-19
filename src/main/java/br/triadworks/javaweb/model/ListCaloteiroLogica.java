package br.triadworks.javaweb.model;

import java.sql.Connection;
import java.util.List;

import br.triadworks.javaweb.dao.CaloteiroDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class ListCaloteiroLogica implements Logica {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Connection connection = (Connection) request.getAttribute("connection");
		
		CaloteiroDAO dao = new CaloteiroDAO(connection);
		List<Caloteiro> caloteiros = dao.getList();
		
		request.setAttribute("caloteiros", caloteiros);
		RequestDispatcher rd = request.getRequestDispatcher("/listCaloteiros.jsp");
		rd.forward(request, response);
	}

}
