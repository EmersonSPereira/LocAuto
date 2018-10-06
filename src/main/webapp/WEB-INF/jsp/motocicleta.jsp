<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Cadastro de veículo</title>

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

		<h2>Cadastro veículo: Motocicleta</h2>

	</div>

	<div class="container">
		<form:form method="post" action="salvaVeiculoM.html"
			modelAttribute="veiculoM">

			<div class="form-group">
				<form:input type="hidden" class="form-control" path="id" />
			</div>

			<div class="form-group">
				<form:label path="renavam">Renavam:</form:label>
				<form:input class="form-control" path="renavam" />
			</div>
			<div class="form-group">
				<form:label path="modelo">Modelo:</form:label>
				<form:input class="form-control" path="modelo" />
			</div>
			<div class="form-group">
				<form:label path="marca">Marca:</form:label>
				<form:input class="form-control" path="marca" />
			</div>
			<div class="form-group">
				<form:label path="potencia">Potência:</form:label>
				<form:input class="form-control" path="potencia" />
			</div>
			<div class="form-group">
				<form:label path="ano">Ano:</form:label>
				<form:input class="form-control" path="ano" />
			</div>
			<div class="form-group">
				<form:label path="cor">Cor:</form:label>
				<form:input class="form-control" path="cor" />
			</div>
			<div class="form-group">
				<form:label path="tipoCombustivel">Tipo Combustivel:</form:label>
				<form:input class="form-control" path="tipoCombustivel" />
			</div>
			<div class="form-group">
				<form:label path="agencia">Agência:</form:label>
				<form:input class="form-control" path="agencia" />
			</div>
			<div class="form-group">
				<form:label path="cilindradas">Cilindradas:</form:label>
				<form:input class="form-control" path="cilindradas" />
			</div>
			<div class="form-group">
				<form:label path="freios">Freios:</form:label>
				<form:input class="form-control" path="freios" />
			</div>
			<button type="submit" class="btn btn-success">Salvar</button>

		</form:form>

	</div>





</body>
</html>
