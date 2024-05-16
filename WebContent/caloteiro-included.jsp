<%@ include file="/includes.jsp" %>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Caloteiro Adicionado</title>
	</head>
	<body>
		Caloteiro ${caloteiro.name} adicionado com sucesso.
		<a href='<c:url value="/menu.jsp" />' >
					Menu
		</a>
	</body>
</html>