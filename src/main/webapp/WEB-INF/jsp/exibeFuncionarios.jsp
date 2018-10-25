<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Funcionários</title>

<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<script src="<c:url value="resources/js/jquery-3.3.1.min.js "/>"></script>
<script src="<c:url value="resources/js/bootstrap.js "/>"></script>
<script src="<c:url value="/resources/js/sweetalert.min.js "/>"></script>


<script type="text/javascript">
function redirecionar(id){
	var url = 'deleteFuncionario/'+ id;
	swal({
		  title: "Deseja Mesmo Deletar este funcionário?",
		  text: "O Funcionário pode está associado a uma Agência caso seja Gerente, ou a uma  Locação caso seja Locador impedindo a operação de ser realizada",
		  icon: "warning",
		  buttons: true,
		  dangerMode: true,
		})
		.then((willDelete) => {
		  if (willDelete) {
			  window.location = url ;
		  } else {
		    swal("Operação Cancelada");
		  }
		});
}
</script>
<script>
function redirecionarEditarG(id){
	var url = 'editarFuncionarioG/'+ id;
	swal({
		  title: "Deseja Mesmo Editar este Funcionário?",
		  text: "Ao clicar em ok você será direcionado para edição.",
		  icon: "warning",
		  buttons: true,
		  dangerMode: true,
		})
		.then((willDelete) => {
		  if (willDelete) {
			  window.location = url ;
		  } else {
		    swal("Operação Cancelada");
		  }
		});
}
</script>
<script>
function redirecionarEditarL(id){
	var url = 'editarFuncionarioL/'+ id;
	swal({
		  title: "Deseja Mesmo Editar este Funcionário?",
		  text: "Ao clicar em ok você será direcionado para edição.",
		  icon: "warning",
		  buttons: true,
		  dangerMode: true,
		})
		.then((willDelete) => {
		  if (willDelete) {
			  window.location = url ;
		  } else {
		    swal("Operação Cancelada");
		  }
		});
}
</script>
</head>
<body>
	<div>
		<jsp:include page="navBar.jsp" />
	</div>
	<div class="container">
		<h1>Funcionários: Gerente</h1>

	</div>
	<c:if test="${!empty listaFuncionariosG}">
		<div class="container">
			<table class="table table-striped table-dark">
				<tr>
					<th scope="col">Nome</th>
					<th scope="col">CPF</th>
					<th scope="col">RG</th>
					<th scope="col">Data de Nascimento</th>
					<th scope="col">Naturalidade</th>
					<th scope="col">Endereco</th>
					<th scope="col">Telefone</th>
					<th scope="col">Email</th>
					<th scope="col">Ação</th>
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
						
						<td>
						<button class="btn btn-warning btn-sm"
								onclick="redirecionarEditarG(${funcionario.id});">&nbspEditar&nbsp </button><br><br>
							<button class="btn btn-danger btn-sm"
								onclick="redirecionar(${funcionario.id});">Deletar</button>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</c:if>



	<div class="container">
		<h1>Funcionários: Locador</h1>

	</div>
	<c:if test="${!empty listaFuncionariosL}">
		<div class="container">
			<table class="table table-striped table-dark">
				<tr>
					<th scope="col">Nome</th>
					<th scope="col">CPF</th>
					<th scope="col">RG</th>
					<th scope="col">Data de Nascimento</th>
					<th scope="col">Naturalidade</th>
					<th scope="col">Endereco</th>
					<th scope="col">Telefone</th>
					<th scope="col">Email</th>
					<th scope="col">Ação</th>
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

						<td>
						<button class="btn btn-warning btn-sm"
								onclick="redirecionarEditarL(${funcionario.id});">&nbspEditar&nbsp </button><br><br>
							<button class="btn btn-danger btn-sm"
								onclick="redirecionar(${funcionario.id});">Deletar</button>
						</td>
					</tr>
				</c:forEach>
			</table>

		</div>
	</c:if>



</body>
</html>