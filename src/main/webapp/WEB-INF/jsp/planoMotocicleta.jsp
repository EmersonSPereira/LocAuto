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
		<h2>Cadastro novo plano: Motocicleta</h2>
	</div>

	<div class="container">
		<form:form method="post" action="salvaPlanoM.html"
			modelAttribute="planoM">

			<div class="form-group">
				<form:input type="hidden" class="form-control" path="id" />
			</div>

			<div class="form-group">
				<form:label path="plano">Plano:</form:label>
				<form:input type="text" requiered="true" class="form-control"
					path="plano"
					placeholder="Digite uma Letra de A-Z para nomear o plano"
					maxlength="1" />
			</div>
			<div class="form-group">
				<form:label path="veiculos">Veiculos:</form:label>
				<form:input requiered="true" class="form-control" path="veiculos"
					placeholder="Digite os veículos inclusos neste plano, ex: Titã, Fan, XRE300, etc." />
			</div>
			<div class="form-group">
				<form:label path="cilindradas">Cilindradas das Motocicletas inclusas no plano:</form:label>
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
				<form:label path="valorDiaria">Valor Diária:</form:label>
				<form:input requiered="true" type="number" class="form-control"
					path="valorDiaria" placeholder="R$" />
			</div>
			<button type="submit" class="btn btn-success">Salvar</button>

		</form:form>

	</div>







</body>
</html>
