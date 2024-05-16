<%@ include file="includes.jsp" %>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Login Caloteiros</title>
	</head>
	<body>
		<c:import url="header.jsp" />
		<form action="system?logica=AuthenticateUser" method="post" id="formLogin">
			Login: <input type="text" name="login" value="" />
			Senha: <input type="password" name="password" value="" />
			<input type="submit" value="Login" />
		</form>
		<p>${message}</p>
		<c:import url="footer.jsp" />
	</body>
</html>