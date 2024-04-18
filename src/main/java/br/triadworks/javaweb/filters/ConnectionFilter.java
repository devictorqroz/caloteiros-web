package br.triadworks.javaweb.filters;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import br.triadworks.javaweb.dao.ConnectionFactory;
import br.triadworks.javaweb.exceptions.CaloteiroServletException;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;

@WebFilter(filterName="ConnectionFilter", urlPatterns="/system")
public class ConnectionFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}
	
	@Override
	public void doFilter(ServletRequest request, 
						ServletResponse response,
						FilterChain chain) 
				throws IOException, ServletException {
		
		Connection connection = 
				new ConnectionFactory().getConnection();
		
		request.setAttribute("connection", connection);
		
		chain.doFilter(request, response);
		
		try {
			connection.close();
		} catch (SQLException e) {
			throw new CaloteiroServletException("Erro ao tentar fechar a conexão com o banco!");
		}
		
	}

	//@Override
	//public void destroy() {
//	}

}
