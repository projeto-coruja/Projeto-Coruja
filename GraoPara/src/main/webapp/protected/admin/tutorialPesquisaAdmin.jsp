<!doctype html>
<%@page import="webview.WebUtility"%>
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
<script type="text/javascript" src="/GraoPara/javascript/cookie.js"
	charset="utf-8"></script>
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"
	charset="utf-8"></script>
<script src="/GraoPara/javascript/chili-1.7.pack.js"
	type="text/javascript"></script>
	
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

			<!--Depois de logado-->
			<div class="LoginArea" id="logado">
				<form method="post" action="/GraoPara/doLogout">
					<fieldset>
						<label for="login">Bem vindo</label>
						<%
							WebUtility.printName(request, out);
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
					<li><a href="/GraoPara/protected/admin/indexAdmin.jsp">Home</a></li>
					<li><a href="/GraoPara/protected/admin/pesquisaAdmin.jsp">Pesquisar</a></li>
					<li><a href="/GraoPara/protected/admin/cadastroDocumentosAdmin.jsp">Cadastrar Documento</a></li>
					<li><a href="/GraoPara/protected/admin/cadUserAdmin.jsp">Cadastrar Usuário</a></li>					
					<li><a href="/GraoPara/protected/admin/painelAdmin.jsp">Painel Admin</a></li>
					<li><a href="/GraoPara/protected/admin/cadastrarTipoDocumento.jsp">Cadastrar Tipo de Documento</a></li>					
					<li><a href="/GraoPara/protected/admin/gerarSenha.jsp">Gerar Senha</a></li>
					<li><a href="/GraoPara/protected/admin/sobreAdmin.jsp">Sobre</a></li>	
					<li><a href="/GraoPara/protected/admin/creditosAdmin.jsp">Créditos</a></li>				
				</ul>
			</article>
		</div>
		<!-- Fim do Menu Lateral -->
		<!-- Começo Conteudo -->
		<div class="content" id="content">
		<h1>Como realizar pesquisas no acervo</h1>
			<p class="left">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc ultrices consequat nunc, vitae semper nulla egestas ac. Aliquam viverra mauris at augue iaculis varius. In in pulvinar turpis. Sed pulvinar tincidunt aliquam. Morbi porttitor leo sit amet massa interdum ut vulputate magna fermentum. Quisque volutpat, orci in pretium congue, erat neque rutrum ante, vitae pharetra felis lorem quis urna. Proin quis dui ante, sed faucibus nunc. Duis tempus dui non libero scelerisque id sollicitudin magna accumsan. Quisque elementum pretium purus, mollis sagittis mi blandit at. Sed tristique placerat lobortis. Aliquam id quam non eros faucibus laoreet vel eget sapien. Cras vehicula nunc sem, vel sollicitudin leo. Donec at metus neque. Cras commodo ante vel purus sagittis tempor. Vivamus ullamcorper sollicitudin interdum. Cras massa massa, suscipit a tempor et, malesuada vel mauris.</p>
			<p class="left">Nullam venenatis nisl in massa mollis eu congue quam facilisis. Sed tempor ipsum sit amet quam commodo vulputate. Etiam eget turpis ipsum. Ut ac lectus nisi, eu feugiat mi. Donec viverra adipiscing lorem eget consectetur. Etiam in fringilla purus. Aliquam erat volutpat..</p>
			<p class="left">Donec est nisi, euismod sed dapibus nec, vulputate ac nisi. Ut varius luctus ipsum, eget pulvinar tellus rutrum ac. Fusce non diam a nibh aliquet eleifend vel faucibus mi. In porttitor urna ac ante placerat id mollis enim ornare. Nulla fringilla est et libero vehicula vulputate. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Ut auctor, leo et faucibus ultricies, mauris tellus vehicula dolor, eget sodales lacus ante eget erat. Ut vulputate lorem ipsum. Morbi tempus mattis urna, quis tincidunt velit pellentesque vel. Cras sagittis magna quis elit molestie dapibus. Suspendisse non fringilla libero. Cras aliquam, odio at condimentum mollis, nibh lorem pretium tellus, porta aliquet velit sem eu quam. Phasellus vehicula nulla sed risus interdum eu volutpat orci venenatis.</p>
		</div>
		<!-- Fim do Conteudo -->

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
