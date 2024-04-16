package br.triadworks.javaweb.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import br.triadworks.javaweb.dao.CaloteiroDAO;
import br.triadworks.javaweb.exceptions.CaloteiroServletException;
import br.triadworks.javaweb.model.Caloteiro;
import br.triadworks.javaweb.model.IncludeCaloteiroLogica;
import br.triadworks.javaweb.model.Logica;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/system")
public class SystemServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		String action = request.getParameter("logica");
		String classNameFromAction = "br.triadworks.javaweb.model."+action+"Logica";
		
		try {
			Class newClassFromClassName = Class.forName(classNameFromAction);
			Object objectFromNewClass = newClassFromClassName.newInstance();
			Logica logica = (Logica) objectFromNewClass;
			logica.execute(request, response);
		} catch (ClassNotFoundException e) {
			throw new CaloteiroServletException(e.getMessage());
		} catch (InstantiationException | IllegalAccessException e) {
			throw new CaloteiroServletException(e.getMessage());
		} catch (Exception e) {
			throw new CaloteiroServletException(e.getMessage());
		}
		
	}
}
