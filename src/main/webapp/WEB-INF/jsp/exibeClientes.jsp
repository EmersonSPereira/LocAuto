<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Clientes</title>

<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<script src="<c:url value="resources/js/jquery-3.3.1.min.js "/>"></script>
<script src="<c:url value="resources/js/bootstrap.js "/>"></script>
<script src="<c:url value="/resources/js/sweetalert.min.js "/>"></script>



<script type="text/javascript">
function redirecionar(id){
	var url = 'deleteCliente/'+ id;
	swal({
		  title: "Deseja Mesmo Deletar este Cliente?",
		  text: "Este Cliente pode estar associado a uma locação e a operação pode falhar",
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
function redirecionarEditarPF(id){
	var url = 'editarClientePF/'+ id;
	swal({
		  title: "Deseja Mesmo Editar este Cliente?",
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
function redirecionarEditarPJ(id){
	var url = 'editarClientePJ/'+ id;
	swal({
		  title: "Deseja Mesmo Editar este Cliente?",
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
		<h1>Clientes PF</h1>
	</div>
	<c:if test="${!empty listaclientesPF}">
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
				<c:forEach items="${listaclientesPF}" var="cliente">

					<tr>
						<td>${cliente.nome}</td>
						<td>${cliente.cpf}</td>
						<td>${cliente.rg}</td>
						<td>${cliente.datNasc}</td>
						<td>${cliente.naturalidade}</td>
						<td>${cliente.endereco}</td>
						<td>${cliente.telefone}</td>
						<td>${cliente.email}</td>

						<td>
							<button class="btn btn-warning btn-sm"
								onclick="redirecionarEditarPF(${cliente.id});">&nbspEditar&nbsp </button><br><br>
							<button class="btn btn-danger btn-sm"
								onclick="redirecionar(${cliente.id});">Deletar</button>

						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</c:if>


	<div class="container">
		<h1>Clientes PJ</h1>
	</div>
	<c:if test="${!empty listaclientesPJ}">

		<div class="container">
			<table class="table table-striped table-dark">
				<tr>
					<th scope="col">Nome Fantasia</th>
					<th scope="col">Razão Social</th>
					<th scope="col">CNPJ</th>
					<th scope="col">Inscrição Estadual</th>
					<th scope="col">Endereco</th>
					<th scope="col">Telefone</th>
					<th scope="col">Email</th>
					<th scope="col">Ação</th>
				</tr>
				<c:forEach items="${listaclientesPJ}" var="cliente">

					<tr>
						<td>${cliente.nomeFantasia}</td>
						<td>${cliente.razaoSocial}</td>
						<td>${cliente.cnpj}</td>
						<td>${cliente.inscEstadual}</td>
						<td>${cliente.endereco}</td>
						<td>${cliente.telefone}</td>
						<td>${cliente.email}</td>

						<td>
							<button class="btn btn-warning btn-sm"
								onclick="redirecionarEditarPF(${cliente.id});">Editar</button>
							<button class="btn btn-danger btn-sm"
								onclick="redirecionar(${cliente.id});">Deletar</button>
						</td>

					</tr>
				</c:forEach>
			</table>
		</div>
	</c:if>



</body>
</html>