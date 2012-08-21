<!doctype html>
<%@page import="webview.WebUtility"%>
<html>
<head>
<meta charset="utf-8">
<title>Grão-Pará</title>

<!-- Import dos styles CSS -->
<link rel="stylesheet" type="text/css" href="/GraoPara/css/principal.css" />
<link rel="stylesheet" type="text/css" href="/GraoPara/css/tabs.css" />
<link rel="stylesheet" type="text/css" href="/GraoPara/css/controle.css" />

<!-- CSS das validações -->
<link rel="stylesheet" type="text/css" href="/GraoPara/css/validationEngine.jquery.css" />

<!-- Import dos javascripts -->
<script type="text/javascript" src="/GraoPara/javascript/ajax.js" charset="utf-8"></script>
<script type="text/javascript" src="/GraoPara/javascript/instrucao.js" charset="utf-8"></script>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js" charset="utf-8"></script>

<!-- Import dos scripts de validação de formulário -->
<script type="text/javascript" src="/GraoPara/javascript/jquery.validationEngine.js" charset="utf-8"></script>
<script type="text/javascript" src="/GraoPara/javascript/script.js" charset="utf-8"></script>
<script type="text/javascript" src="/GraoPara/javascript/languages/jquery.validationEngine-pt.js" charset="utf-8"></script>

</head>

<body>

	<div class="container">
		<div class="header"></div>
		
		<!-- Começo do menu lateral -->
		<div class="sidebar1">

			<!--Depois de logado-->
			<div class="LoginArea" id="logado" style="display:block;">
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
				<li><a href="/GraoPara/protected/user/indexUser.jsp">Home</a></li>
					<li><a href="/GraoPara/protected/user/pesquisaUser.jsp">Pesquisar</a></li>
					<li><a href="/GraoPara/protected/user/cadastroDocumentosUser.jsp">Cadastrar Documento</a></li>
					<li><a href="/GraoPara/protected/user/painelUser.jsp">Painel User</a></li>
					<li><a href="/GraoPara/protected/user/sobreUser.jsp">Sobre</a></li>
			</ul>
			</article>			
			
		</div>
		<!-- Fim do Menu Lateral -->
		<div class="content" id="content">
				<form>
				<table class="tableControle">
				<tr>
					<th colspan="3" align="center">Painel de controle </th>
				</tr>
				
				<tr>
					<td><label for="documentos">Meus documentos: </label></td>
					<td colspan="2"><select class="inputControle" name="documentos">
					<option selected>Selecione...</option>
					<option value="Script"> Script </option>
					</select>
					</td>
					
				</tr>
				<tr>
					<td><input type="button" class="buttonDocumento" value="Visualizar" name="Visualizar" alt="Verificar campos de cadastro desse documento"></td>
					<td><input type="button" class="buttonDocumento" value="Alterar" name="Alterar" alt="Alterar os campos de cadastro desse documento"></td>
					<td><input type="button" class="buttonDocumento" value="Deletar" name="Deletar" alt="Deletar o registro desse documento"></td>
				</tr>
				</table>
				</form>
				<!-- Novo formulário para mudança de senha -->
				<form>
				<table class="tableControle">
				<tr>
					<th colspan="3" align="center"> Mudar Senha Atual </th>
				</tr>
				<tr>
					<td><label for="senhaAtual">Senha atual: </label></td>
					<td colspan="2"><input class="inputControle validate[required]" type="password" name="senhaAtual" id="senhaAtual"/>
				</tr>
				<tr>
					<td><label for="senhaNova">Nova senha: </label></td>
					<td colspan="2"><input class="inputControle validate[required,minSize[6]]" id="senhaNova" type="password" name="senhaNova" />
				</tr>
				<tr>
					<td><label for="senhaConfirme">Confirme nova senha: </label></td>
					<td colspan="2"><input class="inputControle validate[required,equals[senhaNova]]" type="password" name="senhaConfirme" id="senhaConfirme" />
				</tr>
				<tr>			
					<td><input type="button" class="buttonDocumento" value="Mudar" name="Mudar" alt="Mudar a senha atual."></td>
					<td></td>
					<td></td>
				</tr>
				</table>
				</form>				
		
		</div>
		<!-- Começo do Rodapé -->
		<div class="footer">
			<p>Copyright © - Universidade Federal de São Paulo - UNIFESP 2012</p>
			<p>Desenvolvido pelo grupo Coruja</p>
			<a href="/GraoPara/sobre.jsp">- Sobre -</a>
		</div>
		<!-- Fim do Rodapé -->
		<!-- end .container -->
	</div>
</body>
</html>