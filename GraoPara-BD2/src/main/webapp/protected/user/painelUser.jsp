<!doctype html>
<%@page import="webview.util.WebUtility"%>
<html>
<head>
<meta charset="utf-8">
<title>Grão-Pará</title>

<!-- Import dos styles CSS -->
<link rel="stylesheet" type="text/css"
	href="/GraoPara/css/principal.css" />
<link rel="stylesheet" type="text/css" href="/GraoPara/css/tabs.css" />
<link rel="stylesheet" type="text/css" href="/GraoPara/css/controle.css" />

<!-- CSS das validações -->
<link rel="stylesheet" type="text/css" media="screen"
	href="/GraoPara/css/styleValidation.css" />

<!-- Import dos javascripts -->
<script type="text/javascript" src="/GraoPara/javascript/ajax.js"
	charset="utf-8"></script>
<script type="text/javascript" src="/GraoPara/javascript/instrucao.js"
	charset="utf-8"></script>
<script src="/GraoPara/javascript/chili-1.7.pack.js"
	type="text/javascript"></script>
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"
	charset="utf-8"></script>

<!-- Import dos scripts de validação de formulário -->
<script src="/GraoPara/javascript/jquery.js" type="text/javascript"
	charset="utf-8"></script>
<script src="/GraoPara/javascript/validate.js" type="text/javascript"
	charset="utf-8"></script>
<script src="/GraoPara/javascript/validate_pt_br.js"
	type="text/javascript" charset="utf-8"></script> 

</head>

<body>

	<div class="container">
		<div class="header"></div>
		
<!-- Começo do menu lateral -->
		<div class="sidebar1">

			<!--Depois de logado-->
			<div class="bordaBox">
				<b class="b1"></b><b class="b2"></b><b class="b3"></b><b class="b4"></b>
				<div class="conteudo">
					<div class="LoginArea" id="logado" style="display:block;">
						<form method="post" action="/GraoPara/doLogout">
							<fieldset>
								<label class="sidebar" for="login">Bem vindo
								<%
									WebUtility.printName(request, out);
								%>
								</label>
							</fieldset>
							<fieldset>
								<input class="buttonSair" type="submit" name="Sair" value="Sair" />
							</fieldset>
						</form>
					</div>
				</div>
				<b class="b4"></b><b class="b3"></b><b class="b2"></b><b class="b1"></b>
			</div>
			<!-- ----------------------------------------------------------------------- -->
			<div class="bordaBox">
				<b class="b1"></b><b class="b2"></b><b class="b3"></b><b class="b4"></b>
				<div class="conteudo">
					<article class="menuLateral">  
						<ul class="nav" id="menu">
							<li><a href="/GraoPara/protected/user/indexUser.jsp">Home</a></li>
							<li><a href="/GraoPara/protected/user/pesquisaUser.jsp">Pesquisar</a></li>
							<li><a href="/GraoPara/protected/user/cadastroDocumentosUser.jsp">Cadastrar Documento</a></li>
							<li><a href="/GraoPara/protected/user/painelUser.jsp">Painel User</a></li>
						</ul>
					</article>
				</div>
				<b class="b4"></b><b class="b3"></b><b class="b2"></b><b class="b1"></b>
			</div>	
			<div class="bordaBox">
				<b class="b1"></b><b class="b2"></b><b class="b3"></b><b class="b4"></b>
				<div class="conteudo">
					<article class="menuLateral">
						<ul class="nav" id="menu">
							<li><a href="/GraoPara/protected/user/tutorialPesquisaUser.jsp">Como pesquisar no acervo</a>
							<li><a href="/GraoPara/protected/user/sobreUser.jsp">Sobre</a></li>
							<li><a href="/GraoPara/protected/user/creditosUser.jsp">Créditos</a></li>							
						</ul>
					</article>
				</div>
				<b class="b4"></b><b class="b3"></b><b class="b2"></b><b class="b1"></b>
			</div>	
		</div>
		<!-- Fim do Menu Lateral -->
		<div class="content" id="content">
			<!-- 	<form>
				<table class="tableControle">
				<tr>
					<th colspan="3" align="center">Painel de controle </th>
				</tr>
				
				<tr>
					<td><label for="documentos">Meus documentos: </label></td>
					<td colspan="2"><select class="inputControle" name="documentos">
					<option selected>Selecione...</option>
					<option value="Script"> Script </option>
					</select>
					</td>
					
				</tr>
				<tr>
					<td><input type="button" class="buttonDocumento" value="Visualizar" name="Visualizar" alt="Verificar campos de cadastro desse documento"></td>
					<td><input type="button" class="buttonDocumento" value="Alterar" name="Alterar" alt="Alterar os campos de cadastro desse documento"></td>
					<td><input type="button" class="buttonDocumento" value="Deletar" name="Deletar" alt="Deletar o registro desse documento"></td>
				</tr>
				</table>
				</form> -->
				<!-- Novo formulário para mudança de senha --> 
				<h1>Painel de Controle</h1>
				<form id="signupform" autocomplete="off" action="/GraoPara/doChangesToAccount?action=editPassword" method="post">
					<table class="tableControle">
					<tr>
						<td colspan="3"><label class="labelForms"><strong>MUDAR SENHA ATUAL</strong></label></td>
					</tr>
					<tr>
						<td class="tdControle">
							<label class="labelForms"  id="lpassword" for="password">Senha Atual:<span class="asterisco">*</span></label></td>
						<td class="field">
							<input id="senhaAtual" class="input" name="senhaAtual" type="password" maxlength="50" value="" />
						</td>
						<td class="status"></td>
					</tr>
					<tr>
						<td class="tdControle">
							<label class="labelForms"  id="lpassword" for="password">Nova Senha:<span class="asterisco">*</span></label></td>
						<td class="field">
							<input id="senhaNova" class="input" name="senhaNova" type="password" maxlength="50" value="" />
						</td>
						<td class="status"></td>
					</tr>
					<tr>
						<td class="tdControle">
							<label class="labelForms"  id="lpassword" for="password">Confirme Nova Senha:<span class="asterisco">*</span></label></td>
						<td class="field">
							<input id="senhaConfirme" class="input" name="senhaConfirme" type="password" maxlength="50" value="" />
						</td>
						<td class="status"></td>
					</tr>
					<tr>
						<td class="tdForms">
							<p></p>
							<input class="buttonRegistrar" id="signupsubmit" name="inserir" type="submit" value="Enviar" />
						</td>
					</tr>
					</table>
				</form>				
		
		</div>
		<!-- Começo do Rodapé -->
		<div class="footer">
			<p>Copyright © - Universidade Federal de São Paulo - UNIFESP 2012</p>
			<p>Desenvolvido pelo grupo Coruja</p>
		</div>
		<!-- Fim do Rodapé -->
		<!-- end .container -->
	</div>
</body>
</html>
