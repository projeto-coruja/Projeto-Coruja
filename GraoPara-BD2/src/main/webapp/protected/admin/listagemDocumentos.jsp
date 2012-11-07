<!doctype html>
<%@page import="java.io.PrintWriter"%>
<%@page import="webview.util.WebUtility"%>
<%@page import="business.EJB.user.AdminBean"%>
<%@page import="webview.worker.SearchWorker"%>

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
				<%@include file="/WEB-INF/templates/adminMenu.jsp"%>
			</div>

			<div class="content" id="content">
				<h1>Listagem de Documentos
				<label style="font-size: small; padding-left: 10px; font-style: normal;">
						<a class="tdMinilink" href="/GraoPara/doDownload?<% out.write(SearchWorker.getAllAttributesAndValues(request, out));%>">Baixar a Listagem de Documentos</a>
						|
						<a class="tdMinilink" href="http://pt-br.libreoffice.org/baixe-ja/" target="_blank" title="Os documentos são baixados no formato ODT e podem ser visualizados utilizando LibreOffice. Clique aqui para baixar o LibreOffice!">Baixar o LibreOffice</a>
				</label>
				</h1>

				<table class="tableForms" style="padding-bottom: 10px;">
					<tr>
						<td>
						</td>
					</tr>				
				</table>
				
				<div class="scrollLong">
					<table class="tableList">
						<tr class="trList">
							<%@include file="/WEB-INF/templates/documentData.jsp"%>
							
							<td class="tdList"><label class="labelExibe">Ações</label></td>
						</tr>
						
						<% SearchWorker.listAllDocuments(request, out); %>
					</table>
				</div>
			</div>

			<!-- Rodape -->
			<%@include file="/WEB-INF/templates/footer.jsp" %>
		</div>
	</body>
</html>