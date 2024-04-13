package br.triadworks.javaweb.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import br.triadworks.javaweb.dao.CaloteiroDAO;
import br.triadworks.javaweb.model.Caloteiro;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/adicionaCaloteiro")
public class IncludeCaloteiroServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		PrintWriter out = response.getWriter(); 
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String debt = request.getParameter("debt");
		String debtDate = request.getParameter("debtDate");
		Calendar debtDateParsed = null;
		try {
			Date debtDateFormatted = new SimpleDateFormat("dd/MM/yyyy").parse(debtDate);
			debtDateParsed = Calendar.getInstance();
			debtDateParsed.setTime(debtDateFormatted);
		} catch (ParseException e) {
			out.println("Erro de conversão de data.");
		}
		
		Caloteiro caloteiro = new Caloteiro();
		caloteiro.setName(name);
		caloteiro.setEmail(email);
		caloteiro.setDebt(new Integer(debt));
		caloteiro.setDebtDate(debtDateParsed);
		
		CaloteiroDAO dao = new CaloteiroDAO();
		dao.includeCaloteiro(caloteiro);
		
		out.println("<html>");
		out.println("<body>");
		out.println("Caloteiro " + caloteiro.getName() + " adicionado com sucesso");
		out.println("</body>");
		out.println("</html>");	
	}
	
}
