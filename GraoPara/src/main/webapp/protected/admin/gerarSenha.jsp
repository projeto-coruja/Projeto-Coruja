<!doctype html>
<%@page import="webview.servlets.PanelWorker"%>
<%@page import="webview.WebUtility"%>
<html>
<head>
<meta charset="utf-8">
<title>Gr�o-Par�</title>


<!-- Import dos styles CSS -->
<link rel="stylesheet" type="text/css"
	href="/GraoPara/css/principal.css" />
<link rel="stylesheet" type="text/css" href="/GraoPara/css/tabs.css" />
<link rel="stylesheet" type="text/css" href="/GraoPara/css/controle.css" />

<!-- CSS das valida��es -->
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
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"charset="utf-8"></script>

	<!-- Import dos scripts de valida��o de formul�rio -->
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

		<!-- Come�o do menu lateral -->
		<div class="sidebar1">

			<!--Depois de logado-->
			<div class="LoginArea" id="logado" style="display: block;">
				<form method="post" action="/GraoPara/doLogout">
					<fieldset>
						<label for="login">Bem vindo</label>
						<%
							WebUtility.printName(request, out);
						%>
					</fieldset>
					<fieldset>
						<input class="buttonSair" type="submit" name="Sair" value="Sair" />
					</fieldset>
				</form>
			</div>
			<!-- ----------------------------------------------------------------------- -->

					<article class="menuLateral">
				<ul class="nav" id="menu">
					<li><a href="/GraoPara/protected/admin/indexAdmin.jsp">Home</a></li>
					<li><a href="/GraoPara/protected/admin/pesquisaAdmin.jsp">Pesquisar</a></li>
					<li><a href="/GraoPara/protected/admin/cadastroDocumentosAdmin.jsp">Cadastrar Documento</a></li>
					<li><a href="/GraoPara/protected/admin/cadUserAdmin.jsp">Cadastrar Usu�rio</a></li>					
					<li><a href="/GraoPara/protected/admin/painelAdmin.jsp">Painel Admin</a></li>
					<li><a href="/GraoPara/protected/admin/gerarSenha.jsp">Gerar Senha</a></li>
					<li><a href="/GraoPara/protected/admin/sobreAdmin.jsp">Sobre</a></li>		
					<li><a href="#">Cr�ditos</a></li>		
												
				</ul>
			</article>
		</div>
		<!-- Fim do Menu Lateral -->
		<div class="content" id="content">
		<h2> Gerar Nova Senha para Usu�rio</h2>
		<form action="/GraoPara/doPasswordRecovery" id="signupform"  method="post" autocomplete="off">
				<table class="tableControle">				
				<tr>
						<td>
							<label class="labelForms"  id="lemail" for="email">Email do usu�rio Cadastrado:<span class="asterisco">*</span></label>
						</td>
						<td class="field">
							<input class="input" id="email" name="email" type="text" value="" maxlength="150" />
						</td>
						<td class="status"></td>
					</tr>				
				<tr>
						<td class="field" colspan="3">
						<p></p>
							<input class="buttonEntrar" id="signupsubmit" name="Enviar" type="submit" value="Gerar Senha Aleat�ria" />
						</td>
				</tr>
				</table>
				</form>	
			</div>
		<!-- Come�o do Rodap� -->
		<div class="footer">
			<p>Copyright � - Universidade Federal de S�o Paulo - UNIFESP 2012</p>
			<p>Desenvolvido pelo grupo Coruja</p>
		</div>
		<!-- Fim do Rodap� -->
		<!-- end .container -->
	</div>
</body>
</html>