<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Agências</title>

<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap.min.css"/>">
<script src="<c:url value="resources/js/jquery-3.3.1.min.js "/>"></script>
<script src="<c:url value="resources/js/bootstrap.js "/>"></script>
<script src="<c:url value="/resources/js/sweetalert.min.js "/>"></script>

<script type="text/javascript">
function redirecionar(id){
	var url = 'delete/'+ id;
	swal({
		  title: "Deseja Mesmo Deletar uma Agência?",
		  text: "A Agência pode estár associada a um ou mais veículo e a operação pode falhar",
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
function redirecionarEditar(id){
	var url = 'editar/'+ id;
	swal({
		  title: "Deseja Mesmo Editar esta Agência?",
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
		<h1>Agências</h1>
	</div>
	

	<c:if test="${!empty agenciaList}">
		<div class="container">
			<table class="table table-striped table-dark">
				<tr>
					<th scope="col">CNPJ</th>
					<th scope="col">Inscrição Estadual</th>
					<th scope="col">Gerente Responsavel</th>
					<th scope="col">Telefone</th>
					<th scope="col">Localidade</th>
					<th scope="col">Ação</th>

				</tr>

				<c:forEach items="${agenciaList}" var="agencia">
					<tr>
						<td>${agencia.cnpj}</td>
						<td>${agencia.inscEstadual}</td>
						<td>${agencia.gerenteResponsavel.nome}</td>
						<td>${agencia.telefone}</td>
						<td>${agencia.localidade}</td>
						<td>
							<button class="btn btn-warning btn-sm" onclick="redirecionarEditar(${agencia.id});">Editar</button>
							<button class="btn btn-danger btn-sm" onclick="redirecionar(${agencia.id});">Deletar</button>

						</td>
					</tr>
				</c:forEach>
			</table>
		</div>

	</c:if>




</body>
</html>