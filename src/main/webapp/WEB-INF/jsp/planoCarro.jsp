<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Cadastro de planos</title>

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
		<h2>Cadastro novo plano: Carro</h2>
	</div>

	<div class="container">
		<form:form method="post" action="salvaPlanoC.html"
			modelAttribute="planoC">

			<div class="form-group">
				<form:input type="hidden" class="form-control" path="id" />
			</div>

			<div class="form-group">
				<form:label path="plano">Plano:</form:label>
				<form:input type="text" requiered="true" class="form-control" path="plano" placeholder="Digite uma Letra de A-Z para nomear o plano" maxlength="1" />
			</div>
			<div class="form-group">
				<form:label path="veiculos">Veiculos:</form:label>
				<form:input requiered="true" class="form-control" path="veiculos" placeholder="Digite os veículos inclusos neste plano, ex: Prisma, Fox, Uno, etc." />
			</div>
			<div class="form-group">
				<form:label path="potencia">Potência dos veículos inclusos no plano:</form:label>
				<form:select path="potencia" class="form-control">

					<form:option value="1.0">1.0</form:option>
					<form:option value="1.4">1.4</form:option>
					<form:option value="1.6">1.6</form:option>
					<form:option value="1.8">1.8</form:option>
					<form:option value="2.0">1.8</form:option>



				</form:select>
			</div>
			<div class="form-group">
				<form:label path="acessorios">Acessórios:</form:label>
				<form:input requiered="true" class="form-control" path="acessorios" placeholder="Digite os acessórios dos carros inclusos nos planos, ex:Ar Condicionado, Vidro Eletrico, etc." />
			</div>
			
			<div class="form-group">
				<form:label path="valorDiaria">Valor Diária:</form:label>
				<form:input requiered="true" type="number" class="form-control" path="valorDiaria" placeholder="R$" />
			</div>
			<button type="submit" class="btn btn-success">Salvar</button>

		</form:form>

	</div>





</body>
</html>
