package br.triadworks.javaweb.model;

import java.util.List;

import br.triadworks.javaweb.dao.CaloteiroDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ListCaloteiroLogica implements Logica {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
							throws Exception {
		
		CaloteiroDAO dao = new CaloteiroDAO();
		List<Caloteiro> caloteiros = dao.getList();
		
		request.setAttribute("caloteiros", caloteiros);
		
		RequestDispatcher rd = request.getRequestDispatcher("/list-caloteiros.jsp");
		rd.forward(request, response);
	}

}
