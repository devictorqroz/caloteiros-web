<%@ include file="/includes.jsp" %>
<html>
	<head>
		<title>Adiciona caloteiro</title>
	</head>
	<body>
		<c:import url="cabecalho.jsp" />
		</br>
		</br>
		<form action="adicionaCaloteiro" method="post">
			Nome: <input type="text" name="name"/> </br>
			E-mail: <input type="text" name="email"/> </br>
			Devendo R$: <input type="text" name="debt"/> </br>
			Data: <input type="text" name="debtDate"/> </br>
		
			<input type="submit" value="Salvar"/>
		</form>
		</br>
		<c:import url="rodape.jsp" />
	</body>
</html>