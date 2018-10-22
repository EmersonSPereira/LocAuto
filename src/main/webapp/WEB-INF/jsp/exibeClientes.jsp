<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Clientes</title>

<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<script src="<c:url value="resources/js/jquery-3.3.1.min.js "/>"></script>
<script src="<c:url value="resources/js/bootstrap.js "/>"></script>
</head>
<body>

	<div>
		<jsp:include page="navBar.jsp" />
	</div>
	<div class="container">
		<h1>Clientes PF</h1>
	</div>
	<c:if test="${!empty listaclientesPF}">
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
				<c:forEach items="${listaclientesPF}" var="cliente">

					<tr>
						<td>${cliente.nome}</td>
						<td>${cliente.cpf}</td>
						<td>${cliente.rg}</td>
						<td>${cliente.datNasc}</td>
						<td>${cliente.naturalidade}</td>
						<td>${cliente.endereco}</td>
						<td>${cliente.telefone}</td>
						<td>${cliente.email}</td>

						<td><a href="editarClientePF/${cliente.id}"
							class="badge badge-warning">editar</a><br> <a
							href="deleteCliente/${cliente.id}" class="badge badge-danger">delete</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</c:if>


	<div class="container">
		<h1>Clientes PJ</h1>
	</div>
	<c:if test="${!empty listaclientesPJ}">

		<div class="container">
			<table class="table table-striped table-dark">
				<tr>
					<th scope="col">Nome Fantasia</th>
					<th scope="col">Razão Social</th>
					<th scope="col">CNPJ</th>
					<th scope="col">Inscrição Estadual</th>
					<th scope="col">Endereco</th>
					<th scope="col">Telefone</th>
					<th scope="col">Email</th>
					<th scope="col">Ação</th>
				</tr>
				<c:forEach items="${listaclientesPJ}" var="cliente">

					<tr>
						<td>${cliente.nomeFantasia}</td>
						<td>${cliente.razaoSocial}</td>
						<td>${cliente.cnpj}</td>
						<td>${cliente.inscEstadual}</td>
						<td>${cliente.endereco}</td>
						<td>${cliente.telefone}</td>
						<td>${cliente.email}</td>

						<td><a
							href="editarClientePJ/${cliente.id}" class="badge badge-warning">editar</a><br>
							<a href="deleteCliente/${cliente.id}"
							class="badge badge-danger">delete</a> </td>

					</tr>
				</c:forEach>
			</table>
		</div>
	</c:if>



</body>
</html>