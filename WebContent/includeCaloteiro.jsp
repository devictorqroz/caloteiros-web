<%@ include file="/includes.jsp" %>
<html>
	<head>
		<title>Adiciona caloteiro</title>
	</head>
	<body>
		<c:import url="header.jsp" />
		<hr>
			Usuário logado: ${authenticatedUser.name}
		<hr>
		<form action="system" method="post">
			<input type="hidden" name="logica" value="IncludeCaloteiro" />
			<input type="hidden" name="form" value="save"/>
			
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
				label="Data da Dívida:" 
				id="labelDate" /> </br>
				
			<input type="submit" value="Salvar"/>
		</form>
		</br>
		<c:import url="footer.jsp" />
	</body>
	<script src="jquery-3.7.1.min.js"></script>
	<script src="jquery.maskMoney.min.js"></script>
	<script src="js/masks.js"></script>
</html>