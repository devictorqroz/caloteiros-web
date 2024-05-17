package br.triadworks.javaweb.filters;

import java.io.IOException;

import br.triadworks.javaweb.model.User;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;

@WebFilter(filterName="AuthorizationFilter", urlPatterns="/*")
public class AuthorizationFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		String uri = httpRequest.getRequestURI();
		
		String logica = httpRequest.getParameter("logica");
		if (logica == null) {
			logica = "";
		}
		
		if (uri.equals("login.jsp")
			|| uri.endsWith("header.jsp")
			|| uri.endsWith("footer.jsp")
			|| logica.endsWith("AuthenticateUser")
			|| uri.endsWith("png")
			|| uri.endsWith("css")) {
			
				chain.doFilter(request, response);
		} else {
			
			User authenticatedUser = 
				(User) httpRequest.getSession().getAttribute("authenticatedUser");
			
			if (authenticatedUser != null) {
				chain.doFilter(request, response);
			} else {
				request.setAttribute("message", "Faça login no sistema!");
				
				RequestDispatcher rd = 
						request.getRequestDispatcher("/login.jsp");
				
				rd.forward(request, response);
			}
		}
	}
	
	@Override
	public void destroy() {
	}

}
