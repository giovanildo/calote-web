<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<jsp:useBean id="dao" class="br.triadworks.javaweb.dao.CaloteiroDAO"/>
<html>
<head>
<title>Lista de Caloteiros</title>
</head>
<body>
<c:import url="cabecalho.jsp" />
<table border="1">
	<c:forEach var="caloteiro" items="${dao.lista}" varStatus="id">
	   <tr bgcolor="#${id.count % 2 == 0 ? 'ff0000' : 'ffffff' }"> 
	   		<td>${id.count}</td> 
	   		<c:choose>
		   		<c:when test="${not empty caloteiro.nome}">
		   				<td>${caloteiro.nome}</td>
		   		</c:when>
		   		<c:otherwise>
		   			E-mail não preenchido.
		   		</c:otherwise>
	   		</c:choose>
	   		<c:choose>
		   		<c:when test="${not empty caloteiro.email}">
		   				<td><a href="mailto:${caloteiro.email}">${caloteiro.email}</a></td>
		   		</c:when>
		   		<c:otherwise>
		   			E-mail não preenchido.
		   		</c:otherwise>
	   		</c:choose>
	   		<c:choose>
		   		<c:when test="${not empty caloteiro.devendo}">
		   				<td>${caloteiro.devendo}</td>
		   		</c:when>
		   		<c:otherwise>
		   			Campo devendo não preenchido.
		   		</c:otherwise>
	   		</c:choose>
	   		<c:choose>
		   		<c:when test="${not empty caloteiro.dataDivida}">
		   				<td>
		   					<fmt:formatDate value="${caloteiro.dataDivida.time}" pattern="dd/MM/yyyy" />
		   				</td>
		   		</c:when>
		   		<c:otherwise>
		   			Data da dívida não preenchido.
		   		</c:otherwise>
	   		</c:choose>
	   </tr>
	</c:forEach>
</table>
<c:import url="rodape.jsp" />
</body>
</html>