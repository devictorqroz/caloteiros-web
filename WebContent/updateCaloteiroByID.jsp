<%@ include file="/includes.jsp" %>
<html>
	<head>
		<title>Edita caloteiro</title>
	</head>
	<body>
		<c:import url="header.jsp" />
		</br>
		</br>
		<form action="system" method="post">
			<input type="hidden" name="logica" value="IncludeCaloteiro" />
			<input type="hidden" name="form" value="update"/>
			<input type="hidden" name="id" value="${caloteiro.id}"/>
			
			<label for="idForm">ID:</label>
			<input type="text" id="idForm" value="${caloteiro.id}" /> </br>
			<triadTag:textField 
				nameField="name" 
				label="Nome:" 
				id="labelName"
				value="${caloteiro.name}"
			/> </br>
			<triadTag:textField 
				nameField="email" 
				label="Email:" 
				id="labelEmail" 
				value="${caloteiro.email}"
			/> </br>	
			<triadTag:textField 
				nameField="debt" 
				label="Devendo:" 
				id="labelDebt" 
				value="${caloteiro.debt}"
			/> </br>
			<fmt:formatDate value="${caloteiro.debtDate.time}"
				pattern="dd/MM/yyyy" var="dateFormatted" />
			<triadTag:textField 
				nameField="debtDate" 
				label="Data da Dívida:" 
				id="labelDate" 
				value="${dateFormatted}"
			/> </br>
			
			<input type="submit" value="Salvar"/>
		</form>
		</br>
		<c:import url="footer.jsp" />
	</body>
</html>