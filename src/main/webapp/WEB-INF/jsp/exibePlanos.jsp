<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Planos Carro</title>

<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<script src="<c:url value="resources/js/jquery-3.3.1.min.js "/>"></script>
<script src="<c:url value="resources/js/bootstrap.js "/>"></script>
</head>
<body>

	<div>
		<jsp:include page="navBar.jsp" />
	</div>
	<div class="container">
		<h1>Planos Carro</h1>
	</div>
	<c:if test="${!empty listaPlanosC}">

		<div class="container">
			<table class="table table-striped table-dark">
				<tr>
					<th scope="col">Plano</th>
					<th scope="col">Veiculos</th>
					<th scope="col">Cilindradas</th>
					<th scope="col">Acessórios</th>
					<th scope="col">&nbsp;</th>
				</tr>
				<c:forEach items="${listaPlanosC}" var="plano">

					<tr>
						<td>${plano.plano}</td>
						<td>${plano.veiculos}</td>
						<td>${plano.cilindradas}</td>
						<td>${plano.acessorios}</td>

						<td><a href="deletePlano/${plano.id}"
							class="badge badge-danger">delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</c:if>

	<div class="container">
		>
		<h1>Planos Motocicleta</h1>
	</div>
	<c:if test="${!empty listaPlanosM}">

		<div class="container">
			<table class="table table-striped table-dark">
				<tr>
					<th scope="col">Plano</th>
					<th scope="col">Veiculos</th>
					<th scope="col">Cilindradas</th>
					<th scope="col">&nbsp;</th>
				</tr>
				<c:forEach items="${listaPlanosM}" var="plano">

					<tr>
						<td>${plano.plano}</td>
						<td>${plano.veiculos}</td>
						<td>${plano.cilindradas}</td>

						<td><a href="deletePlano/${plano.id}"
							class="badge badge-danger">delete</a></td>

					</tr>
				</c:forEach>
			</table>
		</div>
	</c:if>


</body>
</html>