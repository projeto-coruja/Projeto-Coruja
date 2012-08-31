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
			<div class="LoginArea" id="logado">
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
					<li><a href="/GraoPara/protected/admin/painelAdmin.jsp">Painel Admin</a></li>
					<li><a href="/GraoPara/protected/admin/pesquisaAdmin.jsp">Pesquisar</a></li>
					<li><a href="/GraoPara/protected/admin/cadastroDocumentosAdmin.jsp">Cadastrar Documento</a></li>					
					<li><a href="/GraoPara/protected/admin/cadastrarPalavrasChave.jsp">Cadastrar Palavras-Chave</a></li>						
					<li><a href="/GraoPara/protected/admin/cadastrarTipoDocumento.jsp">Cadastrar Tipo de Documento</a></li>	
					<li><a href="/GraoPara/protected/admin/cadUserAdmin.jsp">Cadastrar Usu�rio</a></li>					
					<li><a href="/GraoPara/protected/admin/gerarSenha.jsp">Gerar Senha</a></li>
					<li><a href="/GraoPara/protected/admin/sobreAdmin.jsp">Sobre</a></li>		
					<li><a href="/GraoPara/protected/admin/creditosAdmin.jsp">Cr�ditos</a></li>	
					<li><a href="/GraoPara/protected/admin/tutorialPesquisaAdmin.jsp">Como pesquisar no acervo</a>			
				</ul>
			</article>
		</div>
		<!-- Fim do Menu Lateral -->
		<div class="content" id="content">
				<h1>Cadastro Usu�rio</h1>
			<form id="signupform" autocomplete="off" method="post" action="/GraoPara/doChangesToAccount?action=editPermission">
				<table class="tableForms">
					<tr>
						<td class="labelForms" colspan="3">
							<strong>PREENCHA TODOS OS CAMPOS COM ASTER�SCO <span class="asterisco">*</span></strong>
						</td>
					</tr>
					<tr>
						<td>
							<label class="labelForms" id="lfirstname" for="nome">Nome Completo:<span class="asterisco">*</span></label>
						</td>
						<td class="field">
							<input class="inputLong" id="nome" name="nome" type="text" value="<%= request.getParameter("paramName") %>" maxlength="100" readonly="readonly" />
						</td>
						<td class="status"></td>
					</tr>
					<tr>
						<td>
							<label class="labelForms"  id="lemail" for="email" >Email:<span class="asterisco">*</span></label>
						</td>
						<td class="field">
							<input class="inputLong" id="email" name="email" type="text" value="<%= request.getParameter("paramEmail") %>" maxlength="150" readonly="readonly"/>
						</td>
						<td class="status"></td>
					</tr>
						<tr>
						<td>
							<label class="labelForms" id="lpermissao" for="permissao">Permiss�o<span class="asterisco">*</span></label>
						</td>
						<td class="field">
							<select name="permissao" class="input" id="permissao">
									<option value="">Selecione...</option>
									<% PanelWorker.listAllAvailablePofile(request, out); %>
							</select>
						</td>
						<td class="status"></td>
					</tr>
					<tr>
						<td class="tdControle" colspan="3">
						<p></p>
							<input class="buttonCancelar" type="button" value="Cancelar" onClick="history.go(-1)"> <input class="buttonRegistrar" id="signupsubmit" name="Enviar" type="submit" value="Enviar" />
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

