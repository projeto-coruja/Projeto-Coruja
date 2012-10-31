<!doctype html>
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
		<link rel="stylesheet" type="text/css" href="/GraoPara/css/validationEngine.jquery.css" />

		<!-- Import dos javascripts -->
		<script type="text/javascript" src="/GraoPara/javascript/cookie.js" charset="utf-8"></script>
		<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js" charset="utf-8"></script>
	</head>

	<body onloadstart="checkCookie()">
		<div class="container">
			<div class="header"></div>

			<!-- Menu lateral -->
			<div class="sidebar1">
				<!-- Area de login -->
				<%@include file="/WEB-INF/templates/loginReception.jsp" %>

				<!-- Area de menu -->
				<%@include file="/WEB-INF/templates/userAdvMenu.jsp"%>
			</div>

			<div class="content" id="content">
				<h1>Listagem de Documentos</h1>

				<div align="right">
					<a href="/GraoPara/doDownload?<% out.write(SearchWorker.getAllAttributesAndValues(request, out)); %>" class="buttonDownload" >
						Download Pesquisa
					</a>
				</div>

				<div class="scrollLong">
					<table class="tableList">
						<tr class="trList">
							<td class="tdList"><label class="labelExibe">Identificação</label></td>
							<td class="tdList"><label class="labelExibe">Código</label></td>
							<td class="tdList"><label class="labelExibe">Título</label></td>
							<td class="tdList"><label class="labelExibe">Tipo de Número</label></td>
							<td class="tdList"><label class="labelExibe">Número</label></td>
							<td class="tdList"><label class="labelExibe">Autor</label></td>
							<td class="tdList"><label class="labelExibe">Destinatário</label></td>
							<td class="tdList"><label class="labelExibe">Local</label></td>
							<td class="tdList"><label class="labelExibe">Data</label></td>
							<td class="tdList"><label class="labelExibe">Tipo de Documento</label></td>
							<td class="tdList"><label class="labelExibe">Palavras-Chave</label></td>
						</tr>

						<% SearchWorker.listAllDocuments(request, out); %>
					</table>
				</div>
			</div>

			<!-- Rodape -->
			<div class="footer">
				<p>Copyright © - Universidade Federal de São Paulo - UNIFESP 2012</p>
				<p>Desenvolvido pelo grupo Coruja</p>
			</div>
		</div>
	</body>
</html>