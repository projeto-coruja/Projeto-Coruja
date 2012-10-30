<!doctype html>
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
				<%@include file="/templates/loginReception.jsp"%>

				<!-- Area de menu -->
				<%@include file="/templates/adminMenu.jsp"%>
			</div>

			<div class="content" id="content">
				<h1>Cadastro de Palavra-Chave</h1>

				<form action="/GraoPara/protected/admin/doChangesToKeyWord" id="signupform"	method="get" autocomplete="off">
					<table class="tableControle">
						<tr>
							<td class="tdControle"><label class="labelForms" id="lchave" for="chave">Palavra-Chave</label></td>
							<td class="field"><input class="input" id="palavra"	name="palavraNova" type="text" value="" maxlength="32" /></td>
							<td class="field">
								<label class="labelForms" id="ltema" for="tema">Tema</label>
								<select class="input" id="tema" name="tema">
									<%=WebUtility.printSelectKeyWordThemes() %>
								</select>
							</td>
							
							<td class="status"></td>
						 	<td class="field"><input class="input" id="action" name="action" type="hidden" value="add" maxlength="32" /></td>
							<td class="field"><input class="input" id="action" name="from" type="hidden" value="cadastrarPalavrasChave.jsp" maxlength="20" /></td>
						</tr>

						<tr>
							<td class="tdForms" align="right" colspan="2">
								<br><input class="buttonRegistrar" id="signupsubmit" name="inserir" type="submit" value="Cadastrar" />
							</td>
						</tr>
					</table>
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
									<td class="tdList"><label for="acao" class="labelExibe">Ação</label></td>
								</tr>
							</thead>

						<tbody>
							<%
								request.setAttribute("in", "cadastrarPalavrasChave.jsp");
								PanelWorker.listAllKeyWords(request, out);
							%>
						</tbody>
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