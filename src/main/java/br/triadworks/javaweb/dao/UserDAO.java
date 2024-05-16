package br.triadworks.javaweb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.triadworks.javaweb.model.User;

public class UserDAO {
	
	private Connection connection;
	
	
	public UserDAO(Connection connection) {
		this.connection = connection;
	}
	
	
	public User authenticateUser(String login, String password) {
		
		try {
			PreparedStatement pstmt = connection.
					prepareStatement("select * from user where login = ? and password = ?;");
			
			pstmt.setString(1, login);
			pstmt.setString(2, password);
			
			User user = null;
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				Long userID = rs.getLong("id");
				String userName = rs.getString("name");
				String userLogin = rs.getString("login");
				String userPassword = rs.getString("password");
				
				user = new User();
				
				user.setId(userID);
				user.setName(userName);
				user.setLogin(userLogin);
				user.setPassword(userPassword);
			}
			
			rs.close();
			pstmt.close();
			return user;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
}
