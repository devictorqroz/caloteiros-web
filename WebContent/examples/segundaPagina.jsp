<% String msg = "Minha segunda p�gina JSP"; %>
<html>
	<head>
		<meta charset="UTF-8">
		<title><% out.println(msg); %></title>
	</head>
	<body>
		<%=msg %>
	</body>
</html>