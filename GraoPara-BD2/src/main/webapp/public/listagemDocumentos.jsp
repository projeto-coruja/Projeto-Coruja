<!doctype html>
<%@page import="webview.servlet.AdminRegisterServlet"%>
<%@page import="webview.worker.SearchWorker"%>

<html>
	<head>
		<meta charset="utf-8">
		<title>Grão-Pará</title>

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

					<a href="http://pt-br.libreoffice.org/baixe-ja/" target="_blank">
						<img src="/GraoPara/images/icone_ajuda.png"	alt="Os documentos são baixados no formato ODT e podem ser visualizados utilizando LibreOffice. Clique aqui para baixar o LibreOffice!" title="Os documentos são baixados no formato ODT e podem ser visualizados utilizando LibreOffice. Clique aqui para baixar o LibreOffice!" />
					</a>
				</div>

				<div class="scrollLong">
					<table class="tableList">
						<tr class="trList">
							<%@include file="/templates/documentData.jsp"%>
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