<%@page import="beans.BeanCursoJsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de usuário</title>
<link rel="stylesheet" href="resources/css/cadastro.css">

<!-- Adicionando JQuery -->
<script src="https://code.jquery.com/jquery-3.4.1.min.js"
	integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
	crossorigin="anonymous"></script>


</head>
<body>
	<a href="acessoliberado.jsp"><img alt="Inicio" title="Inicio"
		src="resources/img/iconeInicio.png" width="34px" height="34px"></a>
	<a href="index.jsp"><img alt="Sair" title="Sair"
		src="resources/img/iconeSair.jpg" width="39px" height="39px"></a>
	<center>
		<h1>Cadastro de usuário</h1>
		<h3 style="color: red">${msg}</h3>
	</center>


	<form action="salvarUsuario" method="post" id="formUser"
		enctype="multipart/form-data">
		<ul class="form-style-1">
			<li>
				<center>
					<table>

						<tr>
							<td>Código:</td>
							<td><input type="text" readonly="readonly" id="id" name="id"
								value="${user.id}" class="field-long" style="width: 185px;"></td>

							<td>Cep:</td>
							<td><input type="text" id="cep" name="cep"
								onblur="consultaCep()" value="${user.cep}"></td>

						</tr>

						<tr>
							<td>Login:</td>
							<td><input type="text" id="login" name="login"
								value="${user.login}" placeholder="Informe o login"
								maxlength="10"></td>

							<td>Rua:</td>
							<td><input type="text" id="rua" name="rua"
								value="${user.rua}"></td>
						</tr>


						<tr>
							<td>Senha:</td>
							<td><input type="password" id="senha" name="senha"
								value="${user.senha}" placeholder="Informe a senha"
								maxlength="10"></td>

							<td>Bairro:</td>
							<td><input type="text" id="bairro" name="bairro"
								value="${user.bairro}"></td>
						</tr>
						<tr>
							<td>Nome:</td>
							<td><input type="text" id="nome" name="nome"
								value="${user.nome}" placeholder="Informe o nome do usuário"
								maxlength="50"></td>

							<td>Cidade:</td>
							<td><input type="text" id="cidade" name="cidade"
								value="${user.cidade}"></td>
						</tr>

						<tr>
							<td>Estado:</td>
							<td><input type="text" id="estado" name="estado"
								value="${user.estado}"></td>

							<td>IBGE:</td>
							<td><input type="text" id="ibge" name="ibge"
								value="${user.ibge}"></td>
						</tr>

						<tr>
							<td>Ativo:</td>
							<td><input type="checkbox" id="ativo" name="ativo"
								<%if (request.getAttribute("user") != null) {
				BeanCursoJsp user = (BeanCursoJsp) request.getAttribute("user");

				if (user.isAtivo()) {
					out.print(" ");
					out.print("checked=\"checked\"");
					out.print(" ");
				}
			}%>>

							</td>

						</tr>

						<tr>

							<td>Sexo:</td>
							<td><input type="radio" name="sexo"
								<%if (request.getAttribute("user") != null) {
				BeanCursoJsp user = (BeanCursoJsp) request.getAttribute("user");
				if (user.getSexo().equalsIgnoreCase("masculino")) {
					out.print(" ");
					out.print("checked=\"checked\"");
					out.print(" ");
				}

			}%>
								value="masculino">Masculino <input type="radio"
								name="sexo"
								<%if (request.getAttribute("user") != null) {
				BeanCursoJsp user = (BeanCursoJsp) request.getAttribute("user");
				if (user.getSexo().equalsIgnoreCase("feminino")) {
					out.print(" ");
					out.print("checked=\"checked\"");
					out.print(" ");
				}

			}%>
								value="feminino">Feminino</td>

							<td>Foto:</td>
							<td><input type="file" name="foto"></td>
						</tr>

						<tr>
							<td>Perfil:</td>
							<td><select id="perfil" name="perfil" style="width: 150px;">

									<option value="nao_informado">SELECIONE</option>

									<option value="administrador"
										<%if (request.getAttribute("user") != null) {
				BeanCursoJsp user = (BeanCursoJsp) request.getAttribute("user");

				if (user.getPerfil().equalsIgnoreCase("administrador")) {
					out.print(" ");
					out.print("selected=\"selected\"");
					out.print(" ");
				}
			}%>>Administrador</option>

									<option value="secretario"
										<%if (request.getAttribute("user") != null) {
				BeanCursoJsp user = (BeanCursoJsp) request.getAttribute("user");

				if (user.getPerfil().equalsIgnoreCase("secretario")) {
					out.print(" ");
					out.print("selected=\"selected\"");
					out.print(" ");
				}
			}%>>Secretario(a)</option>

									<option value="gerente"
										<%if (request.getAttribute("user") != null) {
				BeanCursoJsp user = (BeanCursoJsp) request.getAttribute("user");

				if (user.getPerfil().equalsIgnoreCase("gerente")) {
					out.print(" ");
					out.print("selected=\"selected\"");
					out.print(" ");
				}
			}%>>Gerente</option>

									<option value="funcionario"
										<%if (request.getAttribute("user") != null) {
				BeanCursoJsp user = (BeanCursoJsp) request.getAttribute("user");

				if (user.getPerfil().equalsIgnoreCase("funcionario")) {
					out.print(" ");
					out.print("selected=\"selected\"");
					out.print(" ");
				}
			}%>>Funcionario</option>
							</select></td>

							<td>Curriculo:</td>
							<td><input type="file" name="curriculo" value="curriculo"></td>

						</tr>

						<tr>
							<td></td>
							<td><input type="submit" value="Salvar"> <input
								type="submit" value="Cancelar"
								onclick="document.getElementById('formUser').action ='salvarUsuario?acao=reset' "></td>
						</tr>
					</table>
				</center>
			</li>
		</ul>
	</form>
	<form method="post" action="serveletPesquisa">

		<ul class="form-style-1">
			<li>
				<center>
					<table>
						<tr>
							<td>Descrição</td>
							<td><input type="text" id="descricaoconsulta"
								name="descricaoconsulta"></td>
							<td><input type="submit" value="pesquisar"></td>
						</tr>

					</table>
				</center>
			</li>
		</ul>
	</form>
	<div class="container">
		
			<table class="responsive-table">

				<caption>Lista de Usuários</caption>

				<tr>

					<td>Id</td> 
					<td>Login</td> 
					<td>Imagem</td> 
					<td>PDF</td> 
					<td>Nome</td> 	
					<td>Fones</td>
					<td>Editar</td>
					<td>Delete</td>

				</tr>


				<c:forEach items="${usuario}" var="user">
					<tr>

						<td style="width: 150px"><c:out value="${user.id}"></c:out></td>

						<td style="width: 150px"><c:out value="${user.login}"></c:out></td>

						<c:if test="${user.fotoBase64Miniatura.isEmpty() == false}">
							<td><a
								href="salvarUsuario?acao=download&name=foto&user=${user.id}"><img
									src='<c:out value="${user.fotoBase64Miniatura}"/>'
									alt="Imagem User" title="Imagem User" width="20px"
									height="20px" /></a></td>
						</c:if>
						<c:if test="${user.fotoBase64Miniatura == null}">
							<td><img alt="Imagem User"
								src="resources/img/iconeUsuario.png" width="20px" height="20px"
								onclick="alert('Nao possui Imagem')"></td>
						</c:if>

						<c:if test="${user.curriculoBase64.isEmpty() == false}">
							<td><a
								href="salvarUsuario?acao=download&name=curriculo&user=${user.id}"><img
									alt="Curriculo" src="resources/img/iconepdf.png" width="20px"
									height="20px"></a></td>
						</c:if>
						<c:if test="${user.curriculoBase64 == null}">
							<td><img alt="Curriculo" src="resources/img/iconepdf.png"
								width="20px" height="20px" onclick="alert('Nao possui PDF')"></td>
						</c:if>

						<td><c:out value="${user.nome}"></c:out></td>


						<td><a href="salvarTelefone?acao=addFone&user=${user.id}"><img
								alt="Telefone" src="resources/img/telefone.png" title="Telefone"
								width="20px" height="20px"></a></td>

						<td><a href="salvarUsuario?acao=editar&user=${user.id}"><img
								alt="Editar" src="resources/img/editar.jpg" title="Editar"
								width="20px" height="20px"></a></td>

						<td><a href="salvarUsuario?acao=delete&user=${user.id}"
							onclick="return confirm('Deseja Excluir?')"><img
								src="resources/img/excluir.jpg" alt="Excluir" title="Excluir"
								width="20px" height="20px"></a></td>

					</tr>

				</c:forEach>
			</table>
		
	</div>
	<script type="text/javascript">
		function validarCampos() {
			if (document.getElementById("login").value == '') {
				alert('Informe o Login');
				return false;

			} else if (document.getElementById("senha").value == '') {
				alert('Informe o Senha');
				return false;

			} else if (document.getElementById("nome").value == '') {
				alert('Informe o Nome');
				return false;

			} else if (document.getElementById("fone").value == '') {
				alert('Informe o Telefone');
				return false;
			}
			return true;
		}

		function consultaCep() {
			var cep = $("#cep").val();

			//Consulta o webservice viacep.com.br/
			$.getJSON("https://viacep.com.br/ws/" + cep + "/json/?callback=?",
					function(dados) {

						if (!("erro" in dados)) {
							$("#rua").val(dados.logradouro);
							$("#bairro").val(dados.bairro);
							$("#cidade").val(dados.localidade);
							$("#estado").val(dados.uf);
							$("#ibge").val(dados.ibge);

						} //end if.
						else {
							$("#cep").val('');
							$("#rua").val('');
							$("#bairro").val('');
							$("#cidade").val('');
							$("#estado").val('');
							$("#ibge").val('');

							//CEP pesquisado não foi encontrado.
							alert("CEP não encontrado.");
						}
					});
		}
	</script>

</body>

</html>