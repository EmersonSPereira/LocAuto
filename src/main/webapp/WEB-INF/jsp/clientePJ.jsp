<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Cadastro de cliente</title>
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
		<h2>Cadastro cliente pessoa jurídica</h2>
	</div>
	<div class="container">
		<form:form method="post" action="salvaClientePJ.html"
			modelAttribute="clientePJ">

			<div class="form-group">
				<form:input type="hidden" class="form-control" path="id" />
			</div>

			<div class="form-group">
				<form:label path="nomeFantasia">Nome Fantasia:</form:label>
				<form:input class="form-control" path="nomeFantasia" />
			</div>
			<div class="form-group">
				<form:label path="razaoSocial">Razão Social:</form:label>
				<form:input class="form-control" path="razaoSocial" />
			</div>
			<div class="form-group">
				<form:label path="cnpj">CNPJ:</form:label>
				<form:input class="form-control" path="cnpj" />
			</div>
			<div class="form-group">
				<form:label path="inscEstadual">Inscrição Estadual:</form:label>
				<form:input class="form-control" path="inscEstadual" />
			</div>
			<div class="form-group">
				<form:label path="endereco">Endereco:</form:label>
				<form:input class="form-control" path="endereco" />
			</div>
			<div class="form-group">
				<form:label path="telefone">Telefone:</form:label>
				<form:input class="form-control" path="telefone" />
			</div>
			<div class="form-group">
				<form:label path="email">Email:</form:label>
				<form:input class="form-control" path="email" />
			</div>
			<button type="submit" class="btn btn-success">Salvar</button>

		</form:form>

	</div>






</body>
</html>