package br.triadworks.javaweb.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.triadworks.javaweb.model.Caloteiro;

public class CaloteiroDAO {

	private Connection connection;
	
	
	public CaloteiroDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	
	public void includeCaloteiro(Caloteiro caloteiro) {
		String stmt = "insert into caloteiro " +
						"(name, email, debt, debtDate) " +
						"values (?, ?, ?, ?);";
		
		try {
			PreparedStatement pstmt = connection.prepareStatement(stmt);
			
			pstmt.setString(1, caloteiro.getName());
			pstmt.setString(2, caloteiro.getEmail());
			pstmt.setInt(3, caloteiro.getDebt());
			pstmt.setDate(4, new Date(caloteiro.getDebtDate().getTimeInMillis()));
			
			pstmt.execute();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
