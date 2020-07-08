<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt"  %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de produtos</title>

<script src="resources/javascript/jquery.min.js" type="text/javascript">
	
</script>
<script src="resources/javascript/jquery.maskMoney.min.js"
	type="text/javascript">
	
</script>
<link rel="stylesheet" href="resources/css/cadastro.css">
</head>
<body>
	<a href="acessoliberado.jsp"><img alt="Inicio" 	title= "Inico" src="resources/img/iconeInicio.png" width="34px" height="34px"></a>
	<a href="index.jsp"><img alt="Sair" title= "Sair" src="resources/img/iconeSair.jpg" width="39px" height="39px"></a>
	<center>
		<h1>Cadastro de Produtos</h1>
		<h3 style="color: red">${msg}</h3>
	</center>

	<center>
		<form action="salvarProduto" method="post" id="formUser"
			onsubmit=" return validarCampos() ? true : false;">
			<ul class="form-style-1">
				<li>
					<table>
						<tr>
							<td>Código:</td>
							<td><input type="text" readonly="readonly" id="id" name="id"
								value="${user.id}" class="field-long"></td>
						</tr>
						<tr>
							<td>Nome:</td>
							<td><input type="text" id="nome" name="nome"
								value="${user.nome}"></td>
						</tr>

						<tr>
							<td>Quantidade:</td>
							<td><input type="text" id="quantidade" name="quantidade"
								value="${user.quantidade}" maxlength="5"></td>
						</tr>
						<tr>
							<td>Valor R$:</td>
							<td><input type="text" id="valor" name="valor"
								data-thousands="." data-decimal="," data-prefix="R$"
								value="${user.valor}"></td>
						</tr>
						<tr>
							<td></td>
							<td><input type="submit" value="Salvar"> <input
								type="submit" value="Cancelar"
								onclick="document.getElementById('formUser').action ='salvarProduto?acao=reset' "></td>
						</tr>
					</table>

				</li>
			</ul>
		</form>
	</center>

	<div class="container">
		<table class="responsive-table">

			<caption>Lista de Produtos </caption>

			<tr>
				<td>Id</td>
				<td>Nome</td>
				<td>Quantidade</td>
				<td>Valor R$</td>
				<td>Editar</td>
				<td>Delete</td>
			</tr>

			<c:forEach items="${produtotabela}" var="user">
				<tr>
					<td style="width: 150px"><c:out value="${user.id}"></c:out></td>

					<td style="width: 150px"><c:out value="${user.nome}"></c:out></td>

					<td><c:out value="${user.quantidade}"></c:out></td>

					<td><c:out value="${user.valor}"></c:out></td>

					<td><a href="salvarProduto?acao=editar&user=${user.id}"><img
							alt="Editar" src="resources/img/editar.jpg" title="Editar"
							width="20px" height="20px"></a></td>

					<td><a href="salvarProduto?acao=delete&user=${user.id}"onclick="return confirm('Deseja Excluir?')"><img
							src="resources/img/excluir.jpg" alt="Excluir" title="Excluir"
							width="20px" height="20px"></a></td>


				</tr>
			</c:forEach>
		</table>
	</div>
	<script type="text/javascript">
		function validarCampos() {
			if (document.getElementById("nome").value == '') {
				alert('Informe o Nome');
				return false;

			} else if (document.getElementById("quantidade").value == '') {
				alert('Informe o Quantidade');
				return false;

			} else if (document.getElementById("valor").value == '') {
				alert('Informe o Valor');
				return false;
			}

			return true;
		}
	</script>

</body>
<script type="text/javascript">
	$(function() {
		$('#valor').maskMoney();
});

	$(document).ready(function() {
		$("#quantidade").keyup(function(){
			$("#quantidade").val(this.value.match(/[0-9]*/));
		});
		
	});
	</script>
</html>
