<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Cadastro de veículo</title>
</head>
<body>

	<h2>Cadastro veículo: Motocicleta</h2>

	<form:form method="post" action="salvaVeiculoM.html" modelAttribute="veiculoM">

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
				<td><form:label path="potencia">Potência:</form:label></td>
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
				<td><form:label path="agencia">Agência:</form:label></td>
				<td><form:input path="agencia" /></td>
			</tr>
			<tr>
				<td><form:label path="cilindradas">Cilindradas:</form:label></td>
				<td><form:input path="cilindradas" /></td>
			</tr>
			<tr>
				<td><form:label path="freios">Freios:</form:label></td>
				<td><form:input path="freios" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="salvar" /></td>
			</tr>
		</table>
	</form:form>

	<a href="exibeVeiculos">Exibe Veiculos</a>





</body>
</html>
