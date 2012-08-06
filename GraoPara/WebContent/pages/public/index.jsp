<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Gr�o-Par�</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!-- Carregando os estilos CSS -->
<link href="/GraoPara/faces/pages/css/principal.css" rel="stylesheet" type="text/css"/>
<link href="/GraoPara/faces/pages/css/tabs.css" rel="stylesheet" type="text/css"/>
<link href="/GraoPara/faces/pages/css/controle.css" rel="stylesheet" type="text/css"/>

<!-- Carregando os Javascripts -->
<script type="text/javascript" src="/GraoPara/faces/pages/javascript/ajax.js"></script>
<script type="text/javascript" src="/GraoPara/faces/pages/javascript/instrucao.js"></script>

<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.5.1/jquery.min.js"></script>
	
<script type="text/javascript">
	$(document).ready(function() {
		$("#menu a").click(function(e) {
			e.preventDefault();
			var href = $(this).attr('href');
			$("#content").load(href + " #content");
		});
	});
</script>
</head>

<body>

	<div class="container">
		<div class="header">
			<!-- Come�o do banner -->
			<center>
				<a href="#" class="banner"></a>
			</center>

		</div>
		<!-- Fim do Banner -->
		<!-- Come�o do menu lateral -->
		<div class="sidebar1">

			<!--Come�o da �rea de login -->
			<form method="post" action = "LoginServlet">
				<fieldset>
					<label for="login">Login:</label>
						<input class="inputLogin"
							type="text" name="login" height="30px" size="auto"
							placeholder="Seu login" required autofocus>
					<label for="senha">Senha:</label>
						<input class="inputLogin"
							type="password" name="senha" height="30px" size="auto"
							placeholder="Sua senha" required>
				</fieldset>
				<fieldset>
					<input class="buttonEntrar" type="submit" name="Entrar"
						value="Entrar" />
				</fieldset>
			</form>
			<fieldset>
				<a onclick="abrirPag('/GraoPara/faces/pages/public/CadUsuario.jsp');">
					<input
						class="buttonRegistrar" type="button" name="Registrar"
						value="Registrar" />
				</a>
			</fieldset>
			<!-- Fim da �rea de login -->


			<ul class="nav" id="menu">
				<li><a href="#" onclick="abrirPag('/GraoPara/faces/pages/public/pesquisa.jsp');">Pesquisar</a></li>
				<li><a href="#"
					onclick="abrirPag('/GraoPara/faces/pages/protected/user/cadastroDocumentos.jsp');">Cadastrar
						Documento</a></li>
				<li><a href="#"
					onclick="abrirPag('/GraoPara/faces/pages/protected/user/UserControle.jsp');">Painel
						User</a></li>
				<li><a href="#"
					onclick="abrirPag('/GraoPara/faces/pages/protected/admin/AdminControle.jsp');">Painel
						Admin</a></li>
			</ul>
			<p>�rea que se expande ao ir digitando algo, pode adicionar
				outros bot�es acima.</p>
			<p>Aqui podemos colocar um texto explicando o projeto Gr�o-Par�</p>
		</div>
		<!-- Fim do Menu Lateral -->
		<div class="content" id="frame">TESTE DE CARREGAMENTO</div>
		<!-- Come�o do Rodap� -->
		<div class="footer">
			<p>Copyright � - Universidade Federal de S�o Paulo - UNIFESP 2012</p>
			<a href="#"> Sobre </a> - <a href="#"> Pesquisar </a>
		</div>
		<!-- Fim do Rodap� -->
		<!-- end .container -->
	</div>
</body>
</html>