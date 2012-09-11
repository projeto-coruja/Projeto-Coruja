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

			<!--Come�o da �rea de login -->
			<div class="bordaBox">
				<b class="b1"></b><b class="b2"></b><b class="b3"></b><b class="b4"></b>
				<div class="conteudo">
					<div class="LoginArea" id="loginDefault" style="display:block;">
						<form method="post" action="/GraoPara/doLogin">
							<fieldset>
								<label class="sidebar" for="login">Login:</label> <input class="inputLogin"
									type="text" name="login" height="30px" size="auto"
									placeholder="Seu login" required> <label class="sidebar" for="senha">Senha:</label>
								<input class="inputLogin" type="password" name="senha"
									height="30px" size="auto" placeholder="Sua senha" required>
							</fieldset>
							<fieldset>
								<input class="buttonEntrar" type="submit" name="Entrar"
									value="Entrar" />											
							</fieldset>
							<fieldset>
								<a href="/GraoPara/public/CadUsuario.jsp"><input type="button"
									class="buttonRegistrar" name="Registrar" value="Registrar"></a>
							</fieldset>						
							</form>
						</div>
				</div>
				<b class="b4"></b><b class="b3"></b><b class="b2"></b><b class="b1"></b>
			</div>
			<!-- Fim da �rea de login -->
			<div class="bordaBox">
				<b class="b1"></b><b class="b2"></b><b class="b3"></b><b class="b4"></b>
				<div class="conteudo">
					<article class="menuLateral">
						<ul class="nav" id="menu">
							<li><a href="/GraoPara/public/index.jsp">Home</a></li>
							<li><a href="/GraoPara/public/pesquisa.jsp">Pesquisar</a></li>
							<li><a href="/GraoPara/public/sobre.jsp">Sobre</a></li>
							<li><a href="/GraoPara/public/creditos.jsp">Cr�ditos</a></li>
							<li><a href="/GraoPara/public/tutorialPesquisa.jsp">Como pesquisar no acervo</a></ul>
					</article>
				</div>
				<b class="b4"></b><b class="b3"></b><b class="b2"></b><b class="b1"></b>
			</div>
		</div>
			<!-- Fim do Menu Lateral -->
		<div class="content" id="content">
		<h2>Listagem de Documentos</h2>
			<div align="right">
				<form action="GraoPara/doDownload">
					<input type="submit" name="download" class="buttonDownload" value="Download Pesquisa"/>
				</form>
			</div>
			<div class="scrollLong">
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
					</tr>
	
					<% SearchWorker.listAllDocuments(request, out); %>
					
				</table>
			</div>
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
