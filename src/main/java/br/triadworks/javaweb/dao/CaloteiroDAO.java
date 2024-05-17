package br.triadworks.javaweb.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.triadworks.javaweb.model.Caloteiro;

public class CaloteiroDAO {

	private Connection connection;
	
	
	public CaloteiroDAO(Connection connection) {
		this.connection = connection;
	}
	
	
	public void includeCaloteiro(Caloteiro caloteiro) {
		String stmt = "insert into caloteiro " +
						"(name, email, debt, debtDate) " +
						"values (?, ?, ?, ?);";
		
		try {
			PreparedStatement pstmt = connection.prepareStatement(stmt);
			
			pstmt.setString(1, caloteiro.getName());
			pstmt.setString(2, caloteiro.getEmail());
			pstmt.setDouble(3, caloteiro.getDebt());
			pstmt.setDate(4, new Date(caloteiro.getDebtDate().getTimeInMillis()));
			
			pstmt.execute();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Caloteiro> getList() {
		try {
			PreparedStatement pstmt = this.connection.
					prepareStatement("select * from caloteiro;");
			
			List<Caloteiro> caloteiros = new ArrayList<>();
			Caloteiro caloteiro = null;
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Long idCaloteiro = (long) rs.getInt("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Double debt = rs.getDouble("debt");
				Calendar debtDate = Calendar.getInstance();
				debtDate.setTime(rs.getDate("debtDate"));
				
				caloteiro = new Caloteiro();
				caloteiro.setId(idCaloteiro);
				caloteiro.setName(name);
				caloteiro.setEmail(email);
				caloteiro.setDebt(new Double(debt));
				caloteiro.setDebtDate(debtDate);
				
				caloteiros.add(caloteiro);
			}
			
			rs.close();
			pstmt.close();
			return caloteiros;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Caloteiro getCaloteiroByID(Long id) {
		try {
			PreparedStatement stmt = this.connection.
					prepareStatement("select * from caloteiro where id=?;");
			stmt.setLong(1, id);
			
			Caloteiro caloteiro = null;
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				Long caloteiroID = rs.getLong("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Double debt = rs.getDouble("debt");
				Calendar debtDate = Calendar.getInstance();
				debtDate.setTime(rs.getDate("debtDate"));
				
				caloteiro = new Caloteiro();
				caloteiro.setId(caloteiroID);
				caloteiro.setName(name);
				caloteiro.setEmail(email);
				caloteiro.setDebt(new Double(debt));
				caloteiro.setDebtDate(debtDate);
			}
			
			rs.close();
			stmt.close();
			return caloteiro;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}	
	}
	
	public void updateCaloteiro(Caloteiro caloteiro) {
		
		String stmt = "update caloteiro set name=?, email=?, " +
				"debt=?, debtDate=? where id=?;";
		
		try {
			PreparedStatement pstmt = this.connection.prepareStatement(stmt);
			
			pstmt.setString(1, caloteiro.getName());
			pstmt.setString(2, caloteiro.getEmail());
			pstmt.setDouble(3, caloteiro.getDebt());
			pstmt.setDate(4, new Date(caloteiro.getDebtDate().getTimeInMillis()));
			pstmt.setLong(5, caloteiro.getId());
			
			pstmt.execute();
			pstmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void deleteCaloteiro(Long id) {
		
		String sql = "delete from caloteiro where id = ?;";
		 
		try {
			PreparedStatement pstmt = this.connection.prepareStatement(sql);
			
			pstmt.setLong(1, id);
			
			pstmt.execute();
			pstmt.close();
			
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}
	
}
