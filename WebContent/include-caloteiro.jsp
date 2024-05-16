<%@ include file="/includes.jsp" %>
<html>
	<head>
		<title>Adiciona Caloteiro</title>
	</head>
	<body>
		<c:import url="header.jsp" />
		<hr>
			Usuário Logado: ${authenticatedUser.name}
		<hr>
		<form action="system" method="post" id="formInclude">
			<input type="hidden" name="logica" value="IncludeCaloteiro"/>
			<input type="hidden" name="form" value="include"/>
			
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
				
			<input type="submit" value="Salvar" />
		</form>
		<hr>
		<c:import url="footer.jsp" />
	</body>
	<script src="javascript/jquery-3.7.1.min.js"></script>
	<script src="javascript/jquery.maskMoney.min.js"></script>
	<script src="javascript/jquery.validate.min.js"></script>
	<script src="javascript/jquery.inputmask.min.js"></script>
	<script src="javascript/masks.js"></script>
</html>