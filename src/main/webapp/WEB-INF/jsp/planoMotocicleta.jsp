<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Cadastro de planos</title>
</head>
<body>

	<h2>Cadastro novo plano: Motocicleta</h2>

	<form:form method="post" action="salvaPlanoM.html"
		modelAttribute="planoM">

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
				<td colspan="2"><input type="submit" value="salvar" /></td>
			</tr>
		</table>
	</form:form>

	<a href="exibePlanos">Exibe Planos</a>





</body>
</html>
