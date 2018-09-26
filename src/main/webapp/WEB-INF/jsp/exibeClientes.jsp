<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Clientes</title>
</head>
<body>
		<h1>Clientes</h1>
		<c:if test="${!empty listaclientes}">
			<table width="300px" border="1px" bordercolor="#000000">
				<tr>
					<td>Nome</td>
					<td>CPF</td>
					<td>RG</td>
					<td>Data de Nascimento</td>
					<td>Naturalidade</td>
					<td>Endereco</td>
					<td>Telefone</td>
					<td>Email</td>
					<td>&nbsp;</td>
				</tr>
				<c:forEach items="${listaclientes}" var="cliente">
					
					<tr>
						<td>${cliente.nome}</td>
						<td>${cliente.cpf}</td>
						<td>${cliente.rg}</td>
						<td>${cliente.datNasc}</td>
						<td>${cliente.naturalidade}</td>
						<td>${cliente.endereco}</td>
						<td>${cliente.telefone}</td>
						<td>${cliente.email}</td>
						
						<td><a href="deleteCliente/${cliente.id}">delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>

		<a href="clientePF">Cadastro ClientePF</a>

</body>
</html>