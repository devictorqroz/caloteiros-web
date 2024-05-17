<%@ include file="includes.jsp" %>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Login Caloteiros</title>
		<link rel="stylesheet" type="text/css" href="css/login.css">
	</head>
	<body>
		<header>
			<c:import url="header.jsp" />
			<h1>Caloteiros</h1>
		</header>
		<main>
			<form action="system?logica=AuthenticateUser" method="post" id="formLogin">
				Login: <input type="text" name="login" value="" />
				Senha: <input type="password" name="password" value="" />
				<input type="submit" id="login" value="Login" />
			</form>
			<p>${message}</p>
		</main>
		<footer>
			<c:import url="footer.jsp" />
		</footer>
	</body>
</html>