<% String msg = "seja bem vindo ao meu JSP"; %>
<html>
	<head>
		<meta charset="UTF-8">
		<title><% out.println(msg); %></title>
	</head>
	<body>
		Olá <%=request.getParameter("nome") %>, <%=msg %>
	</body>
</html>