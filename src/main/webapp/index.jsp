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

	<div>
		<jsp:include page="WEB-INF/jsp/navBar.jsp" />
	</div>
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