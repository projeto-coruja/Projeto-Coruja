<!doctype html>
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
<script type="text/javascript" src="/GraoPara/javascript/ajax.js"
	charset="utf-8"></script>
<script type="text/javascript" src="/GraoPara/javascript/instrucao.js"
	charset="utf-8"></script>
<script src="/GraoPara/javascript/chili-1.7.pack.js"
	type="text/javascript"></script>
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"
	charset="utf-8"></script>

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

			<!--Come�o da �rea de login -->
			<div class="bordaBox">
				<b class="b1"></b><b class="b2"></b><b class="b3"></b><b class="b4"></b>
				<div class="conteudo">
					<div class="LoginArea" id="loginDefault" style="display:block;">
						<form method="post" action="/GraoPara/doLogin">
							<fieldset>
								<label class="sidebar" for="login">Login:</label> <input class="inputLogin"
									type="text" name="login" height="30px" size="auto"
									placeholder="Seu login" required> <label class="sidebar" for="senha">Senha:</label>
								<input class="inputLogin" type="password" name="senha"
									height="30px" size="auto" placeholder="Sua senha" required>
							</fieldset>
							<fieldset>
								<input class="buttonEntrar" type="submit" name="Entrar"
									value="Entrar" />											
							</fieldset>
							<fieldset>
								<a href="/GraoPara/public/CadUsuario.jsp"><input type="button"
									class="buttonRegistrar" name="Registrar" value="Registrar"></a>
							</fieldset>						
							</form>
						</div>
				</div>
				<b class="b4"></b><b class="b3"></b><b class="b2"></b><b class="b1"></b>
			</div>
			<!-- Fim da �rea de login -->
			<div class="bordaBox">
				<b class="b1"></b><b class="b2"></b><b class="b3"></b><b class="b4"></b>
				<div class="conteudo">
					<article class="menuLateral">
						<ul class="nav" id="menu">
							<li><a href="/GraoPara/public/index.jsp">Home</a></li>
							<li><a href="/GraoPara/public/pesquisa.jsp">Pesquisar</a></li>
							<li><a href="/GraoPara/public/sobre.jsp">Sobre</a></li>
							<li><a href="/GraoPara/public/creditos.jsp">Cr�ditos</a></li>
							<li><a href="/GraoPara/public/tutorialPesquisa.jsp">Como pesquisar no acervo</a></ul>
					</article>
				</div>
				<b class="b4"></b><b class="b3"></b><b class="b2"></b><b class="b1"></b>
			</div>
		</div>
			<!-- Fim do Menu Lateral -->
		<div class="content" id="content">
		
			<h2>Cadastro Usu�rio</h2>
			
			<form id="signupform" autocomplete="off" method="post" action="/GraoPara/doRegister">
				<table class="tableForms">
					<tr>
						<td class="tdForms">
							<label class="labelForms" id="lfirstname" for="nome">Nome Completo:<span class="asterisco">*</span></label>
						</td>
						<td class="field">
							<input class="input" id="nome" name="nome" type="text" value="" maxlength="100" />
						</td>
						<td class="status"></td>
					</tr>
					<tr>
						<td class="tdForms">
							<label class="labelForms"  id="lemail" for="email">Email:<span class="asterisco">*</span></label>
						</td>
						<td class="field">
							<input class="input" id="email" name="email" type="text" value="" maxlength="150" />
						</td>
						<td class="status"></td>
					</tr>
					<tr>
						<td class="tdForms">
							<label class="labelForms"  id="lpassword" for="password">Senha:<span class="asterisco">*</span></label></td>
						<td class="field">
							<input id="password" class="input" name="senha" type="password" maxlength="50" value="" />
						</td>
						<td class="status"></td>
					</tr>
					<tr>
						<td class="tdForms">
							<label class="labelForms"  id="lpassword_confirm" for="password_confirm">Confirme sua Senha:<span class="asterisco">*</span></label>
						</td>
						<td class="field">
							<input class="input" id="password_confirm" name="confsenha" type="password" maxlength="50" value="" />
						</td>
						<td class="status"></td>
					</tr>
					<tr>
						<td class="tdForms">
							<p></p>
							<input class="buttonRegistrar" id="signupsubmit" name="inserir" type="submit" value="Enviar" />
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
