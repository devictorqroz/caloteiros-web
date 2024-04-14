<% String msg = "Minha segunda página JSP"; %>
<html>
	<head>
		<meta charset="UTF-8">
		<title><% out.println(msg); %></title>
	</head>
	<body>
		<%=msg %>
	</body>
</html>