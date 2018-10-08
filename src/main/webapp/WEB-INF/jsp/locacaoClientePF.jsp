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

<title>Loca��o Carro</title>
</head>
<body>

	<div>
		<jsp:include page="navBar.jsp" />
	</div>

	<div class="container">
		<h1>Loca��o de Veiculo para Pessoa Fisica</h1>
	</div>
	<br>
	<br>
	<form:form>

		<div class="container">
			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="exampleFormControlSelect1">Escolha um Cliente</label> <select
						class="form-control" id="exampleFormControlSelect1">
						<c:forEach items="${listaClientes }" var="cliente">
							<option>${cliente.nome}</option>
						</c:forEach>

					</select>
				</div>


				<div class="form-group col-md-6">
					<label for="exampleFormControlSelect1">Escolha um Locador</label> <select
						class="form-control" id="exampleFormControlSelect1">
						<c:forEach items="${listaLocadores }" var="locador">
							<option>${locador.nome}</option>
						</c:forEach>

					</select>
				</div>
			</div>
		</div>

		<div class="container">
			<div class="form-group">
				<label for="exampleFormControlSelect1">Escolha um Ve�culo</label> <select
					class="form-control" id="exampleFormControlSelect1">
					<c:forEach items="${listaVeiculos }" var="veiculo">
						<option>Tipo Ve�culo: ${veiculo.tipo} , Modelo:
							${veiculo.modelo}</option>
					</c:forEach>

				</select> <label>M = Motocicleta C = Carro</label>
			</div>
		</div>

		<div class="container">
			<div class="form-group">
				<label for="exampleFormControlSelect1">Escolha um Plano</label> <select
					class="form-control" id="exampleFormControlSelect1">
					<c:forEach items="${listaPlanos }" var="plano">
						<option>Tipo: ${plano.tipo} Ve�culo: ${plano.veiculos}</option>
					</c:forEach>

				</select> <label>PC = Plano Carro, PM = Plano Motocicleta</label>
			</div>
		</div>

		<div class="container">
			<div class="form-group">
				<label for="exampleFormControlSelect1">Escolha um Seguro</label> <select
					class="form-control" id="exampleFormControlSelect1">

					<option>Nenhum</option>
					<option>Cobertura parcial : arranh�es, amassados leves,
						acess�rios danificados</option>
					<option>Cobertura total: roubo e perda total do ve�culo.</option>

				</select>

			</div>
		</div>
		<div class="container">
			<button type="submit" class="btn btn-success">Realizar
				Loca��o</button><br><br><br>
		</div>
	</form:form>


</body>
</html>