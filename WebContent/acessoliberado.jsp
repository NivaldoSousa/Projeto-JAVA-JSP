
<jsp:useBean id="calcula" class="beans.BeanCursoJsp"
	type="beans.BeanCursoJsp" scope="page" />

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center style="padding-top: 10%;">
		<h2>Seja bem vindo ao Sistema de Cadastro de Usuarios e Produtos</h2>

		<table>
			<tr>

				<td><a href="salvarUsuario?acao=listartodos"> <img
						src="resources/img/usuario.jpg" alt="Cadastrar Usuario"
						title="Cadastrar Usuario" width="150px" height="150px"></a></td>

				<td><a href="salvarProduto?acao=listartodos"> <img
						src="resources/img/produto.png" alt="Cadastrar Produto"
						title="Cadastrar Produto" width="150px" height="150px"></a></td>

			</tr>
		</table>

</center>
</body>
</html>