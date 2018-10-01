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

	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<a class="navbar-brand" href="#">LocAuto</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link" href="/LocAuto">Home
						<span class="sr-only">(current)</span>
				</a></li>

				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> Ag�ncia </a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item" href="agencia">Cadastrar Ag�ncia</a> <a
							class="dropdown-item" href="exibeAgencias">Exibir Ag�ncias</a>

					</div></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> Cliente </a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item" href="clientePF">Cadastrar Cliente PF</a>
						<a class="dropdown-item" href="clientePJ">Cadastrar Cliente PJ</a>
						<a class="dropdown-item" href="exibeClientes">Exibir Clientes</a>


					</div></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> Funcion�rio </a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item" href="funcionarioG">Cadastrar Gerente</a>
						<a class="dropdown-item" href="funcionarioL">Cadastrar Locador</a>
						<a class="dropdown-item" href="exibeFuncionarios">Exibir
							Funcion�rios</a>


					</div></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> Ve�culo </a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item" href="veiculoC">Cadastrar Carro</a> <a
							class="dropdown-item" href="veiculoM">Cadastrar Motocicleta</a> <a
							class="dropdown-item" href="exibeVeiculos">Exibir Ve�culos</a>


					</div></li>

				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> Planos </a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item" href="planoC">Cadastrar Plano Carro</a> <a
							class="dropdown-item" href="planoM">Cadastrar Plano
							Motocicleta</a> <a class="dropdown-item" href="exibePlanos">Exibir
							Planos</a>

					</div></li>

			</ul>

		</div>
	</nav>
	<div>
		<h1>Clientes PF</h1>
		<c:if test="${!empty listaclientesPF}">
			<table width="150px" border="1px" bordercolor="#000000">
				<tr>
					<td>Nome</td>
					<td>CPF</td>
					<td>RG</td>
					<td>Data de Nascimento</td>
					<td>Naturalidade</td>
					<td>Endereco</td>
					<td>Telefone</td>
					<td>Email</td>
					<td>&nbsp;</td>
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

						<td><a href="deleteCliente/${cliente.id}">delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</div>

	<div>
		<h1>Clientes PJ</h1>
		<c:if test="${!empty listaclientesPJ}">
			<table width="150px" border="1px" bordercolor="#000000">
				<tr>
					<td>Nome Fantasia</td>
					<td>Raz�o Social</td>
					<td>CNPJ</td>
					<td>Inscri��o Estadual</td>
					<td>Endereco</td>
					<td>Telefone</td>
					<td>Email</td>
					<td>&nbsp;</td>
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

						<td><a href="deleteCliente/${cliente.id}">delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</div>

	<a href="clientePF">Cadastro ClientePF</a>
	<a href="clientePJ">Cadastro ClientePJ</a>
	<a href="/LocAuto/">Home</a>

</body>
</html>