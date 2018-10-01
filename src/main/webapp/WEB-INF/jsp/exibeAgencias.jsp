<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Agências</title>

<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<script src="<c:url value="resources/js/jquery-3.3.1.min.js "/>"></script>
<script src="<c:url value="resources/js/bootstrap.js "/>"></script>
</head>
<body>

	<div>
		<jsp:include page="navBar.jsp" />
	</div>
	
	<div class="container">
		<h1>Agências</h1>
	</div>
	<c:if test="${!empty agenciaList}">
		<div class="container">
			<table class="table table-striped table-dark">
				<tr>
					<th scope="col">CNPJ</th>
					<th scope="col">Inscrição Estadual</th>
					<th scope="col">Gerente Responsavel</th>
					<th scope="col">Telefone</th>
					<th scope="col">Ação</th>
				</tr>

				<c:forEach items="${agenciaList}" var="agencia">
					<tr>
						<td>${agencia.cnpj}</td>
						<td>${agencia.inscEstadual}</td>
						<td>${agencia.gerenteResponsavel}</td>
						<td>${agencia.telefone}</td>
						<td><a href="delete/${agencia.id}" class="badge badge-danger">delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>

	</c:if>


	<div class="container">
		<a href="agencia" class="badge badge-primary">Cadastro Agência</a> <a
			href="/LocAuto/" class="badge badge-primary">Home</a>

	</div>

</body>
</html>