<%@page contentType="text/html; charset=UTF-8"%>
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
		
		<script type="text/javascript" src="/GraoPara/javascript/confirmBox.js" charset="utf-8"></script>
		
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
				<h1>Listagem de Documentos</h1>

				<div align="right">
					<a class="tdMinilink" href="javascript:confirmBox('/GraoPara/doDownload?<% out.write(SearchWorker.getAllAttributesAndValues(request, out));%>')">Download Pesquisa</a>
					<label style="font-size: small">|</label>
					<a class="tdMinilink" href="http://pt-br.libreoffice.org/baixe-ja/" target="_blank" title="Os documentos são baixados no formato ODT e podem ser visualizados utilizando LibreOffice. Clique aqui para baixar o LibreOffice!">Baixar o LibreOffice</a>
				</div>

				<div class="scrollLong">
					<table class="tableList">
						<tr class="trList">
							<%@include file="/WEB-INF/templates/documentData.jsp"%>
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