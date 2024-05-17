<%@ include file="/includes.jsp" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Página de Erro 404</title>
    <link rel="stylesheet" type="text/css" href="css/error.css">
</head>
<body>
	<header>
		<c:import url="header.jsp" />
		<h2>Caloteiros</h2>
	</header>
    <main>
        <h1>404</h1>
        <p>Não conseguimos encontrar esse link, tente um novo link.</p>
        <a href="menu.jsp">Retornar ao Menu</a>
    </main>
    <footer>
       <c:import url="footer.jsp" />
    </footer>
</body>
</html>
