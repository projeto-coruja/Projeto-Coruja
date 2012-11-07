<!doctype html>
<%@page import="webview.worker.PanelWorker"%>
<%@page import="webview.util.WebUtility"%>

<html>
	<head>
		<meta charset="utf-8">
		<title>Gr�o-Par�</title>

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

		<!-- Import dos scripts de valida��o de formul�rio -->
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
				<h1> Edi��o do Tipo de Documento</h1>

				<form action="/GraoPara/doPasswordRecovery" id="signupform"  method="post" autocomplete="off">
					<table class="tableForms">
						<tr>
							<td class="tdForms">
								<label class="labelForms"  id="ltpDocAntigo" for="tpDocAntigo">Tipo de Documento Antigo</label>
							</td>
						</tr>

						<tr>
							<td class="field">
								<input class="input" id="tpDocAntigo" name="tpDocAntigo" type="text" value="" maxlength="20" readonly="readonly"/>
							</td>
							<td class="status"></td>
						</tr>

						<tr>
							<td class="tdControle">
								<label class="labelForms"  id="ltpDocNovo" for="tpDocNovo">Tipo de Documento Novo</label>
							</td>
						</tr>
						
						<tr>
							<td class="field">
								<input class="input" id="tpDocNovo" name="tpDocNovo" type="text" value="" maxlength="20" />
							</td>
							<td class="status"></td>
						</tr>

						<tr>
							<td class="tdFroms">
								<br>
								<input class="buttonRegistrar" id="signupsubmit" name="Enviar" type="submit" value="Atualizar" />
								<label style="padding-left: 10px;"></label>
								<input class="buttonCancelar" type="button" value="Cancelar" onClick="history.go(-1)">
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