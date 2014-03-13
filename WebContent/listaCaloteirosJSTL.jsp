<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="dao" class="br.triadworks.javaweb.dao.CaloteiroDAO"/>
<html>
<head>
<title>Lista de Caloteiros</title>
</head>
<body>
<table border="1">
	<c:forEach var="caloteiro" items="${dao.lista}" varStatus="id">
	   <tr bgcolor="#${id.count % 2 == 0 ? 'ff0000' : 'ffffff' }"> 
	   		<td>${id.count}</td> <td>${caloteiro.nome}</td> 
	   </tr>
	</c:forEach>
</table>
</body>
</html>