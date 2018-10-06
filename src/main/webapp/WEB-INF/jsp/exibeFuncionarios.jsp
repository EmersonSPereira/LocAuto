<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Funcionários</title>

<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<script src="<c:url value="resources/js/jquery-3.3.1.min.js "/>"></script>
<script src="<c:url value="resources/js/bootstrap.js "/>"></script>
</head>
<body>
	<div>
		<jsp:include page="navBar.jsp" />
	</div>
	<div class="container">
		<h1>Funcionários: Gerente</h1>

	</div>
	<c:if test="${!empty listaFuncionariosG}">
		<div class="container">
			<table class="table table-striped table-dark">
				<tr>
					<th scope="col">Nome</th>
					<th scope="col">CPF</th>
					<th scope="col">RG</th>
					<th scope="col">Data de Nascimento</th>
					<th scope="col">Naturalidade</th>
					<th scope="col">Endereco</th>
					<th scope="col">Telefone</th>
					<th scope="col">Email</th>
					<th scope="col">Ação</th>
				</tr>
				<c:forEach items="${listaFuncionariosG}" var="funcionario">

					<tr>
						<td>${funcionario.nome}</td>
						<td>${funcionario.cpf}</td>
						<td>${funcionario.rg}</td>
						<td>${funcionario.dataNascimento}</td>
						<td>${funcionario.naturalidade}</td>
						<td>${funcionario.endereco}</td>
						<td>${funcionario.telefone}</td>
						<td>${funcionario.email}</td>
						
						<td><a href="deleteFuncionario/${funcionario.id}" class="badge badge-danger">delete</a>
						<a href="editarFuncionarioG/${funcionario.id}" class="badge badge-warning">editar</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</c:if>



	<div class="container">
		<h1>Funcionários: Locador</h1>

	</div>
	<c:if test="${!empty listaFuncionariosL}">
		<div class="container">
			<table class="table table-striped table-dark">
				<tr>
					<th scope="col">Nome</th>
					<th scope="col">CPF</th>
					<th scope="col">RG</th>
					<th scope="col">Data de Nascimento</th>
					<th scope="col">Naturalidade</th>
					<th scope="col">Endereco</th>
					<th scope="col">Telefone</th>
					<th scope="col">Email</th>
					<th scope="col">Ação</th>
				</tr>
				<c:forEach items="${listaFuncionariosL}" var="funcionario">

					<tr>
						<td>${funcionario.nome}</td>
						<td>${funcionario.cpf}</td>
						<td>${funcionario.rg}</td>
						<td>${funcionario.dataNascimento}</td>
						<td>${funcionario.naturalidade}</td>
						<td>${funcionario.endereco}</td>
						<td>${funcionario.telefone}</td>
						<td>${funcionario.email}</td>

						<td><a href="deleteFuncionario/${funcionario.id}" class="badge badge-danger">delete</a>
						<a href="editarFuncionarioL/${funcionario.id}" class="badge badge-warning">editar</a></td>
					</tr>
				</c:forEach>
			</table>

		</div>
	</c:if>



</body>
</html>