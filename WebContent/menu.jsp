<%@ include file="includes.jsp" %>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Menu Caloteiros</title>
	</head>
	<body>
		<c:import url="header.jsp" />
		<p>Seja bem vindo ${authenticatedUser.name} ao sistema caloteiros:</p>
		<p>
			<ol>
				<a href='<c:url value="/includeCaloteiro.jsp" />' >
					Adicionar caloteiro
				</a>
			</ol>
			<ol>
				<a href='<c:url value="/system?logica=ListCaloteiro" />' >
					Listar caloteiros
				</a>
			</ol>
		</p>
		
		<c:import url="footer.jsp" />
	</body>
</html>


