<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Loca��es</title>

<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap.min.css"/>">
<script src="<c:url value="/resources/js/jquery-3.3.1.min.js "/>"></script>
<script src="<c:url value="/resources/js/bootstrap.js "/>"></script>
</head>
<body>

	<div>
		<jsp:include page="navBar.jsp" />
	</div>

	<div class="container">
		<h1>Locaca��es</h1>
	</div>
	<c:if test="${!empty locacoesList}">
		<div class="container">
			<table class="table table-striped table-dark">
				<tr>
					<th scope="col">Cliente</th>
					<th scope="col">Locador</th>
					<th scope="col">Veiculo</th>
					<th scope="col">Plano</th>
					<th scope="col">Seguro</th>
					<th scope="col">Data de Loca��o</th>
					<th scope="col">Data de Entrega</th>
					<th scope="col">A��o</th>

				</tr>

				<c:forEach items="${locacoesList}" var="locacao">
					<tr>
						<td>${locacao.clientePF.nome}</td>
						<td>${locacao.locador.nome}</td>
						<td>${locacao.veiculo.modelo}</td>
						<td>${locacao.plano.plano}</td>
						<td>${locacao.seguro}</td>
						<td>${locacao.dataLocacao}</td>
						<td>${locacao.dataDevolucao}</td>

						<td><a href="#" class="badge badge-success">Finalizar
								Loca��o</a><br>
						<br> <a href="#" class="badge badge-danger">Cancelar
								Locac�o</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>

	</c:if>


</body>
</html>