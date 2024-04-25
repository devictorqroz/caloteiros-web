<%@ include file="/includes.jsp" %>
<html>
	<head>
		<title>Adiciona Caloteiro</title>
	</head>
	<body>
		<c:import url="header.jsp" />
		<hr>
		<form action="includeCaloteiro" method="post">
			
			<triadTag:textField 
				nameField="name" 
				label="Nome:" 
				id="labelName" /> </br>
			<triadTag:textField 
				nameField="email" 
				label="Email:" 
				id="labelEmail" /> </br>
			<triadTag:textField 
				nameField="debt" 
				label="Devendo:" 
				id="labelDebt" /> </br>
			<triadTag:textField 
				nameField="debtDate" 
				label="Data da D�vida:" 
				id="labelDate" /> </br>
				
			<input type="submit" value="Salvar" />
		</form>
		<hr>
		<c:import url="footer.jsp" />
	</body>
</html>