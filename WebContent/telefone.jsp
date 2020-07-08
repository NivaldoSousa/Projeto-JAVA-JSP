<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de Telefones</title>
<link rel="stylesheet" href="resources/css/cadastro.css">

</head>
<body>
	<a href="acessoliberado.jsp"><img alt="Inicio" 	title= "Inicio" src="resources/img/iconeInicio.png" width="34px" height="34px"></a></a>
	<a href="index.jsp"><img alt="Sair" title= "Sair" src="resources/img/iconeSair.jpg" width="39px" height="39px"></a>

	<center>
		<h1>Cadastro de Telefones</h1>
		<h3 style="color: red">${msg}</h3>
	</center>


	<form action="salvarTelefone" method="post" id="formUser">
		<ul class="form-style-1">
			<li>
				<center>
					<table>

						<tr>
							<td>User:</td>
							<td><input type="text" readonly="readonly" id="id" name="id"
								class="field-long" value="${userEscolhido.id}"></td>

							<td><input type="text" readonly="readonly" id="nome"
								name="nome" class="field-long" value="${userEscolhido.nome}"></td>
						</tr>

						<tr>
							<td>Número:</td>
							<td><input type="text" id="numero" name="numero"></td>
							<td><select id="tipo" name="tipo" style="width: 185px;">
									<option>Casa</option>
									<option>Contato</option>
									<option>Celular</option>
							</select></td>

						</tr>

						<tr>

							<td></td>
							<td><input type="submit" value="Salvar"> <input
								type="submit" value="Voltar"
								onclick="document.getElementById('formUser').action ='salvarTelefone?acao=voltar'">
							</td>
						</tr>

					</table>
				</center>
			</li>
		</ul>
	</form>



	<div class="container">
		<table class="responsive-table">

			<caption>Lista Telefones </caption>

			<tr>
				<th>Id</th>
				<th>Numero</th>
				<th>Tipo</th>
				<th>Excluir</th>

			</tr>
			<c:forEach items="${telefone}" var="fone">
				<tr>
					<td style="width: 150px"><c:out value="${fone.id}"></c:out></td>

					<td style="width: 150px"><c:out value="${fone.numero}"></c:out></td>

					<td><c:out value="${fone.tipo}"></c:out></td>



					<td><a href="salvarTelefone?acao=deleteFone&foneId=${fone.id}" onclick="return confirm('Deseja Excluir?')"><img
							src="resources/img/excluir.jpg" alt="Excluir" title="Excluir"
							width="20px" height="20px"></a></td>


				</tr>
			</c:forEach>
		</table>
	</div>
	<script type="text/javascript">
		function validarCampos() {

			if (document.getElementById('formUser').action != 'salvarTelefone?acao=Voltar') {

				if (document.getElementById("numero").value == '') {
					alert('Informe o Número');
					return false;

				} else if (document.getElementById("tipo").value == '') {
					alert('Informe o Tipo');
					return false;
				}
			}
			return true;

		}
	</script>

</body>

</html>