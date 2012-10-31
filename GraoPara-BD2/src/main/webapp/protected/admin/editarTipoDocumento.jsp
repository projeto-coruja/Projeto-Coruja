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

		<!-- Import dos scripts de validação de formulário -->
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
				<%@include file="/WEB-INF/templates/loginReception.jsp" %>

				<!-- Area de menu -->
				<%@include file="/WEB-INF/templates/adminMenu.jsp"%>
			</div>

			<div class="content" id="content">
				<h1> Editar Tipos de Documentos</h1>

				<form action="/GraoPara/doPasswordRecovery" id="signupform"  method="post" autocomplete="off">
					<table class="tableForms">
						<tr>
							<td class="tdControle">
								<label class="labelForms"  id="ltpDocAntigo" for="tpDocAntigo">
									Tipo de documento Antigo:
									<span class="asterisco">*</span>
								</label>
							</td>

							<td class="field">
								<input class="input" id="tpDocAntigo" name="tpDocAntigo" type="text" value="" maxlength="20" readonly="readonly"/>
							</td>

							<td class="status"></td>
						</tr>

						<tr>
							<td class="tdControle">
								<label class="labelForms"  id="ltpDocNovo" for="tpDocNovo">
									Tipo de documento novo:
									<span class="asterisco">*</span>
								</label>
							</td>

							<td class="field">
								<input class="input" id="tpDocNovo" name="tpDocNovo" type="text" value="" maxlength="20" />
							</td>

							<td class="status"></td>
						</tr>

						<tr>
							<td class="tdControle" colspan="3">
								<input class="buttonCancelar" type="button" value="Cancelar" onClick="history.go(-1)">
								<input class="buttonRegistrar" id="signupsubmit" name="Enviar" type="submit" value="Enviar" />
							</td>
						</tr>
					</table>
				</form>
			</div>

			<!-- Rodape -->
			<div class="footer">
				<p>Copyright © - Universidade Federal de São Paulo - UNIFESP 2012</p>
				<p>Desenvolvido pelo grupo Coruja</p>
			</div>
		</div>
	</body>
</html>