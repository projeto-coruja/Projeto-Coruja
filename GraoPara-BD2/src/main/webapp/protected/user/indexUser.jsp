<!doctype html>
<%@page import="webview.util.*"%>
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
							<li><a href="/GraoPara/protected/user/creditosUser.jsp">Cr�ditos</a></li>							
						</ul>
					</article>
				</div>
				<b class="b4"></b><b class="b3"></b><b class="b2"></b><b class="b1"></b>
			</div>	
		</div>
		<!-- Fim do Menu Lateral -->
		<div class="content" id="content">
		<h1> Gr�o-Par�: 1800-1850</h1>
			<p class="left">Bem-vindo a esta ferramenta colaborativa para a cria��o de verbetes sobre documentos ligados � hist�ria da capitania/prov�ncia do Par� na primeira metade do s�culo XIX. Atrav�s desse site, qualquer pesquisador tamb�m pode ter acesso integral aos verbetes j� redigidos a partir de diferentes formas de busca. </p>
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
