<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Cadastro de planos</title>

<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<script src="resources/js/jquery-3.3.1.min.js" type="text/javascript"></script>
<script src="resources/js/bootstrap.min.js" type="text/javascript"></script>
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
			<button type="submit" class="btn btn-success">Salvar</button>

		</form:form>

	</div>







</body>
</html>
