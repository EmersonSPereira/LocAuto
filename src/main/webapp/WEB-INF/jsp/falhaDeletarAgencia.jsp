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
	
}
</script>

</head>
<body>

<script type="text/javascript">
swal({
	  title: "Falha ao deletar Agência",
	  text: "Não foi possível deletar a Agência ela pode estar associada a um ou mais veículos",
	  icon: "error",
	  dangerMode: true,
	})
	.then((willDelete) => {
	  if (willDelete) {
		  window.location = '/LocAuto/exibeAgencias' ;
	    
	  } else {
	    swal("Your imaginary file is safe!");
	  }
	});
</script>

	


	

</body>
</html>