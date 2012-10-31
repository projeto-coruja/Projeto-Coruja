<!doctype html>

<%@page import="webview.worker.SearchWorker"%>
<%@page import="webview.util.WebUtility"%>
<html>
	<head>
		<meta charset="utf-8">
		<title>Grão-Pará</title>

		<!-- Import dos styles CSS -->
		<link rel="stylesheet" type="text/css"	href="/GraoPara/css/principal.css" />
		<link rel="stylesheet" type="text/css" href="/GraoPara/css/tabs.css" />
		<link rel="stylesheet" type="text/css" href="/GraoPara/css/controle.css" />

		<!-- CSS das validacoes -->
		<link rel="stylesheet" type="text/css" href="/GraoPara/css/validationEngine.jquery.css" />

		<!-- Import dos javascripts -->
		<script type="text/javascript" src="/GraoPara/javascript/cookie.js"	charset="utf-8"></script>
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
			
			<!-- corpo -->	
			<%= SearchWorker.printInfoFromDocument(request, out) %>
			
			<!-- Rodape -->
			<%@include file="/WEB-INF/templates/footer.jsp" %>
		</div>
	</body>
</html>