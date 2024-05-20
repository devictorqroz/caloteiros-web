<%@ include file="/includes.jsp" %>
<html>
	<head>
		<title>Adiciona Caloteiro</title>
		<link rel="stylesheet" type="text/css" href="css/include-caloteiro.css">
		<script src="javascript/jquery-3.7.1.min.js" defer></script>
		<script src="javascript/jquery.maskMoney.min.js" defer></script>
		<script src="javascript/jquery.inputmask.min.js" defer></script>
		<script src="javascript/jquery.validate.min.js" defer></script>
		<script src="javascript/masks.js" defer></script>
	</head>
	<body>
		<header>
			<c:import url="header.jsp" />
			<h1>Caloteiros</h1>
		</header>
		<main>
			<p>
				Usu�rio Logado: ${authenticatedUser.name}
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
					label="Data da D�vida:" 
					id="labelDate" />
					
				<input type="submit" value="Cadastrar" />
			</form>
			<a href="menu.jsp" class="menu-link">Retornar ao Menu</a>
		</main>
		<footer>
			<c:import url="footer.jsp" />
		</footer>
	</body>
</html>