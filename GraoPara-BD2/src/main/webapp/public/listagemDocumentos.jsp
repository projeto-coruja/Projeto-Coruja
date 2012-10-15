<!doctype html>
<%@page import="webview.servlet.AdminRegisterServlet"%>
<%@page import="webview.worker.SearchWorker"%>

<html>
	<head>
		<meta charset="utf-8">
		<title>Gr�o-Par�</title>

		<!-- Import dos styles CSS -->
		<link rel="stylesheet" type="text/css" href="/GraoPara/css/principal.css" />
		<link rel="stylesheet" type="text/css" href="/GraoPara/css/tabs.css" />
		<link rel="stylesheet" type="text/css" href="/GraoPara/css/controle.css" />

		<!-- Import dos javascripts -->
		<script type="text/javascript" src="/GraoPara/javascript/cookie.js" charset="utf-8"></script>
	</head>

	<body onloadstart="checkCookie()">
		<div class="container">
			<div class="header"></div>

			<!-- Menu lateral -->
			<div class="sidebar1">
				<!-- Area de login -->
				<%@include file="/templates/login.jsp" %>

				<!-- Area de menu -->
				<%@include file="/templates/defaultMenu.jsp"%>
			</div>

			<div class="content" id="content">
				<h2>Listagem de Documentos</h2>

				<div align="right">
					<a href="/GraoPara/doDownload?<% out.write(SearchWorker.getAllAttributesAndValues(request, out)); %>" class="buttonDownload" >
						Download Pesquisa
					</a>
				</div>

				<div class="scrollLong">
					<table class="tableList">
						<tr class="trList">
							<td class="tdList"><label class="labelExibe">Identifica��o</label></td>
							<td class="tdList"><label class="labelExibe">C�digo</label></td>
							<td class="tdList"><label class="labelExibe">T�tulo</label></td>
							<td class="tdList"><label class="labelExibe">Tipo de N�mero</label></td>
							<td class="tdList"><label class="labelExibe">N�mero</label></td>
							<td class="tdList"><label class="labelExibe">Autor</label></td>
							<td class="tdList"><label class="labelExibe">Destinat�rio</label></td>
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
				<p>Copyright � - Universidade Federal de S�o Paulo - UNIFESP 2012</p>
				<p>Desenvolvido pelo grupo Coruja</p>
			</div>
		</div>
	</body>
</html>