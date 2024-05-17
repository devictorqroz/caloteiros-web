<%@ include file="/includes.jsp" %>
<html>
	<head>
		<title>Adiciona Caloteiro</title>
		<link rel="stylesheet" type="text/css" href="css/include-caloteiro.css">
	</head>
	<body>
		<header>
			<c:import url="header.jsp" />
		</header>
		<main>
			<p>
				Usuário Logado: ${authenticatedUser.name}
			</p>
			<form action="system" method="post" id="formInclude">
				<input type="hidden" name="logica" value="IncludeCaloteiro"/>
				<input type="hidden" name="form" value="include"/>
				
				<triadTag:textField 
					nameField="name" 
					label="Nome:" 
					id="labelName" /> 
				<triadTag:textField 
					nameField="email" 
					label="Email:" 
					id="labelEmail" />
				<triadTag:textField 
					nameField="debt" 
					label="Devendo:" 
					id="labelDebt" />
				<triadTag:textField 
					nameField="debtDate" 
					label="Data da Dívida:" 
					id="labelDate" />
					
				<input type="submit" value="Cadastrar" />
			</form>
		</main>
		<footer>
			<c:import url="footer.jsp" />
		</footer>
	</body>
<!-- 	<script src="javascript/jquery-3.7.1.min.js"></script> -->
<!-- 	<script src="javascript/jquery.maskMoney.min.js"></script> -->
<!-- 	<script src="javascript/jquery.inputmask.min.js"></script> -->
<!-- 	<script src="javascript/jquery.validate.min.js"></script> -->
<!-- 	<script src="javascript/masks.js"></script> -->
</html>