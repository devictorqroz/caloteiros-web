<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Lista de Caloteiros</title>
	</head>
	<body>
		<jsp:useBean id="dao" class="br.triadworks.javaweb.dao.CaloteiroDAO"/>
		Lista de Caloteiros: </br>
		
		
		<table border="1">
			<c:forEach var="caloteiro" items="${dao.list}" varStatus="id">
				<tr bgcolor="#${id.count % 2 == 0 ? 'ff0000' : 'ffffff' }">
					<td>${id.count}</td> <td>${caloteiro.name}</td>
				</tr>
			</c:forEach>
		</table>
		
	</body>
</html>