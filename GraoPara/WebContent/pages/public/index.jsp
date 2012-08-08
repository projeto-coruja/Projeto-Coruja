<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Grão-Pará</title>

<!-- Import dos styles CSS -->
<link href="/GraoPara/faces/pages/css/principal.css" rel="stylesheet" type="text/css" />
<link href="/GraoPara/faces/pages/css/tabs.css" rel="stylesheet" type="text/css" />
<link href="/GraoPara/faces/pages/css/controle.css" rel="stylesheet" type="text/css" />

<!-- Import dos javascripts -->
<script type="text/javascript" src="/GraoPara/faces/pages/javascript/ajax.js"></script>
<script type="text/javascript" src="/GraoPara/faces/pages/javascript/instrucao.js"></script>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>

<!-- Import dos scripts de validação de formulário -->
<script type="text/javascript" src="/GraoPara/faces/pages/javascript/jquery.validationEngine.js"></script>
<script type="text/javascript" src="/GraoPara/faces/pages/javascript/script.js"></script>
<script type="text/javascript" src="/GraoPara/faces/pages/javascript/languages/jquery.validationEngine-pt.js"></script>


</head>

<body>

	<div class="container">
		<div class="header">
			<!-- Começo do banner -->
			<a href="/GraoPara/faces/pages/public/index.jsp" class="banner"></a>
		</div>
		<!-- Fim do Banner -->
		<!-- Começo do menu lateral -->
		<div class="sidebar1">

			<!--Começo da área de login -->
			<div class="LoginArea" id="LoginArea">
			<form method="post" action = "/GraoPara/LoginServlet">
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
			<!-- Fim da área de login -->

			<article class="menuLateral">  
			<ul class="nav" id="menu">
				<li><a href="/GraoPara/faces/pages/public/index.jsp"><span>H</span>ome</a></li>
				<li><a href="/GraoPara/faces/pages/public/pesquisa.jsp"><span>P</span>esquisar</a></li>
				<li><a href="/GraoPara/faces/pages/public/sobre.jsp"><span>S</span>obre</a></li>
				
				<!-- Botão que precisa, ou não, ser escondido para visitantes -->
				<li><a href="/GraoPara/faces/pages/protected/user/cadastroDocumentos.jsp">Cadastrar Documento</a></li>
				
				<!-- Botões temporários para testes -->
				<li><a href="/GraoPara/faces/pages/protected/user/UserControle.jsp">Painel User</a></li>
				<li><a href="/GraoPara/faces/pages/protected/admin/AdminControle.jsp">Painel Admin</a></li>
			</ul>
			</article>
			
			<!-- Área para texto na barra lateral, a barra cresce ao inserir conteudo... --> 
			<p></p>
			<p></p>
			<p></p>
			<p></p>
		</div>
		<!-- Fim do Menu Lateral -->
		<div class="content" id="content">TESTE DE CARREGAMENTO</div>
		<!-- Começo do Rodapé -->
		<div class="footer">
			<p>Copyright © - Universidade Federal de São Paulo - UNIFESP 2012</p>
			<p>Desenvolvido pelo grupo Coruja</p>
			<a href="/GraoPara/faces/pages/public/sobre.jsp">- Sobre -</a>
		</div>
		<!-- Fim do Rodapé -->
		<!-- end .container -->
	</div>
</body>
</html>
