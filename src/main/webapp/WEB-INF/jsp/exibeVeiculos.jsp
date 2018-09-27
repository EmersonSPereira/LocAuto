<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Veiculos</title>
</head>
<body>
	<div>
		<h1>Veículos: Carros</h1>
		<c:if test="${!empty listaVeiculosC}">
			<table width="150px" border="1px" bordercolor="#000000">
				<tr>
					<td>Renavam</td>
					<td>Modelo</td>
					<td>Marca</td>
					<td>Potência</td>
					<td>Ano</td>
					<td>Cor</td>
					<td>Tipo Combustivel</td>
					<td>Agência</td>
					<td>Acessórios</td>

					<td>&nbsp;</td>
				</tr>
				<c:forEach items="${listaVeiculosC}" var="veiculo">

					<tr>
						<td>${veiculo.renavam}</td>
						<td>${veiculo.modelo}</td>
						<td>${veiculo.marca}</td>
						<td>${veiculo.potencia}</td>
						<td>${veiculo.ano}</td>
						<td>${veiculo.cor}</td>
						<td>${veiculo.tipoCombustivel}</td>
						<td>${veiculo.agencia}</td>
						<td>${veiculo.acessorios}</td>

						<td><a href="deleteVeiculo/${veiculo.id}">delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</div>

	<div>
		<h1>Veículos: Motocicletas</h1>
		<c:if test="${!empty listaVeiculosM}">
			<table width="150px" border="1px" bordercolor="#000000">
				<tr>
					<td>Renavam</td>
					<td>Modelo</td>
					<td>Marca</td>
					<td>Potência</td>
					<td>Ano</td>
					<td>Cor</td>
					<td>Tipo Combustivel</td>
					<td>Agência</td>
					<td>Cilindradas</td>
					<td>Freios</td>

					<td>&nbsp;</td>
				</tr>
				<c:forEach items="${listaVeiculosM}" var="veiculo">

					<tr>
						<td>${veiculo.renavam}</td>
						<td>${veiculo.modelo}</td>
						<td>${veiculo.marca}</td>
						<td>${veiculo.potencia}</td>
						<td>${veiculo.ano}</td>
						<td>${veiculo.cor}</td>
						<td>${veiculo.tipoCombustivel}</td>
						<td>${veiculo.agencia}</td>
						<td>${veiculo.cilindradas}</td>
						<td>${veiculo.freios}</td>

						<td><a href="deleteVeiculo/${veiculo.id}">delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</div>

	<a href="veiculoC">Cadastro Carro</a>
	<a href="veiculoM">Cadastro Motocicleta</a>
	<a href="/LocAuto/">Home</a>

</body>
</html>