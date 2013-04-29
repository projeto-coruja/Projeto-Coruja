<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="webview.util.WebUtility"%>

<html>
	<head>
		<meta charset="utf-8">
		<title>Grão-Pará</title>

		<!-- Import dos styles CSS -->
		<link rel="stylesheet" type="text/css" href="/GraoPara/css/principal.css" />
		<link rel="stylesheet" type="text/css" href="/GraoPara/css/tabs.css" />
		<link rel="stylesheet" type="text/css" href="/GraoPara/css/controle.css" />

		<!-- CSS das validacoes -->
		<link rel="stylesheet" type="text/css" media="screen" href="/GraoPara/css/styleValidation.css" />

		<!-- Import dos javascripts -->
		<script type="text/javascript" src="/GraoPara/javascript/cookie.js" charset="utf-8"></script>
		<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js" charset="utf-8"></script>
		<script src="/GraoPara/javascript/chili-1.7.pack.js" type="text/javascript"></script>
		<script src="/GraoPara/javascript/utility.js" type="text/javascript" charset="utf-8"></script>

		<!-- Import dos scripts de validacao de formulario -->
		<script src="/GraoPara/javascript/jquery.js" type="text/javascript" charset="utf-8"></script>
		<script src="/GraoPara/javascript/validate.js" type="text/javascript" charset="utf-8"></script>
		<script src="/GraoPara/javascript/validate_pesquisa.js" type="text/javascript" charset="utf-8"></script>
		<script src="/GraoPara/javascript/utility.js" type="text/javascript" charset="utf-8"></script>
	</head>

	<body onloadstart="checkCookie()">
		<div class="container">
			<div class="header"></div>

			<!-- Menu lateral -->
			<div class="sidebar1">
			
				<!-- Area de login -->
				<%@include file="/WEB-INF/templates/login.jsp" %>

				<!-- Area de menu -->
				<%@include file="/WEB-INF/templates/defaultMenu.jsp"%>
			</div>

			<div class="content" id="content">
				<h1>Pesquisa de Documento 
					<label style="font-size: x-small; color: black; padding-left: 10px;">(Os campos são opcionais.)</label>
				</h1>
				<form action="/GraoPara/public/listagemDocumentos.jsp" id="signupform" method="get" name="cadastro">
					<%@include file="/WEB-INF/templates/searchForm.jsp" %>
				</form>
			</div>
			
			<!-- Rodape -->
			<%@include file="/WEB-INF/templates/footer.jsp" %>
		</div>
	</body>
</html>