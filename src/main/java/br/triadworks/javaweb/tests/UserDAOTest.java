package br.triadworks.javaweb.tests;

import java.sql.Connection;

import br.triadworks.javaweb.dao.ConnectionFactory;
import br.triadworks.javaweb.dao.UserDAO;
import br.triadworks.javaweb.model.User;

public class UserDAOTest {

	public static void main(String[] args) {
		
		Connection connection = 
				new ConnectionFactory().getConnection();
		UserDAO userDAO = new UserDAO(connection);
		
		
		User loggedUser = 
				userDAO.authenticateUser("admin", "123");		
		if (loggedUser != null) {
			System.out.println("Usuário logado: " + loggedUser.getName());
		}
		
		
		User invalidUser = 
				userDAO.authenticateUser("any", "000");
		 if (invalidUser == null) {
			System.out.println("Usuário não existe.");
		}
	
	}
	
}
