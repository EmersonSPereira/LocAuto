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
				<form:input class="form-control" path="plano" />
			</div>
			<div class="form-group">
				<form:label path="veiculos">Veiculos:</form:label>
				<form:input class="form-control" path="veiculos" />
			</div>
			<div class="form-group">
				<form:label path="cilindradas">Cilindradas:</form:label>
				<form:input class="form-control" path="cilindradas" />
			</div>
			<div class="form-group">
				<form:label path="acessorios">Acessórios:</form:label>
				<form:input class="form-control" path="acessorios" />
			</div>
			<button type="submit" class="btn btn-success">Salvar</button>

		</form:form>

	</div>





</body>
</html>
