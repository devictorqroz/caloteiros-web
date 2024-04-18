package br.triadworks.javaweb.examples;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;

@WebFilter(filterName="TimeFilter", urlPatterns="/*")
public class TimeFilter implements Filter {

	@Override
	public void destroy() {
	}
		
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, 
			FilterChain chain) throws IOException, ServletException {
		long initialTime = System.currentTimeMillis();
		
		chain.doFilter(request, response);
		
		long finalTime = System.currentTimeMillis();
		String uri = ((HttpServletRequest)request).getRequestURI();
		System.out.println("Requisição para : " + uri + " foi de: "
							+ (initialTime - finalTime));
	}
	
	
	@Override
	public void init(FilterConfig filterConfig) 
			throws ServletException {
	}

}
