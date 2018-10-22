<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Cadastro de agência</title>
<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap.min.css"/>">
<script src="<c:url value="/resources/js/jquery-3.3.1.min.js "/>"></script>
<script src="<c:url value="/resources/js/bootstrap.js "/>"></script>

<script src="<c:url value="/resources/js/validacao.js "/>"></script>

</head>
<body>

	<div>
		<jsp:include page="navBar.jsp" />
	</div>
	<div class="container">
		<h2>Cadastro Agência</h2>

	</div>

	<div class="container">
		<form:form method="post" action="add.html" modelAttribute="agencia">

			<div class="form-group">
				<form:input type="hidden" class="form-control" path="id" />
			</div>


			<div class="form-group">

				<form:label path="cnpj">CNPJ:</form:label>

				<form:input name="cnpj" required="true"
					onKeyPress="MascaraCNPJ(agencia.cnpj);" class="form-control"
					path="cnpj" maxlength="18" onblur="ValidarCNPJ(agencia.cnpj)" />
			</div>

			<div class="form-group">

				<label>Escolha o Gerente responsavél pela Agência</label>

				<form:select class="form-control" path="GerenteResponsavel.id">
					<c:forEach items="${listaGerentes }" var="gerente">
						<form:option value="${gerente.id}">${gerente.nome}</form:option>
					</c:forEach>

				</form:select>



			</div>
			<div class="form-group">
				<form:label path="inscEstadual">Inscrição Estadual:</form:label>

				<form:input required="true" class="form-control" path="inscEstadual"
					placeholder="digite a incrição estadual com '. , - , / '"
					maxlength="20" />

			</div>
			<div class="form-group">
				<form:label path="telefone">Telefone:</form:label>

				<form:input required="true" name="telefone"
					onkeypress="MascaraTelefone(this);" class="form-control"
					path="telefone" maxlength="16" />

			</div>

			<div class="form-group">
				<form:label path="telefone">Localidade:</form:label>

				<form:input required="true" name="localidade" class="form-control"
					path="localidade" maxlength="70" placeholder="digite a cidade e número da unidade, ex: São Paulo, Unidade 3"/>

			</div>
			<button type="submit" class="btn btn-success">Salvar</button>
		</form:form>

	</div>

	<div class="container">
		<a href="exibeAgencias" class="badge badge-primary">Exibe Agências</a>

	</div>





</body>
</html>