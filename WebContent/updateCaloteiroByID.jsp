<%@ include file="/includes.jsp" %>
<html>
	<head>
		<title>Edita caloteiro</title>
	</head>
	<body>
		<c:import url="cabecalho.jsp" />
		</br>
		</br>
		<form action="system" method="post">
			<input type="hidden" name="logica" value="IncludeCaloteiro" />
			<input type="hidden" name="update" value="true"/>
			<input type="hidden" name="id" value="${caloteiro.id}"/>
			
			<label for="idForm">ID:</label>
			<input type="text" id="idForm" value="${caloteiro.id}" /> </br>
			<triadTag:campoTexto 
				campoName="name" 
				label="Nome:" 
				id="labelName"
				value="${caloteiro.name}"
			/> </br>
			<triadTag:campoTexto 
				campoName="email" 
				label="Email:" 
				id="labelEmail" 
				value="${caloteiro.email}"
			/> </br>	
			<triadTag:campoTexto 
				campoName="debt" 
				label="Devendo:" 
				id="labelDebt" 
				value="${caloteiro.debt}"
			/> </br>
			<fmt:formatDate value="${caloteiro.debtDate.time}"
				pattern="dd/MM/yyyy" var="dateFormatted" />
			<triadTag:campoTexto 
				campoName="debtDate" 
				label="Data da Dívida:" 
				id="labelDate" 
				value="${dateFormatted}"
			/> </br>
			
			<input type="submit" value="Salvar"/>
		</form>
		</br>
		<c:import url="rodape.jsp" />
	</body>
</html>