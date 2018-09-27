<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<title>Cadastro de cliente</title>
</head>
<body>

<h2>Cadastro cliente pessoa juridica</h2>

<form:form method="post" action="salvaClientePJ.html" modelAttribute="clientePJ">

	<table>
	<tr> 
		<td><form:label path="nomeFantasia">Nome Fantasia:</form:label></td>
		<td><form:input path="nomeFantasia" /></td> 
	</tr>
	<tr>
		<td><form:label path="razaoSocial">Razão Social:</form:label></td>
		<td><form:input path="razaoSocial" /></td>
	</tr>
	<tr>
		<td><form:label path="cnpj">CNPJ:</form:label></td>
		<td><form:input path="cnpj" /></td>
	</tr>
	<tr>
		<td><form:label path="inscEstadual">Inscrição Estadual:</form:label></td>
		<td><form:input path="inscEstadual" /></td>
	</tr>
	<tr>
		<td><form:label path="endereco">Endereco:</form:label></td>
		<td><form:input path="endereco" /></td>
	</tr>
	<tr>
		<td><form:label path="telefone">Telefone:</form:label></td>
		<td><form:input path="telefone" /></td>
	</tr>
	<tr>
		<td><form:label path="email">Email:</form:label></td>
		<td><form:input path="email" /></td>
	</tr>
	<tr>
		<td colspan="2">
			<input type="submit" value="salvar"/>
		</td>
	</tr>
</table>	
</form:form>

<a href="exibeClientes">Exibe Clientes</a>

	



</body>
</html>