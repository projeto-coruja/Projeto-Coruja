<!doctype html>
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
<script type="text/javascript" src="/GraoPara/javascript/cookie.js"
	charset="utf-8"></script>
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"
	charset="utf-8"></script>
<script src="/GraoPara/javascript/chili-1.7.pack.js"
	type="text/javascript"></script>
	
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
							<li><a href="/GraoPara/protected/admin/indexAdmin.jsp">Home</a></li>
							<li><a href="/GraoPara/protected/admin/pesquisaAdmin.jsp">Pesquisar</a></li>
							<li><a href="/GraoPara/protected/admin/painelAdmin.jsp">Painel Admin</a></li>					
							<li><a href="/GraoPara/protected/admin/gerarSenha.jsp">Gerar Senha</a></li>					
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
							<li><a href="/GraoPara/protected/admin/cadastroDocumentosAdmin.jsp">Cadastrar Documento</a></li>					
							<li><a href="/GraoPara/protected/admin/cadastrarPalavrasChave.jsp">Cadastrar Palavras-Chave</a></li>									
							<li><a href="/GraoPara/protected/admin/cadastrarOrigem.jsp">Cadastrar C�dices/Caixas</a></li>					
							<li><a href="/GraoPara/protected/admin/cadastrarTipoDocumento.jsp">Cadastrar Tipo de Documento</a></li>	
							<li><a href="/GraoPara/protected/admin/cadUserAdmin.jsp">Cadastrar Usu�rio</a></li>
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
							<li><a href="/GraoPara/protected/admin/tutorialPesquisaAdmin.jsp">Como pesquisar no acervo</a></li>					
							<li><a href="/GraoPara/protected/admin/sobreAdmin.jsp">Sobre</a></li>		
							<li><a href="/GraoPara/protected/admin/creditosAdmin.jsp">Cr�ditos</a></li>								
						</ul>
					</article>
					</div>
					<b class="b4"></b><b class="b3"></b><b class="b2"></b><b class="b1"></b>
				</div>
		</div>
		<!-- Fim do Menu Lateral -->
		<div class="content" id="content">
		
			<h1>Editar Palavra Chave</h1>
			
			<form id="signupform" autocomplete="off" method="get" action="/GraoPara/protected/admin/doChangesToKeyWord">
				<table class="tableControle">					
					<tr>
						<td class="tdControle">
							<label class="labelForms" id="lpalavraAntiga" for="palavraAntiga">Palavra Chave Antiga:</label>
						</td>
						<td class="field">
							<input class="input" id="palavraAntiga" name="palavraAntiga" type="text" value="<%= request.getParameter("palavra") %>" maxlength="32" readonly="readonly"/>
						</td>
						<td class="status"></td>
					</tr>					
					<tr>
						<td class="tdControle">
							<label class="labelForms" id="lpalavraNova" for="palavraNova">Palavra Chave Nova:<span class="asterisco">*</span></label>
						</td>
						<td class="field">
							<input class="input" id="palavra" name="palavra" type="text" value="" maxlength="32" />
						</td>
						<td class="status"></td>
					</tr>
					<tr>
						<td class="tdControle" colspan="3">
						<p></p>
							<input class="buttonCancelar" type="button" value="Cancelar" onClick="history.go(-1)"> <input class="buttonRegistrar" id="signupsubmit" name="Enviar" type="submit" value="Enviar" />
						</td>
					</tr>
					<tr>
						<td class="field">
							<input type="hidden" id="from" name="from" type="text" value="cadastrarPalavrasChave.jsp"/>
						</td>
						<td class="field">
							<input type="hidden" id="action" name="action" type="text" value="edit"/>
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
