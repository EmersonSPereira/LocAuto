<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Cadastro de planos</title>

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

	<h2>Cadastro novo plano: Carro</h2>

	<form:form method="post" action="salvaPlanoC.html"
		modelAttribute="planoC">

		<table>
			<tr>
				<td><form:label path="plano">Plano:</form:label></td>
				<td><form:input path="plano" /></td>
			</tr>
			<tr>
				<td><form:label path="veiculos">Veiculos:</form:label></td>
				<td><form:input path="veiculos" /></td>
			</tr>
			<tr>
				<td><form:label path="cilindradas">Cilindradas:</form:label></td>
				<td><form:input path="cilindradas" /></td>
			</tr>
			<tr>
				<td><form:label path="acessorios">Acessórios:</form:label></td>
				<td><form:input path="acessorios" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="salvar" /></td>
			</tr>
		</table>
	</form:form>

	<a href="exibePlanos">Exibe Planos</a>





</body>
</html>
