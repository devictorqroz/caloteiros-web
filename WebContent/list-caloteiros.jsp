<%@ include file="/includes.jsp" %>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Lista de Caloteiros</title>
	</head>
	<body>
		<c:import url="header.jsp" />
		<hr>
		Lista de Caloteiros: 
		<hr>
		
		<table border="1">
			<tr><th>ID</th><th>Nome</th><th>Email</th><th>Devendo</th><th>Data Dívida</th><th>Editar</th><th>Excluir</th></tr>
			<c:forEach var="caloteiro" items="${caloteiros}" varStatus="id">
				<tr bgcolor="#${id.count % 2 == 0 ? 'ff0000' : 'ffffff' }">
					<td>${caloteiro.id}</td> 
					<c:choose>
						<c:when test="${not empty caloteiro.name}">
							<td>${caloteiro.name}</td>
						</c:when>
						<c:otherwise>
							<td>Nome não preenchido.</td>
						</c:otherwise>
					</c:choose>
					<c:choose>
						<c:when test="${not empty caloteiro.email}">
							<td><a href="#">${caloteiro.email}</a></td>
						</c:when>
						<c:otherwise>
							<td>E-mail não preenchido.</td>
						</c:otherwise>
					</c:choose>
					<c:choose>
						<c:when test="${not empty caloteiro.debt}">
							<td>${caloteiro.debt}</td>
						</c:when>
						<c:otherwise>
							<td>Devendo não preenchido.</td>
						</c:otherwise>
					</c:choose>
					<c:choose>
						<c:when test="${not empty caloteiro.debtDate}">
							<td>
								<fmt:formatDate value="${caloteiro.debtDate.time}"
									pattern="dd/MM/yyyy" />
							</td>
						</c:when>
						<c:otherwise>
							<td>Data dívida não preenchida.</td>
						</c:otherwise>
					</c:choose>
					<td>
						<form action="system" method="post">
							<input type="hidden" name="logica" value="UpdateCaloteiro" />
							<input type="hidden" name="id" value="${caloteiro.id}" />
							<input type="submit" name="updateButton" value="Editar" />
						</form>
					</td>
					<td>
						<form action="system" method="post">
							<input type="hidden" name="logica" value="DeleteCaloteiro" />
							<input type="hidden" name="id" value="${caloteiro.id}" />
							<input type="submit" name="deleteButton" value="Excluir" />
						</form>
					</td>
				</tr>		
			</c:forEach>
		</table>
		<hr>
		<a href='<c:url value="/menu.jsp" />' >
					Menu
		</a>
		<hr>
		<c:import url="footer.jsp" />
	</body>
</html>