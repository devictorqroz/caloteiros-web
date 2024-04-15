<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Lista de Caloteiros</title>
	</head>
	<body>
		<jsp:useBean id="dao" class="br.triadworks.javaweb.dao.CaloteiroDAO"/>
		Lista de Caloteiros: 
		</br>
		</br>
		
		<table border="1">
			<c:forEach var="caloteiro" items="${dao.list}" varStatus="id">
				<tr bgcolor="#${id.count % 2 == 0 ? 'ff0000' : 'ffffff' }">
					<td>${id.count}</td> 
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
							<td><a href="#">${caloteiro.name}</a></td>
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
				</tr>		
			</c:forEach>
		</table>
	</body>
</html>