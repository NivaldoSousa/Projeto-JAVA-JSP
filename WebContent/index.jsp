<jsp:useBean id="calcula" class="beans.BeanCursoJsp"
	type="beans.BeanCursoJsp" scope="page" />


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="myprefix" uri="/WEB-INF/testetag.tld"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet" href="resources/css/estilo.css">

</head>
<body>
	<div class="login-page">
		<center><h2>Sistema de Cadastro</h2></center><br/>
		<center><span><b>Login:</b> admin </br> <b>Senha:</b> 123<span/></center>
		<div class="form">
			<form action="LoginServelet" method="post"  class="login-form">
				Login: <input type="text" id="login" name="login"> <br />
				Senha: <input type="password" id="senha" name="senha"> <br />
				<button type="submit" value="Logar">Logar</button>

			</form>
		</div>
	</div>
</body>

</html>
