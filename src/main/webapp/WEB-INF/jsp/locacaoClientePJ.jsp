<!DOCTYPE html>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="ISO-8859-1">

<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap.min.css"/>">
<script src="<c:url value="/resources/js/jquery-3.3.1.min.js "/>"></script>
<script src="<c:url value="/resources/js/bootstrap.js "/>"></script>

<title>Locação Carro</title>
</head>
<body>

	<div>
		<jsp:include page="navBar.jsp" />
	</div>

	<div class="container">
		<h1>Locação de Veiculo para Pessoa Fisica</h1>
	</div>
	<br>
	<br>
	<form:form method="post" action="locacaoClientePJ/salvar"
		modelAttribute="locacao">

		<div class="container">
			<div class="form-row">
				<div class="form-group col-md-6">
				
					<label>Escolha um Cliente</label>

					<form:select class="form-control" path="clientePJ.id">
						<c:forEach items="${listaClientes }" var="cliente">
							<form:option value="${cliente.id}">${cliente.nomeFantasia}</form:option>
						</c:forEach>

					</form:select>
				</div>


				<div class="form-group col-md-6">
				
					<label >Escolha um Locador</label>
					<form:select class="form-control" path="locador.id">
						<c:forEach items="${listaLocadores }" var="locador">
							<form:option value="${locador.id}">${locador.nome}</form:option>
						</c:forEach>

					</form:select>
				</div>
			</div>
		</div>

		<div class="container">
			<div class="form-group">
			
				<label >Escolha um Veículo</label>
				<form:select class="form-control" path="veiculo.id">
					<c:forEach items="${listaVeiculos }" var="veiculo">
						<form:option value="${veiculo.id}">Tipo Veículo: ${veiculo.tipo} , Modelo:
							${veiculo.modelo}</form:option>
					</c:forEach>

				</form:select>
				<label >M = Motocicleta C = Carro</label>
			</div>
		</div>

		<div class="container">
			<div class="form-group">
				<label >Escolha um Plano</label>
				<form:select class="form-control" path="plano.id">
					<c:forEach items="${listaPlanos }" var="plano">
						<form:option value="${plano.id}">Tipo: ${plano.tipo} Veículo: ${plano.veiculos}</form:option>
					</c:forEach>

				</form:select>
				<label >PC = Plano Carro, PM = Plano Motocicleta</label>
			</div>
		</div>

		<div class="container">
			<div class="form-group">
				<form:label path="seguro">Escolha um Seguro</form:label>
				<form:select path="seguro" class="form-control" >

					<form:option value="Nenhum">Nenhum</form:option>
					<form:option value="Parcial">Cobertura parcial : arranhões, amassados leves,
						acessórios danificados</form:option>
					<form:option value="Total">Cobertura total: roubo e perda total do veículo.</form:option>

				</form:select>

			</div>
		</div>
		<div class="container">
			<button type="submit" class="btn btn-success">Realizar
				Locação</button>
			<br>
			<br>
			<br>
		</div>
	</form:form>


</body>
</html>