<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="webview.worker.SearchWorker"%>
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
		<script type="text/javascript" src="/GraoPara/javascript/ajax.js" charset="utf-8"></script>
		<script type="text/javascript" src="/GraoPara/javascript/instrucao.js" charset="utf-8"></script>
		<script src="/GraoPara/javascript/chili-1.7.pack.js" type="text/javascript"></script>
		<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js" charset="utf-8"></script>

		<!-- Import dos scripts de validacao de formulario -->
		<script src="/GraoPara/javascript/jquery.js" type="text/javascript" charset="utf-8"></script>
		<script src="/GraoPara/javascript/validate.js" type="text/javascript" charset="utf-8"></script>
		<script src="/GraoPara/javascript/validate_pt_br.js" type="text/javascript" charset="utf-8"></script>
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
				<h1>Cadastro do Tipo de Documento</h1>
				<form action="/GraoPara/protected/userAdv/doDocType" id="signupform" method="get" autocomplete="off">
					<%@include file="/WEB-INF/templates/newDocTypeForm.jsp"%>
				</form>

				<br>
				<br>

				<div class="scrollLong">
					<table class="tableList">
						<tr class="trList">
							<td class="tdList"><label class="labelExibe">Tipo de Documento</label></td>
							<td class="tdList"><label class="labelExibe">Descrição</label></td>
						</tr>

						<% SearchWorker.listAllDocumentsTypesForUser(request, out);%>
					</table>
				</div>
			</div>

			<!-- Rodape -->
			<%@include file="/WEB-INF/templates/footer.jsp"%>
		</div>
	</body>
</html>