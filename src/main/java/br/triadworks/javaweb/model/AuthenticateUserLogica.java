package br.triadworks.javaweb.model;

import java.sql.Connection;

import br.triadworks.javaweb.dao.UserDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class AuthenticateUserLogica implements Logica {

	@Override
	public void execute(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		
		User authenticatedUser = null;
		String login = request.getParameter("login");
		String password = request.getParameter("password");

		Connection connection = 
				(Connection) request.getAttribute("connection");
		
		UserDAO userDAO = new UserDAO(connection);
		authenticatedUser = userDAO.authenticateUser(login, password);
	
		if (authenticatedUser != null) {
			HttpSession session = request.getSession();
			session.setAttribute("authenticatedUser", authenticatedUser);
			
			response.sendRedirect("menu.jsp");
		} else {
			request.setAttribute("userMessage", "Login ou Password inválidos");
			RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
			rd.forward(request, response);
		}
	}

}
