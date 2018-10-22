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
		<h2>Cadastro veículo: Carro</h2>

	</div>

	<div class="container">
		<form:form method="post" action="salvaVeiculoC.html"
			modelAttribute="veiculoC">

			<div class="form-group">
				<form:input type="hidden" class="form-control" path="id" />
			</div>

			<div class="form-group">
				<form:label path="renavam">Renavam:</form:label>
				<form:input required="true" class="form-control" path="renavam" />
			</div>
			<div class="form-group">
				<form:label path="modelo">Modelo:</form:label>
				<form:input required="true" class="form-control" path="modelo" />
			</div>
			<div class="form-group">
				<form:label path="marca">Marca:</form:label>
				<form:select path="marca" class="form-control">

					<form:option value="Chevrolet">Chevrolet</form:option>
					<form:option value="Fiat">Fiat</form:option>
					<form:option value="Volkswagen">Volkswagen</form:option>
					<form:option value="Ford">Ford</form:option>
					<form:option value="Hyundai">Hyundai</form:option>
					<form:option value="Toyota">Toyota</form:option>
					<form:option value="Renault">Renault</form:option>
					<form:option value="Honda">Honda</form:option>
					<form:option value="Nissan">Nissan</form:option>
					<form:option value="Kia">Kia</form:option>
					<form:option value="Mercedes-Benz">Mercedes-Benz</form:option>
					<form:option value="Peugeot">Peugeot</form:option>
					<form:option value="BMW">BMW</form:option>
					<form:option value="Audi">Audi</form:option>
					<form:option value="Suzuki">Suzuki</form:option>




				</form:select>

			</div>

			<div class="form-group">
				<form:label path="potencia">Potência:</form:label>
				<form:select path="potencia" class="form-control">

					<form:option value="1.0">1.0</form:option>
					<form:option value="1.4">1.4</form:option>
					<form:option value="1.6">1.6</form:option>
					<form:option value="1.8">1.8</form:option>
					<form:option value="2.0">1.8</form:option>



				</form:select>
			</div>
			
			<div class="form-group">
				<form:label path="ano">Ano:</form:label>
				<form:input required="true" class="form-control" path="ano"
					placeholder="digite o ano com 4 dígitos, ex:1999" />
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
					<form:option value="Disel">Disel</form:option>
					<form:option value="Gás Natural">Gás Natural</form:option>
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
				<form:label path="acessorios">Acessórios:</form:label>
				<form:select path="acessorios" class="form-control">

					<form:option value="Nenhum">Nenhum</form:option>
					<form:option value="Ar Condicionado">Ar Condicionado</form:option>
					<form:option value="Vidro Eletrico">Vidro Eletrico</form:option>
					<form:option value="Ar Condicionado e Vidro Eletrico">Ar Condicionado e Vidro Eletrico</form:option>



				</form:select>
			</div>

			<button type="submit" class="btn btn-success">Salvar</button>

		</form:form>

	</div>






</body>
</html>