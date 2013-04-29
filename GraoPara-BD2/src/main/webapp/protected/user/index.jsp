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
		<link rel="stylesheet" type="text/css" href="/GraoPara/css/validationEngine.jquery.css" />

		<!-- Import dos javascripts -->
		<script type="text/javascript" src="/GraoPara/javascript/cookie.js" charset="utf-8"></script>
		<script src="/GraoPara/javascript/jquery.js" type="text/javascript"	charset="utf-8"></script>
		<script src="/GraoPara/javascript/utility.js" type="text/javascript" charset="utf-8"></script>
	</head>

	<body onloadstart="checkCookie()">
		<div class="container">
			<div class="header"></div>

			<!-- Menu lateral -->
			<div class="sidebar1">
				<!-- Area de login -->
				<%@include file="/WEB-INF/templates/loginReception.jsp" %>

				<!-- Area de menu -->
				<%@include file="/WEB-INF/templates/userMenu.jsp"%>
			</div>

			<!-- Texto da Pagina inicial do Grao Para -->
			<%@include file="/WEB-INF/templates/welcomeText.jsp"%>

			<!-- Rodape -->
			<%@include file="/WEB-INF/templates/footer.jsp"%>
		</div>
	</body>
</html>