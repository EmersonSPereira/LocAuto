<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Cadastro de cliente</title>
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<script src="resources/js/jquery-3.3.1.min.js" type="text/javascript"></script>
<script src="resources/js/bootstrap.min.js" type="text/javascript"></script>
</head>
<body>

	<div>
		<jsp:include page="navBar.jsp" />
	</div>
	
	<div class="container">
		<h2>Cadastro cliente pessoa física</h2>
	</div>

	<div class="container">
		<form:form method="post" action="salvaClientePF.html"
			modelAttribute="clientePF">


			<div class="form-group">
			
				<form:label path="nome">Nome:</form:label>
				<form:input class="form-control" path="nome" />
			</div>
			
			<div class="form-group">
				<form:label path="cpf">CPF:</form:label>
				<form:input class="form-control" path="cpf" />
			</div>
			<div class="form-group">
				<form:label path="rg">RG:</form:label>
				<form:input class="form-control" path="rg" />
			</div>
			<div class="form-group">
				<form:label path="datNasc">Data de Nascimento:</form:label>
				<form:input class="form-control" path="datNasc" />
			</div>
			<div class="form-group">
				<form:label path="naturalidade">Naturalidade:</form:label>
				<form:input class="form-control" path="naturalidade" />
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