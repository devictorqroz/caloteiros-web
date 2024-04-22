<%@ include file="/includes.jsp" %>
<html>
	<head>
		<title>Adiciona caloteiro</title>
	</head>
	<body>
		<c:import url="header.jsp" />
		<hr>
			Usu�rio logado: ${authenticatedUser.name}
		<hr>
		<form action="system" method="post" id="formInclude">
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
				label="Data da D�vida:" 
				id="labelDate" /> </br>
				
			<input type="submit" value="Salvar"/>
		</form>
		</br>
		<c:import url="footer.jsp" />
	</body>
	<script src="js/jquery-3.7.1.min.js"></script>
	<script src="js/jquery.maskMoney.min.js"></script>
	<script src="js/jquery.validate.min.js"></script>
	<script src="js/jquery.inputmask.min.js"></script>
	<script src="js/masks.js"></script>
</html>