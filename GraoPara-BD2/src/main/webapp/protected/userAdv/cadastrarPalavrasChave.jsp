<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="webview.worker.PanelWorker"%>
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
		<link rel="stylesheet" type="text/css" media="screen"
			href="/GraoPara/css/styleValidation.css" />

		<!-- Import dos javascripts -->
		<script type="text/javascript" src="/GraoPara/javascript/cookie.js"	charset="utf-8"></script>
		<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js" charset="utf-8"></script>
		<script src="/GraoPara/javascript/chili-1.7.pack.js" type="text/javascript"></script>

		<!-- Import dos scripts de validacoo de formulario -->
		<script src="/GraoPara/javascript/jquery.js" type="text/javascript" charset="utf-8"></script>
		<script src="/GraoPara/javascript/validate.js" type="text/javascript" charset="utf-8"></script>
		<script src="/GraoPara/javascript/validate_pt_br.js" type="text/javascript" charset="utf-8"></script>
		<script src="/GraoPara/javascript/utility.js" type="text/javascript" charset="utf-8"></script>
	</head>

	<body>
		<div class="container">
			<div class="header"></div>

			<!-- Menu lateral -->
			<div class="sidebar1">
				<!-- Area de login -->
				<%@include file="/WEB-INF/templates/loginReception.jsp"%>

				<!-- Area de menu -->
				<%@include file="/WEB-INF/templates/userAdvMenu.jsp"%>
			</div>

			<div class="content" id="content">
				<h1>Cadastro de Palavra-Chave</h1>

				<form action="/GraoPara/protected/userAdv/doChangesToKeyWord" id="signupform"	method="get" autocomplete="off">
					<%@include file="/WEB-INF/templates/newKeywordForm.jsp"%>
				</form>

				<br>
				<br>

				<div class="scrollLong">
					<table class="tableList">
						<tr class="trList">
							<thead>
								<tr>
									<td class="tdList"><label for="id" class="labelExibe">ID</label></td>
									<td class="tdList"><label for="palavraChave" class="labelExibe">Palavra-Chave</label></td>
								</tr>
							</thead>

						<tbody>
							<%
								request.setAttribute("in", "cadastrarPalavrasChave.jsp");
								PanelWorker.listAllKeyWordsForUser(request, out);
							%>
						</tbody>
					</table>
				</div>
			</div>

			<!-- Rodape -->
			<%@include file="/WEB-INF/templates/footer.jsp"%>
		</div>
	</body>
</html>