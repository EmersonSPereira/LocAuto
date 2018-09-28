<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Planos Carro</title>
</head>
<body>
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