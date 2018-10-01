<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Cadastro de ve�culo</title>
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

	<h2>Cadastro ve�culo: Carro</h2>

	<form:form method="post" action="salvaVeiculoC.html"
		modelAttribute="veiculoC">

		<table>
			<tr>
				<td><form:label path="renavam">Renavam:</form:label></td>
				<td><form:input path="renavam" /></td>
			</tr>
			<tr>
				<td><form:label path="modelo">Modelo:</form:label></td>
				<td><form:input path="modelo" /></td>
			</tr>
			<tr>
				<td><form:label path="marca">Marca:</form:label></td>
				<td><form:input path="marca" /></td>
			</tr>
			<tr>
				<td><form:label path="potencia">Pot�ncia:</form:label></td>
				<td><form:input path="potencia" /></td>
			</tr>
			<tr>
				<td><form:label path="ano">Ano:</form:label></td>
				<td><form:input path="ano" /></td>
			</tr>
			<tr>
				<td><form:label path="cor">Cor:</form:label></td>
				<td><form:input path="cor" /></td>
			</tr>
			<tr>
				<td><form:label path="tipoCombustivel">Tipo Combustivel:</form:label></td>
				<td><form:input path="tipoCombustivel" /></td>
			</tr>
			<tr>
				<td><form:label path="agencia">Ag�ncia:</form:label></td>
				<td><form:input path="agencia" /></td>
			</tr>
			<tr>
				<td><form:label path="acessorios">Acess�rios:</form:label></td>
				<td><form:input path="acessorios" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="salvar" /></td>
			</tr>
		</table>
	</form:form>

	<a href="exibeVeiculos">Exibe Veiculos</a>





</body>
</html>