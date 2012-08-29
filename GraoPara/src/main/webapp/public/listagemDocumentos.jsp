<!doctype html>
<%@page import="webview.servlets.SearchWorkerPublic"%>
<html>
<head>
<meta charset="utf-8">
<title>Grão-Pará</title>

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
		
		<!-- Começo do menu lateral -->
		<div class="sidebar1">

			<!-- ----------------------------------------------------------------------- começa-->

			<!--Começo da área de login -->
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
			<!-- Fim da área de login -->

			<article class="menuLateral">
				<ul class="nav" id="menu">
					<li><a href="/GraoPara/public/index.jsp">Home</a></li>
					<li><a href="/GraoPara/public/pesquisa.jsp">Pesquisar</a></li>
					<li><a href="/GraoPara/public/sobre.jsp">Sobre</a></li>
					<li><a href="/GraoPara/public/creditos.jsp">Créditos</a></li>
				</ul>
			</article>
		</div>
		<!-- Fim do Menu Lateral -->
		<div class="content" id="content">
		<h2>Listagem de Documentos</h2>
			<table class="tableList">
				<tr class="trList">
					<td class="tdList"><label class="labelExibe">Identificação</label></td>
					<td class="tdList"><label class="labelExibe">Código</label></td>
					<td class="tdList"><label class="labelExibe">Título</label></td>
					<td class="tdList"><label class="labelExibe">Tipo de Número</label></td>
					<td class="tdList"><label class="labelExibe">Número</label></td>
					<td class="tdList"><label class="labelExibe">Autor</label></td>
					<td class="tdList"><label class="labelExibe">Destinatário</label></td>
					<td class="tdList"><label class="labelExibe">Local</label></td>
					<td class="tdList"><label class="labelExibe">Data</label></td>
					<td class="tdList"><label class="labelExibe">Tipo de Documento</label></td>
					<td class="tdList"><label class="labelExibe">Palavras-Chave</label></td>
				</tr>

				<% SearchWorkerPublic.listAllDocuments(request, out); %>
				
			</table>
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
