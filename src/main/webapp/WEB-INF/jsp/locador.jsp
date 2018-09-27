<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<title>Cadastro de Funcionário</title>
</head>
<body>

<h2>Cadastro de Funcionário: Locador</h2>

<form:form method="post" action="salvaFuncionarioL.html" modelAttribute="funcionarioL">

	<table>
	<tr>
		<td><form:label path="nome">Nome:</form:label></td>
		<td><form:input path="nome" /></td> 
	</tr>
	<tr>
		<td><form:label path="cpf">CPF:</form:label></td>
		<td><form:input path="cpf" /></td>
	</tr>
	<tr>
		<td><form:label path="rg">RG:</form:label></td>
		<td><form:input path="rg" /></td>
	</tr>
	<tr>
		<td><form:label path="dataNascimento">Data de Nascimento:</form:label></td>
		<td><form:input path="dataNascimento" /></td>
	</tr>
	<tr>
		<td><form:label path="naturalidade">Naturalidade:</form:label></td>
		<td><form:input path="naturalidade" /></td>
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

<a href="exibeFuncionarios">Exibe Funcionários</a>

	



</body>
</html>