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

			<!--Começo da área de login -->
			<div class="LoginArea" id="LoginArea">
				<form method="post" action="/GraoPara/doLogin">
					<fieldset>
						<label for="login">Login:</label> <input class="inputLogin"
							type="text" name="login" height="30px" size="auto"
							placeholder="Seu login" required> <label for="senha">Senha:</label>
						<input class="inputLogin" type="password" name="senha"
							height="30px" size="auto" placeholder="Sua senha" required>
					</fieldset>
					<fieldset>
						<input class="buttonEntrar" type="submit" name="Entrar"
							value="Entrar" />
					</fieldset>
				</form>
			</div>
			<div class="AfterLogin" id="AfterLogin" hidden="0">
				Bem vindo #UserName <input class="buttonEntrar" type="submit"
					name="Entrar" value="Entrar" />
			</div>
			<fieldset>
				<a href="/GraoPara/public/CadUsuario.jsp"><input type="button"
					class="buttonRegistrar" name="Registrar" value="Registrar"></a>
			</fieldset>
			<!-- Fim da área de login -->

			<article class="menuLateral">
				<ul class="nav" id="menu">
					<li><a href="/GraoPara/public/index.jsp">Home</a></li>
					<li><a href="/GraoPara/public/pesquisa.jsp">Pesquisar</a></li>
					<li><a href="/GraoPara/public/sobre.jsp">Sobre</a></li>
				</ul>
			</article>
		</div>	<!-- Fim do Menu Lateral -->
		<div class="content" id="content">
		
			<h2>Cadastro Usuário</h2>
			
			<form id="signupform" autocomplete="off" method="post" action="/GraoPara/doRegister">
				<table class="tableForms">
					<tr>
						<td class="labelForms" colspan="3">
							<strong>PREENCHA TODOS OS CAMPOS COM ASTERÍSCO <span class="asterisco">*</span></strong>
						</td>
					</tr>
					<tr>
						<td>
							<label class="labelForms" id="lfirstname" for="nome">Nome Completo:<span class="asterisco">*</span></label>
						</td>
						<td class="field">
							<input class="input" id="nome" name="nome" type="text" value="" maxlength="100" />
						</td>
						<td class="status"></td>
					</tr>
					<tr>
						<td>
							<label class="labelForms"  id="lemail" for="email">Email:<span class="asterisco">*</span></label>
						</td>
						<td class="field">
							<input class="input" id="email" name="email" type="text" value="" maxlength="150" />
						</td>
						<td class="status"></td>
					</tr>
					<tr>
						<td>
							<label class="labelForms"  id="lpassword" for="password">Senha:<span class="asterisco">*</span></label></td>
						<td class="field">
							<input id="password" class="input" name="senha" type="password" maxlength="50" value="" />
						</td>
						<td class="status"></td>
					</tr>
					<tr>
						<td>
							<label class="labelForms"  id="lpassword_confirm" for="password_confirm">Confirme sua Senha:<span class="asterisco">*</span></label>
						</td>
						<td class="field">
							<input class="input" id="password_confirm" name="confsenha" type="password" maxlength="50" value="" />
						</td>
						<td class="status"></td>
					</tr>
					<tr>
						<td class="field" colspan="3">
						<p></p>
							<input class="buttonRegistrar" id="signupsubmit" name="Enviar" type="submit" value="Enviar" />
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
