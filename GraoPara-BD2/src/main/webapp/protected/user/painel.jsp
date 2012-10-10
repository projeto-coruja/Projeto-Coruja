<!doctype html>
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
		<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js" charset="utf-8"></script>

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
				<%@include file="/templates/login.jsp" %>

				<!-- Area de menu -->
				<%@include file="/templates/userMenu.jsp"%>
			</div>

			<div class="content" id="content">
				<!-- Novo formulario para mudanca de senha -->
				<h1>Painel de Controle</h1>

				<form id="signupform" autocomplete="off" action="/GraoPara/doChangesToAccount?action=editPassword" method="post">
					<table class="tableControle">
						<tr>
							<td colspan="3">
								<label class="labelForms">
									<strong>MUDAR SENHA ATUAL</strong>
								</label>
							</td>
						</tr>

						<tr>
							<td class="tdControle">
								<label class="labelForms"  id="lpassword" for="password">
									Senha Atual:
									<span class="asterisco">*</span>
								</label>
							</td>

							<td class="field">
								<input id="senhaAtual" class="input" name="senhaAtual" type="password" maxlength="50" value="" />
							</td>

							<td class="status"></td>
						</tr>

						<tr>
							<td class="tdControle">
								<label class="labelForms"  id="lpassword" for="password">
									Nova Senha:
									<span class="asterisco">*</span>
								</label>
							</td>

							<td class="field">
								<input id="senhaNova" class="input" name="senhaNova" type="password" maxlength="50" value="" />
							</td>

							<td class="status"></td>
						</tr>

						<tr>
							<td class="tdControle">
								<label class="labelForms"  id="lpassword" for="password">
									Confirme Nova Senha:
									<span class="asterisco">*</span>
								</label>
							</td>

							<td class="field">
								<input id="senhaConfirme" class="input" name="senhaConfirme" type="password" maxlength="50" value="" />
							</td>

							<td class="status"></td>
						</tr>

						<tr>
							<td class="tdForms">
								<input class="buttonRegistrar" id="signupsubmit" name="inserir" type="submit" value="Enviar" />
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