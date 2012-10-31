<!doctype html>

<html>
	<head>
		<meta charset="utf-8">
		<title>Gr�o-Par�</title>

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

			<div class="content" id="content">
			<h1> Gr�o-Par�: 1800-1850</h1>
				<p class="left">
					Bem-vindo a esta ferramenta colaborativa para a cria��o de verbetes sobre documentos ligados � hist�ria da capitania/prov�ncia do Par� na primeira metade do s�culo XIX. Atrav�s desse site, qualquer pesquisador tamb�m pode ter acesso integral aos verbetes j� redigidos a partir de diferentes formas de busca.
				</p>
			</div>

			<%@include file="/WEB-INF/templates/footer.jsp" %>
		</div>
	</body>
</html>