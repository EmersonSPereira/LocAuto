<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Planos Carro</title>

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
					aria-expanded="false"> Agência </a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item" href="agencia">Cadastrar Agência</a> <a
							class="dropdown-item" href="exibeAgencias">Exibir Agências</a>

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
					aria-expanded="false"> Funcionário </a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item" href="funcionarioG">Cadastrar Gerente</a>
						<a class="dropdown-item" href="funcionarioL">Cadastrar Locador</a>
						<a class="dropdown-item" href="exibeFuncionarios">Exibir
							Funcionários</a>


					</div></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> Veículo </a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item" href="veiculoC">Cadastrar Carro</a> <a
							class="dropdown-item" href="veiculoM">Cadastrar Motocicleta</a> <a
							class="dropdown-item" href="exibeVeiculos">Exibir Veículos</a>


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
		<h1>Planos Carro</h1>
		<c:if test="${!empty listaPlanosC}">
			<table width="150px" border="1px" bordercolor="#000000">
				<tr>
					<td>Plano</td>
					<td>Veiculos</td>
					<td>Cilindradas</td>
					<td>Acessórios</td>
					<td>&nbsp;</td>
				</tr>
				<c:forEach items="${listaPlanosC}" var="plano">

					<tr>
						<td>${plano.plano}</td>
						<td>${plano.veiculos}</td>
						<td>${plano.cilindradas}</td>
						<td>${plano.acessorios}</td>
						<td><a href="deletePlano/${plano.id}">delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</div>

	<div>
		<h1>Planos Motocicleta</h1>
		<c:if test="${!empty listaPlanosM}">
			<table width="150px" border="1px" bordercolor="#000000">
				<tr>
					<td>Plano</td>
					<td>Veiculos</td>
					<td>Cilindradas</td>
					<td>&nbsp;</td>
				</tr>
				<c:forEach items="${listaPlanosM}" var="plano">

					<tr>
						<td>${plano.plano}</td>
						<td>${plano.veiculos}</td>
						<td>${plano.cilindradas}</td>
						<td><a href="deletePlano/${plano.id}">delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</div>

	<a href="planoC">Cadastro novo plano: Carro</a>
	<a href="planoM">Cadastro novo plano: Motocicleta</a>
	<a href="/LocAuto/">Home</a>

</body>
</html>