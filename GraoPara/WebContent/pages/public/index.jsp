<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Gr�o-Par�</title>

<!-- Import dos styles CSS -->
<link href="/GraoPara/pages/css/principal.css" rel="stylesheet" type="text/css" />
<link href="/GraoPara/pages/css/tabs.css" rel="stylesheet" type="text/css" />
<link href="/GraoPara/pages/css/controle.css" rel="stylesheet" type="text/css" />

<!-- Import dos javascripts -->
<script type="text/javascript" src="/GraoPara/pages/javascript/ajax.js"></script>
<script type="text/javascript" src="/GraoPara/pages/javascript/instrucao.js"></script>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>

<!-- Import dos scripts de valida��o de formul�rio -->
<script type="text/javascript" src="/GraoPara/pages/javascript/jquery.validationEngine.js"></script>
<script type="text/javascript" src="/GraoPara/pages/javascript/script.js"></script>
<script type="text/javascript" src="/GraoPara/pages/javascript/languages/jquery.validationEngine-pt.js"></script>


</head>

<body>

	<div class="container">
		<div class="header">
			<!-- Come�o do banner -->
			<a href="/GraoPara/pages/public/index.jsp" class="banner"></a>
		</div>
		<!-- Fim do Banner -->
		<!-- Come�o do menu lateral -->
		<div class="sidebar1">

			<!--Come�o da �rea de login -->
			<div class="LoginArea" id="LoginArea">
			<form method="post" action = "/GraoPara/doLogin">
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
				<li><a href="/GraoPara/pages/public/index.jsp"><span>H</span>ome</a></li>
				<li><a href="/GraoPara/pages/public/pesquisa.jsp"><span>P</span>esquisar</a></li>
				<li><a href="/GraoPara/pages/public/sobre.jsp"><span>S</span>obre</a></li>
				
				<!-- Bot�o que precisa, ou n�o, ser escondido para visitantes -->
				<li><a href="/GraoPara/pages/protected/user/cadastroDocumentos.jsp">Cadastrar Documento</a></li>
				
				<!-- Bot�es tempor�rios para testes -->
				<li><a href="/GraoPara/pages/protected/user/UserControle.jsp">Painel User</a></li>
				<li><a href="/GraoPara/pages/protected/admin/AdminControle.jsp">Painel Admin</a></li>
			</ul>
			</article>
			
			<!-- �rea para texto na barra lateral, a barra cresce ao inserir conteudo... --> 
			<p></p>
			<p></p>
			<p></p>
			<p></p>
		</div>
		<!-- Fim do Menu Lateral -->
		<div class="content" id="content">TESTE DE CARREGAMENTO</div>
		<!-- Come�o do Rodap� -->
		<div class="footer">
			<p>Copyright � - Universidade Federal de S�o Paulo - UNIFESP 2012</p>
			<p>Desenvolvido pelo grupo Coruja</p>
			<a href="/GraoPara/pages/public/sobre.jsp">- Sobre -</a>
		</div>
		<!-- Fim do Rodap� -->
		<!-- end .container -->
	</div>
</body>
</html>
