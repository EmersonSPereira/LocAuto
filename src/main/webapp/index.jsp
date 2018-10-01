<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>


<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<script src="resources/js/jquery-3.3.1.min.js" type="text/javascript"></script>
<script src="resources/js/bootstrap.min.js" type="text/javascript"></script>


<meta charset="ISO-8859-1">
<title>LocAuto</title>


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
						<a class="dropdown-item" href="agencia">Cadastrar Agência</a> 
						<a class="dropdown-item" href="exibeAgencia">Exibir Agências</a>
											
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
						<a class="dropdown-item" href="exibeFuncionarios">Exibir Funcionários</a> 
					
											
					</div></li>
					<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> Veículo </a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item" href="veiculoC">Cadastrar Carro</a> 
						<a class="dropdown-item" href="veiculoM">Cadastrar Motocicleta</a>
						<a class="dropdown-item" href="exibeVeiculos">Exibir Veículos</a> 
						
											
					</div></li>
					
					<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> Planos </a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item" href="planoC">Cadastrar Plano Carro</a> 
						<a class="dropdown-item" href="planoM">Cadastrar Plano Motocicleta</a>
						<a class="dropdown-item" href="exibePlanos">Exibir Planos</a> 
											
					</div></li>
			
			</ul>
			
		</div>
	</nav>

	<div>

		<h1>LocAuto: Locadora de veículos</h1>
		<br>

		<h2>Cadastros</h2>
		<a href="funcionarioG">Cadastro Gerente</a> <a href="funcionarioL">Cadastro
			locador</a> <br> <br> <a href="clientePF">Cadastro
			ClientePF</a> <a href="clientePJ">Cadastro ClientePJ</a> <br> <br>
		<a href="veiculoC">Cadastro Carro</a> <a href="veiculoM">Cadastro
			Motocicleta</a> <br> <br> <a href="planoC">Cadastro novo
			plano carro</a> <a href="planoM">Cadastro novo plano motocicleta</a> <br>
		<br> <a href="agencia">Cadastro Agência</a> <br> <br>

		<h2>Consultas</h2>

		<a href="exibeClientes">Exibe Clientes</a> <a href="exibeFuncionarios">Exibe
			Funcionários</a> <br> <br> <a href="exibeVeiculos">Exibe
			Veiculos</a> <a href="exibeAgencias">Exibe Agências</a><br> <br>
		<a href="exibePlanos">Exibe Planos</a>


	</div>

</body>
</html>