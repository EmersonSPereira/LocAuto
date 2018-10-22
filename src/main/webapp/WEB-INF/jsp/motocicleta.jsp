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
				<form:input required="true" class="form-control" path="renavam"  />
			</div>
			<div class="form-group">
				<form:label path="modelo">Modelo:</form:label>
				<form:input required="true" class="form-control" path="modelo" />
			</div>
			<div class="form-group">
				<form:label path="marca">Marca:</form:label>
				<form:select path="marca" class="form-control">

					<form:option value="Honda">Honda</form:option>
					<form:option value="Yamaha">Yamaha</form:option>
					<form:option value="Suzuki">Suzuki</form:option>
					<form:option value="Dafra">Dafra</form:option>
					<form:option value="Shineray">Shineray</form:option>
					<form:option value="Kawasaki">Kawasaki</form:option>
					<form:option value="Harley Davidson">Harley Davidson</form:option>
					<form:option value="Traxx">Traxx</form:option>


				</form:select>

			</div>
			
			<div class="form-group">
				<form:label path="ano">Ano:</form:label>
				<form:input required="true" class="form-control" path="ano"
					placeholder="Ano com 4 digitos Ex: 2005" maxlength="4" />
			</div>
			<div class="form-group">
				<form:label path="cor">Cor:</form:label>
				<form:select path="cor" class="form-control">

					<form:option value="Prata">Prata</form:option>
					<form:option value="Preto">Preto</form:option>
					<form:option value="Cinza">Cinza</form:option>
					<form:option value="Branco">Branco</form:option>
					<form:option value="Vermelho">Vermelho</form:option>
					<form:option value="Azul">Azul</form:option>
					<form:option value="Verde">Verde</form:option>
					<form:option value="Bege">Bege</form:option>
					<form:option value="Amarelo">Amarelo</form:option>
					<form:option value="Laranja">Laranja</form:option>
					<form:option value="Marrom">Marrom</form:option>

				</form:select>

			</div>
			<div class="form-group">
				<form:label path="tipoCombustivel">Tipo Combustivél:</form:label>
				<form:select path="tipoCombustivel" class="form-control">

					<form:option value="Alcool">Alcool</form:option>
					<form:option value="Gasolina">Gasolina</form:option>
					<form:option value="Flex">Flex</form:option>

				</form:select>

			</div>

			<div class="form-group">

				<label>Escolha uma Agência:</label>

				<form:select class="form-control" path="agencia.id">
					<c:forEach items="${agenciasList }" var="agencia">
						<form:option value="${agencia.id}">${agencia.localidade}</form:option>
					</c:forEach>
				</form:select>
			</div>



			<div class="form-group">
				<form:label path="cilindradas">Cilindradas:</form:label>
				<form:select path="cilindradas" class="form-control">

					<form:option value="50">50CC</form:option>
					<form:option value="100">100CC</form:option>
					<form:option value="125">125CC</form:option>
					<form:option value="150">150CC</form:option>
					<form:option value="160">160CC</form:option>
					<form:option value="190">190CC</form:option>
					<form:option value="250">250CC</form:option>
					<form:option value="300">300CC</form:option>
					<form:option value="600">600CC</form:option>
					<form:option value="750">750CC</form:option>
					<form:option value="900">900CC</form:option>
					<form:option value="1000">1000CC</form:option>
					<form:option value="1100">1100CC</form:option>
					<form:option value="1200">1200CC</form:option>



				</form:select>

			</div>


			<div class="form-group">
				<form:label path="freios">Freios:</form:label>
				<form:select path="freios" class="form-control">

					<form:option value="Disco">Disco</form:option>
					<form:option value="ABS">ABS</form:option>

				</form:select>

			</div>

			<button type="submit" class="btn btn-success">Salvar</button>
		</form:form>

	</div>





</body>
</html>
