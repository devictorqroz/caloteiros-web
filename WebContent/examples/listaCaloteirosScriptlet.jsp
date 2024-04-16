<%@page import="br.triadworks.javaweb.dao.CaloteiroDAO" %>
<%@page import="br.triadworks.javaweb.model.Caloteiro" %>
<%@page import="java.util.List" %>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Lista de Caloteiros</title>
	</head>
	<body>
		Lista de Caloteiros: </br>
		
		<%
				CaloteiroDAO dao = new CaloteiroDAO();
									List<Caloteiro> list = dao.getList();
									for(Caloteiro c : list) {
				%>
		
			<li>
				<%=c.getName() %> - <%=c.getEmail() %>
			</li>
		
		<% } %>
		
	</body>
</html>