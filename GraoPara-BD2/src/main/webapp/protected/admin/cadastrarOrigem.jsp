<!doctype html>
<%@page import="webview.worker.PanelWorker"%>
<%@page import="webview.util.WebUtility"%>

<html>
	<head>
		<meta charset="utf-8">
		
		<title>Grão-Pará</title>
		
		<!-- Import dos styles CSS -->
		<link rel="stylesheet" type="text/css" href="/GraoPara/css/principal.css" />
		<link rel="stylesheet" type="text/css" href="/GraoPara/css/tabs.css" />
		<link rel="stylesheet" type="text/css" href="/GraoPara/css/controle.css" />
		
		<!-- CSS das validacoes -->
		<link rel="stylesheet" type="text/css" media="screen" href="/GraoPara/css/styleValidation.css" />
		
		<!-- Import dos javascripts -->
		<script type="text/javascript" src="/GraoPara/javascript/ajax.js" charset="utf-8"></script>
		<script type="text/javascript" src="/GraoPara/javascript/instrucao.js" charset="utf-8"></script>
		<script src="/GraoPara/javascript/chili-1.7.pack.js" type="text/javascript"></script>
		<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js" charset="utf-8"></script>
		
		<!-- Import dos scripts de validacao de formulario -->
		<script src="/GraoPara/javascript/jquery.js" type="text/javascript" charset="utf-8"></script>
		<script src="/GraoPara/javascript/validate.js" type="text/javascript" charset="utf-8"></script>
		<script src="/GraoPara/javascript/validate_pt_br.js" type="text/javascript" charset="utf-8"></script>
	</head>
	
	<body>
		<div class="container">
			<div class="header"></div>
	
			<!-- Comeco do menu lateral -->
			<div class="sidebar1">
				<!--Depois de logado-->
				<div class="bordaBox">
					<b class="b1"></b>
					<b class="b2"></b>
					<b class="b3"></b>
					<b class="b4"></b>
					
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
					
					<b class="b4"></b>
					<b class="b3"></b>
					<b class="b2"></b>
					<b class="b1"></b>
				</div>
				<!-- ----------------------------------------------------------------------- -->
	
				<div class="bordaBox">
					<b class="b1"></b>
					<b class="b2"></b>
					<b class="b3"></b>
					<b class="b4"></b>
					
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
					
					<b class="b4"></b>
					<b class="b3"></b>
					<b class="b2"></b>
					<b class="b1"></b>
				</div>
				
				<div class="bordaBox">
					<b class="b1"></b>
					<b class="b2"></b>
					<b class="b3"></b>
					<b class="b4"></b>
					
					<div class="conteudo">
						<article class="menuLateral">
							<ul class="nav" id="menu">
								<li><a href="/GraoPara/protected/admin/cadastroDocumentosAdmin.jsp">Cadastrar Documento</a></li>					
								<li><a href="/GraoPara/protected/admin/cadastrarPalavrasChave.jsp">Cadastrar Palavras-Chave</a></li>									
								<li><a href="/GraoPara/protected/admin/cadastrarOrigem.jsp">Cadastrar Códices/Caixas</a></li>					
								<li><a href="/GraoPara/protected/admin/cadastrarTipoDocumento.jsp">Cadastrar Tipo de Documento</a></li>	
								<li><a href="/GraoPara/protected/admin/cadUserAdmin.jsp">Cadastrar Usuário</a></li>
							</ul>
						</article>
					</div>
					
					<b class="b4"></b>
					<b class="b3"></b>
					<b class="b2"></b>
					<b class="b1"></b>
				</div>
				
				<div class="bordaBox">
					<b class="b1"></b>
					<b class="b2"></b>
					<b class="b3"></b>
					<b class="b4"></b>
					
					<div class="conteudo">
						<article class="menuLateral">
							<ul class="nav" id="menu">	
								<li><a href="/GraoPara/protected/admin/tutorialPesquisaAdmin.jsp">Como pesquisar no acervo</a></li>					
								<li><a href="/GraoPara/protected/admin/sobreAdmin.jsp">Sobre</a></li>		
								<li><a href="/GraoPara/protected/admin/creditosAdmin.jsp">Créditos</a></li>								
							</ul>
						</article>
					</div>
					
					<b class="b4"></b>
					<b class="b3"></b>
					<b class="b2"></b>
					<b class="b1"></b>
				</div>
			</div>
			<!-- Fim do Menu Lateral -->
			
			<div class="content" id="content">
				<h1>Cadastro de Códices/Caixas</h1>
				
				<form action="/GraoPara/protected/admin/addOrigin" id="signupform" method="get" autocomplete="off">
					<table class="tableForms">
						<tr>
							<td class="tdForms">
								<label class="labelForms" id="lidentificacao" for="identificacao">Identificação:<span class="asterisco">*</span></label>
							</td>
							
							<td class="field">
								<select name="identificacao" class="input" id="identificacao">
										<option value="">Selecione...</option>
										<option value="codice">Número de Códice</option>
										<option value="caixa">Número da Caixa</option>
								</select>
							</td>
							
							<td class="status"></td>
						</tr>
						
						<tr>
							<td class="tdForms">
								<label class="labelForms" id="lcodigo" for="codigo">Código:<span class="asterisco">*</span></label>
							</td>
							
							<td class="field">
								<input class="input" name="codigo" size="10" id="codigo" type="text" maxlength="5">
							</td>
							
							<td class="status"></td>
						</tr>
						
						<tr>
							<td class="tdForms">
								<label class="labelForms" id="ltitulo" for="titulo">Título:<span class="asterisco">*</span></label>
							</td>
							
							<td class="field"><input class="input" name="titulo" id="titulo" type="text" size="20" maxlength="48"></td>
							
							<td class="status"></td>
						</tr>
						
						<tr>
							<td class="tdForms">
								<p></p> <input class="buttonRegistrar" id="signupsubmit"
								name="inserir" type="submit" value="Enviar" />
							</td>
						</tr>
					</table>
				</form>
				
				<!-- Duas quebras de linha -->
				<br>
				<br>
				
				<div class="scrollLong">
					<table class="tableList">
						<tr class="trList">
							<thead>
								<tr>
									<td class="tdList"><label for="identificacao"
										class="labelExibe">Identificação</label></td>
									<td class="tdList"><label for="codigo"
										class="labelExibe">Código</label></td>
									<td class="tdList"><label for="titulo"
										class="labelExibe">Títulos</label></td>
									<td class="tdList"><label for="acao"
										class="labelExibe">Ação</label></td>
								</tr>
							</thead>
						<tbody>
							<%
								PanelWorker.listAllCodex(request, out);
							%>
						</tbody>
					</table>
				</div>
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
