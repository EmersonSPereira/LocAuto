<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<title>Spring 3 MVC Series - Contact Manager</title>
	<style type="text/css">
		body {
			font-family: sans-serif;
		}
		.data, .data td {
			border-collapse: collapse;
			width: 100%;
			border: 1px solid #aaa;
			margin: 2px;
			padding: 2px;
		}
		.data th {
			font-weight: bold;
			background-color: #5C82FF;
			color: white;
		}
	</style>
</head>
<body>

<h2>Gerenciamento</h2>

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

	
<h3>Agencias</h3>
<c:if  test="${!empty contactList}">
<table class="data">
<tr>
	<th style="width: 150px; ">cnpj</th>
	<th>inscEstadual</th>
	<th>GerenteResponsavel</th>
	<th>Telefone</th>
	<th>&nbsp;</th>
</tr>
<c:forEach items="${contactList}" var="contact">
	<tr>
		<td>${contact.cnpj} </td>
		<td>${contact.inscEstadual}</td>
		<td>${contact.gerenteResponsavel}</td>
		<td>${contact.telefone}</td>
		<td><a href="delete/${contact.id}">delete</a></td>
	</tr>
</c:forEach>
</table>
</c:if>


</body>
</html>