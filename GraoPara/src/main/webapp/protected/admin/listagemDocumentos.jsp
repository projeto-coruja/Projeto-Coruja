<!doctype html>
<%@page import="java.io.PrintWriter"%>
<%@page import="webview.WebUtility"%>
<%@page import="business.EJB.userEJB.AuthBean"%>
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

<!-- CSS das valida��es -->
<link rel="stylesheet" type="text/css"
	href="/GraoPara/css/validationEngine.jquery.css" />

<!-- Import dos javascripts -->
<script type="text/javascript" src="/GraoPara/javascript/cookie.js"
	charset="utf-8"></script>
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"
	charset="utf-8"></script>


</head>
<body onloadstart="checkCookie()">
	<div class="container">
		<div class="header"></div>

		<!-- Come�o do menu lateral -->
		<div class="sidebar1">

			<!--Depois de logado-->
			<div class="LoginArea" id="logado" style="display:block;">
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
					<li><a href="/GraoPara/protected/admin/cadastrarTipoDocumento.jsp">Cadastrar Tipo de Documento</a></li>					
					<li><a href="/GraoPara/protected/admin/gerarSenha.jsp">Gerar Senha</a></li>
					<li><a href="/GraoPara/protected/admin/sobreAdmin.jsp">Sobre</a></li>	
					<li><a href="/GraoPara/protected/admin/creditosAdmin.jsp">Cr�ditos</a></li>
					<li><a href="/GraoPara/protected/admin/tutorialPesquisaAdmin.jsp">Como pesquisar no acervo</a>				
				</ul>
			</article>
		</div>
		<!-- Fim do Menu Lateral -->
		<div class="content" id="content">
		<h1>Listagem de Documentos</h1>
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
					<td class="tdList"><label class="labelExibe">Tipo de Documento</label></td>
					<td class="tdList"><label class="labelExibe">Palavras-Chave</label></td>
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
