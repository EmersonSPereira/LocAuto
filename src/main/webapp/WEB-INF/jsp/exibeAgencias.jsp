<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Agências</title>
</head>
<body>
	<div >
		<h1>Agências</h1>
		<c:if test="${!empty contactList}">
			<table width="300px" border="1px" bordercolor="#000000">
				<tr>
					<td>CNPJ</td>
					<td>Inscrição Estadual</td>
					<td>Gerente Responsavel</td>
					<td>Telefone</td>
					<td>&nbsp;</td>
				</tr>
				<c:forEach items="${contactList}" var="contact">
					<tr>
						<td>${contact.cnpj}</td>
						<td>${contact.inscEstadual}</td>
						<td>${contact.gerenteResponsavel}</td>
						<td>${contact.telefone}</td>
						<td><a href="delete/${contact.id}">delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>

		<a href="agencia">Cadastro Agência</a>
		<a href="/LocAuto/">Home</a>

	</div>

</body>
</html>