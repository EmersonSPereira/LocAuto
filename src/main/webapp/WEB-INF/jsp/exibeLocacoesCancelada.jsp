<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Locações</title>

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
	<h1>Locações Canceladas</h1><br><br>
		<h3>Locacações Cliente PF</h3>
	</div>
	<c:if test="${!empty locacoesListPF}">
		<div class="container">
			<table class="table table-striped table-dark">
				<tr>
					<th scope="col">Cliente</th>
					<th scope="col">Locador</th>
					<th scope="col">Veiculo</th>
					<th scope="col">Plano</th>
					<th scope="col">Seguro</th>
					<th scope="col">Data de Locação</th>
					<th scope="col">Data de Entrega</th>
					<th scope="col">Nível do Tanque</th>
					<th scope="col">Valor Total</th>
					<th scope="col">Situação</th>
					<th scope="col">Status Locacão</th>
					
					


				</tr>

				<c:forEach items="${locacoesListPF}" var="locacao">
					<tr>
						<td>${locacao.clientePF.nome}</td>
						<td>${locacao.locador.nome}</td>
						<td>${locacao.veiculo.modelo}</td>
						<td>${locacao.plano.plano}</td>
						<td>${locacao.seguro}</td>
						<td>${locacao.dataLocacao}</td>
						<td>${locacao.dataDevolucao}</td>
						<td>${locacao.nivelDoTanque}</td>
						<td>${locacao.valorTotalLocacao}</td>
						<td>${locacao.situacao}</td>
						<td>${locacao.status}</td>
						
					</tr>
				</c:forEach>
			</table>
		</div>

	</c:if>


	<div class="container">
		<h3>Locacações Cliente PJ</h3>
	</div>
	<c:if test="${!empty locacoesListPJ}">
		<div class="container">
			<table class="table table-striped table-dark">
				<tr>
					<th scope="col">Cliente</th>
					<th scope="col">Locador</th>
					<th scope="col">Veiculo</th>
					<th scope="col">Plano</th>
					<th scope="col">Seguro</th>
					<th scope="col">Data de Locação</th>
					<th scope="col">Data de Entrega</th>
					<th scope="col">Nível do Tanque</th>
					<th scope="col">Situação</th>
					

				</tr>

				<c:forEach items="${locacoesListPJ}" var="locacao">
					<tr>
						<td>${locacao.clientePJ.nomeFantasia}</td>
						<td>${locacao.locador.nome}</td>
						<td>${locacao.veiculo.modelo}</td>
						<td>${locacao.plano.plano}</td>
						<td>${locacao.seguro}</td>
						<td>${locacao.dataLocacao}</td>
						<td>${locacao.dataDevolucao}</td>
						<td>${locacao.nivelDoTanque}</td>
						<td>${locacao.situacao}</td>

						
					</tr>
				</c:forEach>
			</table>
		</div>

	</c:if>


</body>
</html>