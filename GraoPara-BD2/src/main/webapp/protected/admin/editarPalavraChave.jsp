<%@page contentType="text/html; charset=UTF-8"%>
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
		<script type="text/javascript" src="/GraoPara/javascript/cookie.js"	charset="utf-8"></script>
		<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js" charset="utf-8"></script>
		<script src="/GraoPara/javascript/chili-1.7.pack.js" type="text/javascript"></script>
		<script src="/GraoPara/javascript/utility.js" type="text/javascript" charset="utf-8"></script>

		<!-- Import dos scripts de validacao de formulario -->
		<script src="/GraoPara/javascript/jquery.js" type="text/javascript"	charset="utf-8"></script>
		<script src="/GraoPara/javascript/validate.js" type="text/javascript" charset="utf-8"></script>
		<script src="/GraoPara/javascript/validate_pt_br.js" type="text/javascript" charset="utf-8"></script>
	</head>

	<body>
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
				<h1>Edição de Palavra-Chave</h1>

				<form id="signupform" autocomplete="off" method="get" action="/GraoPara/protected/admin/doChangesToKeyWord">
					<table class="tableForms">
						<tr>
							<td class="tdForms">
								<label class="labelForms" for="palavraAntiga">Palavra-Chave Antiga</label>
							</td>
						</tr>
						
						<tr>
							<td class="field">
								<input class="input" id="palavraAntiga" name="palavraAntiga" type="text" value="<%= request.getParameter("palavraAntiga") %>" maxlength="32" readonly="readonly"/>
							</td>
						</tr>

						<tr>
							<td class="tdForms">
								<label class="labelForms" for="palavraNova">Palavra-Chave Nova</label>
							</td>
						</tr>
						
						<tr>
							<td class="field">
								<input class="input" name="palavraNova" type="text" value="" maxlength="32" />
								<input class="input" name="action" type="hidden" value="edit"/>
								<input class="input" name="tema" type="hidden" value="<%=request.getParameter("tema") %>"/>
							</td>
							<td class="status"></td>
						</tr>

						<tr>
							<td class="tdForms">
								<br>
								<input class="buttonRegistrar" id="signupsubmit" name="Atualizar" type="submit" value="Atualizar" />
								<label style="padding-left: 10px;"></label>
								<input class="buttonCancelar" type="button" value="Cancelar" onClick="history.go(-1)"/>
							</td>
						</tr>
					</table>
				</form>
			</div>

			<!-- Rodape -->
			<%@include file="/WEB-INF/templates/footer.jsp"%>
		</div>
	</body>
</html>