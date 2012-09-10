<!doctype html>
<%@page import="webview.servlets.PanelWorker"%>
<%@page import="webview.WebUtility"%>
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
							<li><a href="/GraoPara/protected/admin/cadastrarOrigem.jsp">Cadastrar Códices/Caixas</a></li>					
							<li><a href="/GraoPara/protected/admin/cadastrarTipoDocumento.jsp">Cadastrar Tipo de Documento</a></li>	
							<li><a href="/GraoPara/protected/admin/cadUserAdmin.jsp">Cadastrar Usuário</a></li>
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
							<li><a href="/GraoPara/protected/admin/creditosAdmin.jsp">Créditos</a></li>								
						</ul>
					</article>
					</div>
					<b class="b4"></b><b class="b3"></b><b class="b2"></b><b class="b1"></b>
				</div>
		</div>
		<!-- Fim do Menu Lateral -->
		<div class="content" id="content">
			<h1>Painel de Controle</h1>
			<!-- <form class="control">
				<table class="tableControle">
					<tr>
						<th colspan="3" align="center">Painel de controle</th>
					</tr>

					<tr>
						<td><label for="documentos">Meus documentos: </label></td>
						<td colspan="2"><select class="inputControle"
							name="documentos">
								<option selected>Selecione...</option>
								<option value="Script">Script</option>
						</select></td>

					</tr>
					<tr>
						<td><input type="button" class="buttonDocumento"
							value="Visualizar" name="Visualizar"
							alt="Verificar campos de cadastro desse documento"></td>
						<td><input type="button" class="buttonDocumento"
							value="Alterar" name="Alterar"
							alt="Alterar os campos de cadastro desse documento"></td>
						<td><input type="button" class="buttonDocumento"
							value="Deletar" name="Deletar"
							alt="Deletar o registro desse documento"></td>
					</tr>
				</table>
			</form> -->
			<!-- Novo formulário para mudança de senha -->
			<form id="signupform" autocomplete="off"
				action="/GraoPara/doChangesToAccount?action=editPassword" method="post">
				<table class="tableControle">
					<tr>
						<th colspan="3" align="center">Mudar Senha Atual</th>
					</tr>
					<tr>
						<td class="tdControle"><label class="labelForms" id="lpassword" for="password">Senha
								Atual:<span class="asterisco">*</span>
						</label></td>
						<td class="field"><input id="senhaAtual" class="input"
							name="senhaAtual" type="password" maxlength="50" value="" /></td>
						<td class="status"></td>
					</tr>
					<tr>
						<td class="tdControle"><label class="labelForms" id="lpassword" for="password">Nova
								Senha:<span class="asterisco">*</span>
						</label></td>
						<td class="field"><input id="senhaNova" class="input"
							name="senhaNova" type="password" maxlength="50" value="" /></td>
						<td class="status"></td>
					</tr>
					<tr>
						<td class="tdControle"><label class="labelForms" id="lpassword" for="password">Confirme
								Nova Senha:<span class="asterisco">*</span>
						</label></td>
						<td class="field"><input id="senhaConfirme" class="input"
							name="senhaConfirme" type="password" maxlength="50" value="" />
						</td>
						<td class="status"></td>
					</tr>
					<tr>
						<td class="tdForms">
							<p></p>
							<input class="buttonRegistrar" id="signupsubmit" name="Alterar" type="submit" value="Alterar" />
						</td>
					</tr>
				</table>
			</form>
			<!-- Novo formulário para novos usuários -->

			<br>

			<article class="tabsCSS">
				<!-- <section id="tab1">
					<h2>
						<a href="#tab1">Palavras-Chaves Pendentes</a>
					</h2>
					<div class="scroll">
						<table class="tablePainel">
							<thead>
								<tr>
									<td width="120" height="20"><label for="identificacao"
										class="labelExibe">ID</label></td>
									<td width="120" height="20"><label for="identificacao"
										class="labelExibe">Palavra-Chave</label></td>
									<td width="120" height="20"><label for="identificacao"
										class="labelExibe">Status</label></td>
									<td width="120" height="20"><label for="identificacao"
										class="labelExibe">Ação</label></td>
								</tr>
							</thead>
							<tbody>
								<%
									//PanelWorker.listAllNewKeyWords(request, out);
								%>
							</tbody>
						</table>
					</div>
				</section> -->

				<section id="tab1">
					<h2>
						<a href="#tab1">Novos Usuários</a>
					</h2>
					<div class="scroll">
						<form action="">
							<table class="tablePainel">
								<thead>
									<tr>
										<td><label for="identificacao" class="labelExibe">Nome</label></td>
										<td><label for="identificacao" class="labelExibe">Email</label></td>
										<td><label for="identificacao" class="labelExibe">Permissão</label></td>
										<td><label for="identificacao" class="labelExibe">Ação</label></td>
									</tr>
								</thead>
								<tbody>
									<%
										PanelWorker.listAllNewUsers(request, out);
									%>
								</tbody>
							</table>
						</form>
					</div>
				</section>

				<section id="tab2">
					<h2>
						<a href="#tab2">Usuários</a>
					</h2>
					<div class="scroll">
						<table class="tablePainel">
							<thead>
								<tr>
									<td><label for="identificacao" class="labelExibe">Nome</label></td>
									<td><label for="identificacao" class="labelExibe">Email</label></td>
									<td><label for="identificacao" class="labelExibe">Permissão</label></td>
									<td><label for="identificacao" class="labelExibe">Ação</label></td>
								</tr>
							</thead>
							<tbody>
								<%
									PanelWorker.listAllUsers(request, out);
								%>
							</tbody>
						</table>
					</div>
				</section>

			</article>

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

