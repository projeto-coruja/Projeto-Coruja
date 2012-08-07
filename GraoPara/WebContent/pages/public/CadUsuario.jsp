<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Gr�o-Par�</title>

<!-- Import dos styles CSS -->
<link href="/GraoPara/pages/css/principal.css" rel="stylesheet" type="text/css" />
<link href="/GraoPara/pages/css/tabs.css" rel="stylesheet" type="text/css" />
<link href="/GraoPara/pages/css/controle.css" rel="stylesheet" type="text/css" />
<!-- CSS das valida��es -->
<link href="/GraoPara/pages/css/validationEngine.jquery.css" rel="stylesheet" type="text/css"/>


<!-- Import dos javascripts -->
<script type="text/javascript" src="/GraoPara/faces/pages/javascript/ajax.js"></script>
<script type="text/javascript" src="/GraoPara/faces/pages/javascript/instrucao.js"></script>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>

<!-- Import dos scripts de valida��o de formul�rio -->
<script type="text/javascript" src="/GraoPara/faces/pages/javascript/jquery.validationEngine.js"></script>
<script type="text/javascript" src="/GraoPara/faces/pages/javascript/script.js"></script>
<script type="text/javascript" src="/GraoPara/faces/pages/javascript/languages/jquery.validationEngine-pt.js"></script>

</head>

<body>

	<div class="container">
		<div class="header">
			<!-- Come�o do banner -->
			<a href="/GraoPara/faces/pages/public/index.jsp" class="banner"></a>
		</div>
		<!-- Fim do Banner -->
		<!-- Come�o do menu lateral -->
		<div class="sidebar1">

			<!--Come�o da �rea de login -->
			<div class="LoginArea" id="LoginArea">
			<form method="post" action = "LoginServlet">
				<fieldset>
					<label for="login">Login:</label>
						<input class="inputLogin"
							type="text" name="login" height="30px" size="auto"
							placeholder="Seu login" required>
					<label for="senha">Senha:</label>
						<input class="inputLogin"
							type="password" name="senha" height="30px" size="auto"
							placeholder="Sua senha" required>
				</fieldset>
				<fieldset>
					<input class="buttonEntrar" type="submit" name="Entrar" value="Entrar"/>
				</fieldset>
			</form>
			</div>
			<div class="AfterLogin" id="AfterLogin" hidden="0">
			Bem vindo #UserName
			<input class="buttonEntrar" type="submit" name="Entrar" value="Entrar"/>
			</div>
			<fieldset>
				<a href="/GraoPara/pages/public/CadUsuario.jsp"><input type="button" class="buttonRegistrar" name="Registrar" value="Registrar"></a>
			</fieldset>
			<!-- Fim da �rea de login -->

			<article class="menuLateral">  
			<ul class="nav" id="menu">
				<li><a href="/GraoPara/faces/pages/public/index.jsp"><span>H</span>ome</a></li>
				<li><a href="/GraoPara/faces/pages/public/pesquisa.jsp"><span>P</span>esquisar</a></li>
				<li><a href="/GraoPara/faces/pages/public/sobre.jsp"><span>S</span>obre</a></li>
				
				<!-- Bot�o que precisa, ou n�o, ser escondido para visitantes -->
				<li><a href="/GraoPara/faces/pages/protected/user/cadastroDocumentos.jsp">Cadastrar Documento</a></li>
				
				<!-- Bot�es tempor�rios para testes -->
				<li><a href="/GraoPara/faces/pages/protected/user/UserControle.jsp">Painel User</a></li>
				<li><a href="/GraoPara/faces/pages/protected/admin/AdminControle.jsp">Painel Admin</a></li>
			</ul>
			</article>
			
			<!-- �rea para texto na barra lateral, a barra cresce ao inserir conteudo... --> 
			<p></p>
			<p></p>
			<p></p>
			<p></p>
		</div>
		<!-- Fim do Menu Lateral -->
		<div class="content" id="content">
				<h2>Cadastro Usu�rio</h2>
				<form action="CadastroServlet" method="POST" name="cadastro">
					<table class="tableForms" width="522" border="0" align="center" cellpadding="0" cellspacing="0">
						<tr>
							<td height="20" colspan="2">
								<div align="left">
									<font size="1" face="Verdana, Arial, Helvetica, sans-serif">
										<b>PREENCHA TODOS OS CAMPOS COM ASTER�SCO <font
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
								<font class="digitosTexts">(m�x.50 digitos)</font>  
								
							</td>
						</tr>
						<tr>
							<td height="20">
								<label for="email" class="labelForms">Email:<font color="#FF0000">*</font></label>
							</td>
							<td width="377" height="20">
								
									<input class="input validate[required] validate[custom[email]] mediumInput" name="email" id="email" maxlength="50">
									<font class="digitosTexts">(m�x 50 digitos)</font> 
								
							</td>
						</tr>
						<tr>
							<td height="20">
								<label for="senha" class="labelForms">Senha:<font color="#FF0000">*</font></label>
							</td>
							<td width="377" height="20">
								<input class="input validate[required,minSize[6]]" id="senha" name="senha" type="password" maxlength="20">
								<font class="digitosTexts">(min. 6 e m�x. 20 digitos)</font> 					
							</td>
						</tr>
						<tr>
							<td height="20">
								<label for="confsenha" class="labelForms">Confirme sua senha:<font color="#FF0000">*</font></label>
							</td>
							<td width="377" height="20">
								<input class="input validate[required,equals[senha]]" id="confsenha" name="confsenha" type="password" maxlength="20">
								<font class="digitosTexts">(min. 6 e m�x. 20 digitos)</font> 
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
							<td colspan="2"> <font class="labelForms">Obs. Novos usu�rios necessitam da aprova��o do administrador. 
							Aguarde o aprovamento de seu cadastro, e use o servi�o de pesquisa como convidado.</font></td>
						</tr>
						
					</table>
				</form>	
		</div>
		
		<!-- Come�o do Rodap� -->
		<div class="footer">
			<p>Copyright � - Universidade Federal de S�o Paulo - UNIFESP 2012</p>
			<p>Desenvolvido pelo grupo Coruja</p>
			<a href="/GraoPara/faces/pages/public/sobre.jsp">- Sobre -</a>
		</div>
		<!-- Fim do Rodap� -->
		<!-- end .container -->
	</div>
</body>
</html>

