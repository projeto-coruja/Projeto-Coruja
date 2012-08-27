<!doctype html>
<%@page import="webview.servlets.SearchWorker"%>
<html>
<head>
<meta charset="utf-8">
<title>Gr�o-Par�</title>

<!-- Import dos styles CSS -->
<link rel="stylesheet" type="text/css"
	href="/GraoPara/css/principal.css" />
<link rel="stylesheet" type="text/css" href="/GraoPara/css/tabs.css" />
<link rel="stylesheet" type="text/css" href="/GraoPara/css/controle.css" />

<!-- Import dos javascripts -->
<script type="text/javascript" src="/GraoPara/javascript/cookie.js"
	charset="utf-8"></script>


</head>
<body onloadstart="checkCookie()">
	<div class="container">
		<div class="header"></div>
		<!-- Fim do Banner -->
		
		<!-- Come�o do menu lateral -->
		<div class="sidebar1">

			<!-- ----------------------------------------------------------------------- come�a-->

			<!--Come�o da �rea de login -->
			<div class="LoginArea" id="loginDefault">
				<form method="post" action="/GraoPara/doLogin">
					<fieldset>
						<label for="login">Login:</label> <input class="inputLogin"
							type="text" name="login" height="30px" size="auto"
							placeholder="Seu login" required> <label for="senha">Senha:</label>
						<input class="inputLogin" type="password" name="senha"
							height="30px" size="auto" placeholder="Sua senha" required>
					</fieldset>
					<fieldset>
						<input class="buttonEntrar" type="submit" name="Entrar"
							value="Entrar" />
					</fieldset>
				</form>
			</div>
			<fieldset>
				<a href="/GraoPara/public/CadUsuario.jsp"><input type="button"
					class="buttonRegistrar" name="Registrar" value="Registrar"></a>
			</fieldset>
			<!-- Fim da �rea de login -->

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
		<h2>Listagem de Documentos</h2>
			<table class="tableList">
				<tr class="trList">
					<td class="tdList"><label class="labelExibe">Identifica��o</label></td>
					<td class="tdList"><label class="labelExibe">C�digo</label></td>
					<td class="tdList"><label class="labelExibe">T�tulo</label></td>
					<td class="tdList"><label class="labelExibe">Tipo de N�mero</label></td>
					<td class="tdList"><label class="labelExibe">N�mero</label></td>
					<td class="tdList"><label class="labelExibe">Autor</label></td>
					<td class="tdList"><label class="labelExibe">Destinat�rio</label></td>
					<td class="tdList"><label class="labelExibe">Local</label></td>
					<td class="tdList"><label class="labelExibe">Data</label></td>
					<td class="tdList"><label class="labelExibe">Documento</label></td>
					<td class="tdList"><label class="labelExibe">Palavras-Chaves</label></td>
					<td class="tdList"><label class="labelExibe">A��es</label></td>
				</tr>

				<% SearchWorker.listAllDocuments(request, out); %>
				
			</table>
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
