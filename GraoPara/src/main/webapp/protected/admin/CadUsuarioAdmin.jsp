<!doctype html>
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
				<form action="/GraoPara/doRegister" method="POST" name="cadastro">
					<table class="tableForms" width="522" border="0" align="center" cellpadding="0" cellspacing="0">
						<tr>
							<td height="20" colspan="2">
								<div align="left">
									<font size="1" face="Verdana, Arial, Helvetica, sans-serif">
										<b>PREENCHA TODOS OS CAMPOS COM ASTERÍSCO <font
											color="#FF0000">*</font></b>
									</font>
								</div>
							</td>
						</tr>
						<tr>
							<td height="20">
								<label for="nome" class="labelForms">Nome Completo:<font color="#FF0000">*</font></label>
							</td>
							<td width="377" height="20">
								 
								<input class="input validate[required] mediumInput" name="nome" type="text" id="nome" maxlength="50">								
							</td>
						</tr>
						<tr>
							<td height="20">
								<label for="email" class="labelForms">Email:<font color="#FF0000">*</font></label>
							</td>
							<td width="377" height="20">
								
									<input class="input validate[required] validate[custom[email]] mediumInput" name="email" id="email" maxlength="50">								
							</td>
						</tr>
						<tr>
							<td height="20">
								<label for="senha" class="labelForms">Senha:<font color="#FF0000">*</font></label>
							</td>
							<td width="377" height="20">
								<input class="input validate[required,minSize[6]]" id="senha" name="senha" type="password" maxlength="20">
							</td>
						</tr>
						<tr>
							<td height="20">
								<label for="confsenha" class="labelForms">Confirme sua senha:<font color="#FF0000">*</font></label>
							</td>
							<td width="377" height="20">
								<input class="input validate[required,equals[senha]]" id="confsenha" name="confsenha" type="password" maxlength="20">
							</td>
						</tr>
						<tr>
							<td height="20"></br><input type="submit" name="inserir" value="Enviar" class="buttonRegistrar"></td>
							<td height="20"></td>
						</tr>
						<tr>
							</br>
						</tr>
						<tr>
							<td colspan="2"> <font class="labelForms">Obs. Novos usuários necessitam da aprovação do administrador. 
							Aguarde o aprovamento de seu cadastro, e use o serviço de pesquisa como convidado.</font></td>
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

