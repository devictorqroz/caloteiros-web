<%@ include file="/includes.jsp" %>
<html>
	<head>
		<title>Adiciona caloteiro</title>
	</head>
	<body>
		<c:import url="header.jsp" />
		</br>
		</br>
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
				label="Data da D�vida:" 
				id="labelDate" /> </br>
				
			<input type="submit" value="Salvar"/>
		</form>
		</br>
		<c:import url="footer.jsp" />
	</body>
</html>