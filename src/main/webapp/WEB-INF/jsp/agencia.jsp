<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<title>Cadastro de ag�ncia</title>
</head>
<body>

<h2>Cadastro Ag�ncia</h2>

<form:form method="post" action="add.html" modelAttribute="contact">

	<table>
	<tr>
		<td><form:label path="cnpj">CNPJ</form:label></td>
		<td><form:input path="cnpj" /></td> 
	</tr>
	<tr>
		<td><form:label path="GerenteResponsavel">Gerente Responsav�l</form:label></td>
		<td><form:input path="GerenteResponsavel" /></td>
	</tr>
	<tr>
		<td><form:label path="inscEstadual">Inscri��o Estadual</form:label></td>
		<td><form:input path="inscEstadual" /></td>
	</tr>
	<tr>
		<td><form:label path="telefone">Telefone</form:label></td>
		<td><form:input path="telefone" /></td>
	</tr>
	<tr>
		<td colspan="2">
			<input type="submit" value="salvar"/>
		</td>
	</tr>
</table>	
</form:form>

<a href="exibeAgencias">Exibe Ag�ncias</a>

	



</body>
</html>