<%@ include file="/includes.jsp" %>
<html>
	<head>
		<title>Edita caloteiro</title>
		<link rel="stylesheet" type="text/css" href="css/update-caloteiro.css">
	</head>
	<body>
		<header>
			<c:import url="header.jsp" />
		</header>
		<main>
			<p>
				Usuário Logado: ${authenticatedUser.name}
			</p>
			<form action="system" method="post" id="formUpdate">
				<input type="hidden" name="logica" value="IncludeCaloteiro"/>
				<input type="hidden" name="form" value="update"/>
				<input type="hidden" name="id" value="${caloteiro.id}"/>
			
				<triadTag:textField 
					nameField="name" 
					label="Nome:" 
					id="labelName"
					value="${caloteiro.name}" /> 
				<triadTag:textField 
					nameField="email" 
					label="Email:" 
					id="labelEmail" 
					value="${caloteiro.email}" /> 
				<triadTag:textField 
					nameField="debt" 
					label="Devendo:" 
					id="labelDebt" 
					value="${caloteiro.debt}" />
				<fmt:formatDate value="${caloteiro.debtDate.time}"
					pattern="dd/MM/yyyy" var="dateFormatted" />
				<triadTag:textField 
					nameField="debtDate" 
					label="Data da Dívida:" 
					id="labelDate" 
					value="${dateFormatted}" />
				
				<input type="submit" value="Atualizar"/>
			</form>
		</main>
		<footer>
			<c:import url="footer.jsp" />
		</footer>
	</body>
</html>