<!doctype html>
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

			<div class="sidebar1">

			<!--Depois de logado-->
			<div class="LoginArea" id="logado" style="display:block;">
				<form method="post" action="/GraoPara/doLogout">
					<fieldset>
						<label for="login">Bem vindo</label>
						<label onload="getName()"></label>
					</fieldset>
					<fieldset>
						<input class="buttonSair" type="submit" name="Sair" value="Sair" /></a>
					</fieldset>
				</form>
			</div>
			<!-- ----------------------------------------------------------------------- -->

			<article class="menuLateral">  
			<ul class="nav" id="menu">
				<li><a href="/GraoPara/protected/admin/indexAdmin.jsp">Home</a></li>
				<li><a href="/GraoPara/protected/admin/pesquisaAdmin.jsp">Pesquisar</a></li>
				<li><a href="/GraoPara/protected/admin/cadastroDocumentosAdmin.jsp">Cadastrar Documento</a></li>
				<li><a href="/GraoPara/protected/admin/painelAdmin.jsp">Painel Admin</a></li>
				<li><a href="/GraoPara/protected/admin/sobreAdmin.jsp">Sobre</a></li>
			</ul>
			</article>
		</div>
		<!-- Fim do Menu Lateral -->
		<div class="content" id="content">
				<h2>Cadastro Usuário</h2>
				<form id="signupform" autocomplete="off" method="post" action="/GraoPara/doRegister">
				<table class="tableForms">
					<tr>
						<td height="20" colspan="3">
							<div align="left">
								<font size="1" face="Verdana, Arial, Helvetica, sans-serif">
									<b>PREENCHA TODOS OS CAMPOS COM ASTERÍSCO <font
										color="#FF0000">*</font></b>
								</font>
							</div>
						</td>
					</tr>
					<tr>
						<td class="labelForms"><label id="lfirstname" for="nome">Nome
								Completo:<font color="#FF0000">*</font>
						</label></td>
						<td class="field"><input class="input" id="nome" name="nome"
							type="text" value="" maxlength="100" /></td>
						<td class="status"></td>
					</tr>

					<tr>
						<td class="labelForms"><label id="lemail" for="email">Email:<font
								color="#FF0000">*</font></label></td>
						<td class="field"><input class="input" id="email"
							name="email" type="text" value="" maxlength="150" /></td>
						<td class="status"></td>
					</tr>
					<tr>
						<td class="labelForms"><label id="lpassword" for="password">Senha:<font
								color="#FF0000">*</font></label></td>
						<td class="field"><input id="password" class="input"
							name="senha" type="password" maxlength="50" value="" /></td>
						<td class="status"></td>
					</tr>
					<tr>
						<td class="labelForms"><label id="lpassword_confirm"
							for="password_confirm" style="">Confirme sua Senha:<font
								color="#FF0000">*</font></label></td>
						<td class="field"><input class="input" id="password_confirm"
							name="confsenha" type="password" maxlength="50" value="" /></td>
						<td class="status"></td>
					</tr>
					<tr>
						<td class="labelForms"><label id="lpermissao" for="permissao">Permissão:<font color="#FF0000">*</font>
						</label></td>
						<td class="field">
							<select name="permissao" class="input" id="permissao">
									<option value="">Selecione...</option>
									<option value="Admin">Administrador</option>
									<option value="Comum">Comum</option>
							</select></td>
						<td class="status"></td>
					</tr>
					<tr>
						<td class="field" colspan="3"><input class="buttonRegistrar"
							id="signupsubmit" name="Enviar" type="submit" value="Enviar" />
						</td>
					</tr>				
				</table>
			</form>
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

