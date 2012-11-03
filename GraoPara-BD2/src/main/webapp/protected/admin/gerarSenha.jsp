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
		<link rel="stylesheet" type="text/css" media="screen" href="/GraoPara/css/styleValidation.css" />

		<!-- Import dos javascripts -->
		<script type="text/javascript" src="/GraoPara/javascript/ajax.js" charset="utf-8"></script>
		<script type="text/javascript" src="/GraoPara/javascript/instrucao.js" charset="utf-8"></script>
		<script src="/GraoPara/javascript/chili-1.7.pack.js" type="text/javascript"></script>
		<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"charset="utf-8"></script>

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
				<%@include file="/WEB-INF/templates/adminMenu.jsp"%>
			</div>

			<div class="content" id="content">
				<h1>Geração de Senha</h1>

				<form id="signupform" method="post" autocomplete="off" action="/GraoPara/doPasswordRecovery">
					<table class="tableForms">
						<tr>
							<td class="tdControle">
								<label id="lemail" class="labelForms" for="email">Email do Usuário</label>
							</td>
						</tr>
						
						<tr>
							<td class="field">
								<input id="email" class="input" type="text" name="email" maxlength="150" style="width:350px;"/>
							</td>
							<td class="status"></td>
						</tr>

						<tr>
							<td class="tdControle">
								<br>
								<input id="signupsubmit" class="buttonRegistrar" type="submit" name="Enviar" value="Gerar"/>
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