<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Planos Carro</title>

<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<script src="<c:url value="resources/js/jquery-3.3.1.min.js "/>"></script>
<script src="<c:url value="resources/js/bootstrap.js "/>"></script>
<script src="<c:url value="/resources/js/sweetalert.min.js "/>"></script>



<script type="text/javascript">
function redirecionar(id){
	var url = 'deletePlano/'+ id;
	swal({
		  title: "Deseja Mesmo Deletar este Plano?",
		  text: "Este Plano pode estar sendo utilizado em uma locação e a operação pode falhar",
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
function redirecionarEditarPC(id){
	var url = 'editarPlanoC/'+ id;
	swal({
		  title: "Deseja Mesmo Editar este Carro?",
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
function redirecionarEditarPM(id){
	var url = 'editarPlanoM/'+ id;
	swal({
		  title: "Deseja Mesmo Editar esta Motocicleta?",
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
		<h1>Planos Carro</h1>
	</div>
	<c:if test="${!empty listaPlanosC}">

		<div class="container">
			<table class="table table-striped table-dark">
				<tr>
					<th scope="col">Plano</th>
					<th scope="col">Veiculos</th>
					<th scope="col">Potência</th>
					<th scope="col">Acessórios</th>
					<th scope="col">Valor Diária em R$</th>
					<th scope="col">&nbsp;</th>
				</tr>
				<c:forEach items="${listaPlanosC}" var="plano">

					<tr>
						<td>${plano.plano}</td>
						<td>${plano.veiculos}</td>
						<td>${plano.potencia}</td>
						<td>${plano.acessorios}</td>
						<td>${plano.valorDiaria}</td>


						<td>
							<button class="btn btn-warning btn-sm"
								onclick="redirecionarEditarPC(${plano.id});">&nbspEditar&nbsp </button><br><br>
							<button class="btn btn-danger btn-sm"
								onclick="redirecionar(${plano.id});">Deletar</button>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</c:if>

	<div class="container">

		<h1>Planos Motocicleta</h1>
	</div>
	<c:if test="${!empty listaPlanosM}">

		<div class="container">
			<table class="table table-striped table-dark">
				<tr>
					<th scope="col">Plano</th>
					<th scope="col">Veiculos</th>
					<th scope="col">Cilindradas</th>
					<th scope="col">Valor Diária em R$</th>
					<th scope="col">&nbsp;</th>
				</tr>
				<c:forEach items="${listaPlanosM}" var="plano">

					<tr>
						<td>${plano.plano}</td>
						<td>${plano.veiculos}</td>
						<td>${plano.cilindradas}</td>
						<td>${plano.valorDiaria}</td>


						<td>
							<button class="btn btn-warning btn-sm"
								onclick="redirecionarEditarPM(${plano.id});">&nbspEditar&nbsp </button><br><br>
							<button class="btn btn-danger btn-sm"
								onclick="redirecionar(${plano.id});">Deletar</button></td>

					</tr>
				</c:forEach>
			</table>
		</div>
	</c:if>


</body>
</html>