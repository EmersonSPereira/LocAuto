<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Funcionários</title>
</head>
<body>
	<div>
		<h1>Funcionários: Gerente</h1>
		<c:if test="${!empty listaFuncionariosG}">
			<table width="150px" border="1px" bordercolor="#000000">
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
				<c:forEach items="${listaFuncionariosG}" var="funcionario">

					<tr>
						<td>${funcionario.nome}</td>
						<td>${funcionario.cpf}</td>
						<td>${funcionario.rg}</td>
						<td>${funcionario.dataNascimento}</td>
						<td>${funcionario.naturalidade}</td>
						<td>${funcionario.endereco}</td>
						<td>${funcionario.telefone}</td>
						<td>${funcionario.email}</td>

						<td><a href="deleteFuncionario/${funcionario.id}">delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</div>

	<div>
		<div>
		<h1>Funcionários: Locador</h1>
		<c:if test="${!empty listaFuncionariosL}">
			<table width="150px" border="1px" bordercolor="#000000">
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
				<c:forEach items="${listaFuncionariosL}" var="funcionario">

					<tr>
						<td>${funcionario.nome}</td>
						<td>${funcionario.cpf}</td>
						<td>${funcionario.rg}</td>
						<td>${funcionario.dataNascimento}</td>
						<td>${funcionario.naturalidade}</td>
						<td>${funcionario.endereco}</td>
						<td>${funcionario.telefone}</td>
						<td>${funcionario.email}</td>

						<td><a href="deleteFuncionario/${funcionario.id}">delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</div>

	<a href="funcionarioG">Cadastro Gerente</a>
	<a href="funcionarioL">Cadastro locador</a>
	<a href="/LocAuto/">Home</a>

</body>
</html>