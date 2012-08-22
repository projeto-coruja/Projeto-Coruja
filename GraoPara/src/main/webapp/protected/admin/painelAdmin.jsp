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
<link rel="stylesheet" type="text/css"
	href="/GraoPara/css/validationEngine.jquery.css" />

<!-- Import dos javascripts -->
<script type="text/javascript" src="/GraoPara/javascript/ajax.js"
	charset="utf-8"></script>
<script type="text/javascript" src="/GraoPara/javascript/instrucao.js"
	charset="utf-8"></script>
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"
	charset="utf-8"></script>

<!-- Import dos scripts de validação de formulário -->
<script type="text/javascript"
	src="/GraoPara/javascript/jquery.validationEngine.js" charset="utf-8"></script>
<script type="text/javascript" src="/GraoPara/javascript/script.js"
	charset="utf-8"></script>
<script type="text/javascript"
	src="/GraoPara/javascript/languages/jquery.validationEngine-pt.js"
	charset="utf-8"></script>

</head>

<body>

	<div class="container">
		<div class="header"></div>

		<!-- Começo do menu lateral -->
		<div class="sidebar1">

			<!--Depois de logado-->
			<div class="LoginArea" id="logado" style="display: block;">
				<form method="post" action="/GraoPara/doLogout">
					<fieldset>
						<label for="login">Bem vindo</label>
						<%
							WebUtility.printHTML(request, out);
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
					<li><a
						href="/GraoPara/protected/admin/cadastroDocumentosAdmin.jsp">Cadastrar
							Documento</a></li>
					<li><a href="/GraoPara/protected/admin/painelAdmin.jsp">Painel
							Admin</a></li>
					<li><a href="/GraoPara/protected/admin/sobreAdmin.jsp">Sobre</a></li>
				</ul>
			</article>
		</div>
		<!-- Fim do Menu Lateral -->
		<div class="content" id="content">

			<form class="control">
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
			</form>
			<!-- Novo formulário para mudança de senha -->
			<form class="control">
				<table class="tableControle">
					<tr>
						<th colspan="3" align="center">Mudar Senha Atual</th>
					</tr>
					<tr>
						<td><label for="senhaAtual">Senha atual: </label></td>
						<td colspan="2"><input
							class="inputControle validate[required]" type="password"
							name="senhaAtual" id="senhaAtual" />
					</tr>
					<tr>
						<td><label for="senhaNova">Nova senha: </label></td>
						<td colspan="2"><input
							class="inputControle validate[required,minSize[6]]"
							id="senhaNova" type="password" name="senhaNova" />
					</tr>
					<tr>
						<td><label for="senhaConfirme">Confirme nova senha: </label></td>
						<td colspan="2"><input
							class="inputControle validate[required,equals[senhaNova]]"
							type="password" name="senhaConfirme" id="senhaConfirme" />
					</tr>
					<tr>

						<td><input type="button" class="buttonDocumento"
							value="Mudar" name="Mudar" alt="Mudar a senha atual."></td>
						<td></td>
						<td></td>
					</tr>
				</table>
			</form>
			<!-- Novo formulário para novos usuários -->

			<br>

			<article class="tabsCSS">
				<section id="tab1">
					<h2>
						<a href="#tab1">Palavras-Chaves Pendentes</a>
					</h2>
					<br>
					<table width="90%" border="0" align="center" cellpadding="0"
						cellspacing="0">
						<tr>
							<td height="20" colspan="4">
								<div align="left">
									<strong><label for="identificacao" class="labelExibe">LISTAGEM
											DE PALAVRAS-CHAVES</label></strong>
								</div>
							</td>
						</tr>
						<tr>
							<td width="120" height="20"><label for="identificacao"
								class="labelExibe">id</label></td>
							<td width="120" height="20"><label for="identificacao"
								class="labelExibe">Palavra-Chave</label></td>
							<td width="120" height="20"><label for="identificacao"
								class="labelExibe">Status</label></td>
							<td width="120" height="20"><label for="identificacao"
								class="labelExibe">Ação</label></td>
							<!-- Exemplo de cadastro -->
						</tr>
						<tr>
							<td width="120" height="20"><label for="identificacao"
								class="labelExibe">2012</label></td>
							<td width="120" height="20"><label for="identificacao"
								class="labelExibe">Palavra Teste</label></td>
							<td width="120" height="20"><label for="identificacao"
								class="labelExibe">Aprovada</label></td>
							<td width="120" height="20"><a href="#"><img
									src="/GraoPara/images/approve.png" title="Aprovar"
									alt="Aprovarr" /></a> <a href="#"><img
									src="/GraoPara/images/edit.png" title="Editar" alt="Editar" /></a>
								<a href="#"><img src="/GraoPara/images/remove.png"
									title="Remover" alt="Remover" /></a></td>
						</tr>
					</table>
				</section>
				<section id="tab2">
					<h2>
						<a href="#tab2">Novos Usuários</a>
					</h2>
					<table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
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

				</section>
				<section id="tab3">
					<h2>
						<a href="#tab3">Usuários</a>
					</h2>
					<table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
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

				</section>
				<section id="tab4">
					<h2>
						<a href="#tab4">Palavras-Chaves</a>
					</h2>
					<br>
					<table width="90%" border="0" align="center" cellpadding="0"
						cellspacing="0">
						<tr>
							<td height="20" colspan="4">
								<div align="left">
									<strong><label for="identificacao" class="labelExibe">LISTAGEM
											DE PALAVRAS-CHAVES</label></strong>
								</div>
							</td>
						</tr>
						<tr>
							<td width="120" height="20"><label for="identificacao"
								class="labelExibe">id</label></td>
							<td width="120" height="20"><label for="identificacao"
								class="labelExibe">Palavra-Chave</label></td>
							<td width="120" height="20"><label for="identificacao"
								class="labelExibe">Status</label></td>
							<td width="120" height="20"><label for="identificacao"
								class="labelExibe">Ação</label></td>
							<!-- Exemplo de cadastro -->
						</tr>
						<tr>
							<td width="120" height="20"><label for="identificacao"
								class="labelExibe">2012</label></td>
							<td width="120" height="20"><label for="identificacao"
								class="labelExibe">Palavra Teste</label></td>
							<td width="120" height="20"><label for="identificacao"
								class="labelExibe">Aprovada</label></td>
							<td width="120" height="20"><a href="#"><img
									src="/GraoPara/images/edit.png" title="Editar" alt="Editar" /></a>
								<a href="#"><img src="/GraoPara/images/remove.png"
									title="Remover" alt="Remover" /></a></td>
						</tr>
					</table>
				</section>
				<section id="tab5">
					<h2>
						<a href="#tab5">Documentos</a>
					</h2>
					<br>
					<table width="100%" border="1" align="center" cellpadding="0"
						cellspacing="0">
						<tr>
							<td><label class="labelExibe">Identificação</label></td>
							<td><label class="labelExibe">Código</label></td>
							<td><label class="labelExibe">Título</label></td>
							<td><label class="labelExibe">Tipo de Número</label></td>
							<td><label class="labelExibe">Número</label></td>
							<td><label class="labelExibe">Autor</label></td>
							<td><label class="labelExibe">Destinatário</label></td>
							<td><label class="labelExibe">Local</label></td>
							<td><label class="labelExibe">Data</label></td>
							<td><label class="labelExibe">Documento</label></td>
							<td><label class="labelExibe">Ações</label></td>
						</tr>
						<!-- Exemplo de Documento inserido -->
						<tr>
							<td><label class="labelExibe">Códice</label></td>
							<td><label class="labelExibe">1234</label></td>
							<td><label class="labelExibe">Documento de Exemplo</label></td>
							<td><label class="labelExibe">APEP</label></td>
							<td><label class="labelExibe">2531</label></td>
							<td><label class="labelExibe">José Maria</label></td>
							<td><label class="labelExibe">Maria João</label></td>
							<td><label class="labelExibe">São Paulo - SP</label></td>
							<td><label class="labelExibe">11/10/1900</label></td>
							<td><label class="labelExibe">Carta</label></td>
							<td><a href="#"><img src="/GraoPara/images/approve.png"
									title="Aprovar" alt="Aprovarr" /></a> <a href="#"><img
									src="/GraoPara/images/edit.png" title="Editar" alt="Editar" /></a>
								<a href="#"><img src="/GraoPara/images/remove.png"
									title="Remover" alt="Remover" /></a></td>
						</tr>
					</table>

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

