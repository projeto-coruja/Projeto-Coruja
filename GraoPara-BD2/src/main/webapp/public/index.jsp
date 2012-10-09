<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Grão-Pará</title>

<!-- Import dos styles CSS -->
<link rel="stylesheet" type="text/css"	href="/GraoPara/css/principal.css" />
<link rel="stylesheet" type="text/css" href="/GraoPara/css/tabs.css" />
<link rel="stylesheet" type="text/css" href="/GraoPara/css/controle.css" />

<!-- CSS das validações -->
<link rel="stylesheet" type="text/css"
	href="/GraoPara/css/validationEngine.jquery.css" />

<!-- Import dos javascripts -->
<script type="text/javascript" src="/GraoPara/javascript/cookie.js"
	charset="utf-8"></script>

</head>
<body onloadstart="checkCookie()">
	<div class="container">
		<div class="header"></div>

		<!-- Começo do menu lateral -->
		<div class="sidebar1">

			<!--Área de login -->
			<%@include file="/templates/defaultLogin.jsp" %>
			<!-- Área de menu -->
			<%@include file="/templates/defaultMenu.jsp"%>
		</div>
			<!-- Fim do Menu Lateral -->
		<div class="content" id="content">
		<h1> Grão-Pará: 1800-1850</h1>
			<p class="left">Bem-vindo a esta ferramenta colaborativa para a criação de verbetes sobre documentos ligados à história da capitania/província do Pará na primeira metade do século XIX. Através desse site, qualquer pesquisador também pode ter acesso integral aos verbetes já redigidos a partir de diferentes formas de busca. </p>
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
