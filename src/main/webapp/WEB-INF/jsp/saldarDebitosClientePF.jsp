<!DOCTYPE html>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="ISO-8859-1">

<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap.min.css"/>">
<script src="<c:url value="/resources/js/jquery-3.3.1.min.js "/>"></script>
<script src="<c:url value="/resources/js/bootstrap.js "/>"></script>
<script src="<c:url value="/resources/js/bootbox.min.js "/>"></script>
<script src="<c:url value="/resources/js/sweetalert.min.js "/>"></script>


<script type="text/javascript">
function redirecionar(){

		window.location = 'finalizar/${locacao.id }';
	
}
</script>

<title>Finalizar Locação</title>
</head>
<body>

	<div>
		<jsp:include page="navBar.jsp" />
	</div>

	<div class="container">
		<h1>Saldar débitos Locação</h1>
	</div>
	<br>
	<br>

	<div class="container">

		<h2>Dados da Locação:</h2>
		<br>
		<br>
	</div>

	<div class="container">





		<div class="form-group">

			<b><label>Locação N°:</label></b> <label>${locacao.id}</label>
		</div>

		<div class="form-group">

			<b><label>Cliente:</label></b> <label>${nomeCliente}</label>


		</div>

		<div class="form-group">

			<b><label>Locador:</label></b><label> ${nomeLocador}</label>


		</div>



		<div class="form-group">

			<b><label>Veiculo:</label></b> <label>${modeloVeiculo}</label>


		</div>


		<div class="form-group">

			<b><label>Plano:</label></b> <label>${plano.plano}:
				${plano.veiculos}</label>


		</div>

		<div class="form-group">

			<b><label>Seguro:</label></b> <label>${locacao.seguro}</label>


		</div>

		<div class="form-group">

			<b><label>Data de Retirada:</label></b> <label>${locacao.dataLocacao}</label>


		</div>

		<div class="form-group">

			<b><label>Data de Devolução prevista:</label></b> <label>${locacao.dataDevolucao}</label>


		</div>

		
		<div class="form-group">

			<b><label>Nível do tanque na retirada:</label></b> <label>${locacao.nivelDoTanque}</label>


		</div>





		<h2>Dados para calcular devolução:</h2>
		<br>
		

		<form:form method="post" action="/LocAuto/locacaoClientePf/finalizarSaldarDebitos"
			modelAttribute="devolucao">

			<div class="form-group">
				<form:input type="hidden" class="form-control" path="locacaoId" value = "${locacao.id}"/>
			</div>
			<div class="form-group">
				<form:label path="nivelDoTanque">Cobrar taxa de Abastecimento:</form:label>
				<form:select path="nivelDoTanque" class="form-control">

					<form:option value="naoCobrar">Não Cobrar Taxa</form:option>
					<form:option value="cobrar">Cobrar Taxa</form:option>
					
				</form:select>

			</div>
			
				<div class="form-group">
				<form:label path="danos">Danos:</form:label>
				<form:select path="danos" class="form-control">

					<form:option value="nenhum">Nenhum</form:option>
					<form:option value="arranhao">Arranhões</form:option>
					<form:option value="amassadoLeve">Amassados Leves</form:option>
					<form:option value="amassadoGrave">Amassados Grave</form:option>
					<form:option value="rouboPerda">Roubo/Perda Total</form:option>
					
				</form:select>

			</div>
			<button type="submit" class="btn btn-success">Calcular Débitos</button><br><br>
			</form:form>

	</div>








</body>
</html>