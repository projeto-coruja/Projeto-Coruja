<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Gr�o-Par�</title>

<!-- Import dos styles CSS -->
<link rel="stylesheet" type="text/css" href="/GraoPara/css/principal.css" />
<link rel="stylesheet" type="text/css" href="/GraoPara/css/tabs.css" />
<link rel="stylesheet" type="text/css" href="/GraoPara/css/controle.css" />

<!-- CSS das valida��es -->
<link rel="stylesheet" type="text/css" href="/GraoPara/css/validationEngine.jquery.css" />

<!-- Import dos javascripts -->
<script type="text/javascript" src="/GraoPara/javascript/ajax.js" charset="utf-8"></script>
<script type="text/javascript" src="/GraoPara/javascript/instrucao.js" charset="utf-8"></script>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js" charset="utf-8"></script>

<!-- Import dos scripts de valida��o de formul�rio -->
<script type="text/javascript" src="/GraoPara/javascript/jquery.validationEngine.js" charset="utf-8"></script>
<script type="text/javascript" src="/GraoPara/javascript/script.js" charset="utf-8"></script>
<script type="text/javascript" src="/GraoPara/javascript/languages/jquery.validationEngine-pt.js" charset="utf-8"></script>

</head>

<body>

	<div class="container">
		<div class="header"></div>
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
				<li><a href="/GraoPara/index.jsp"><span>H</span>ome</a></li>
				<li><a href="/GraoPara/pesquisa.jsp"><span>P</span>esquisar</a></li>
				<li><a href="/GraoPara/sobre.jsp"><span>S</span>obre</a></li>
				
				<!-- Bot�o que precisa, ou n�o, ser escondido para visitantes -->
				<li><a href="/GraoPara/protected/user/cadastroDocumentos.jsp">Cadastrar Documento</a></li>
				
				<!-- Bot�es tempor�rios para testes -->
				<li><a href="/GraoPara/protected/user/UserControle.jsp">Painel User</a></li>
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
