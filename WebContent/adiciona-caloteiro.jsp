<%@ include file="/includes.jsp" %>
<html>
	<head>
		<title>Adiciona caloteiro</title>
	</head>
	<body>
		<c:import url="cabecalho.jsp" />
		</br>
		</br>
		<form action="system" method="post">
			<input type="hidden" name="resource" value="adicionarCaloteiro" />
			
			<triadTag:campoTexto 
				campoName="name" 
				label="Nome:" 
				id="labelName" /> </br>
			<triadTag:campoTexto 
				campoName="email" 
				label="Email:" 
				id="labelEmail" /> </br>	
			<triadTag:campoTexto 
				campoName="debt" 
				label="Devendo:" 
				id="labelDebt" /> </br>
			<triadTag:campoTexto 
				campoName="debtDate" 
				label="Data da Dívida:" 
				id="labelDate" /> </br>
		
			<input type="submit" value="Salvar"/>
		</form>
		</br>
		<c:import url="rodape.jsp" />
	</body>
</html>