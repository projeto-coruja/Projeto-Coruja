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
		<script type="text/javascript" src="/GraoPara/javascript/cookie.js" charset="utf-8"></script>
		<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js" charset="utf-8"></script>
		<script src="/GraoPara/javascript/chili-1.7.pack.js" type="text/javascript"></script>

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
				<h1>Edição de Usuário</h1>

				<form id="signupform" autocomplete="off" method="post" action="/GraoPara/doChangesToAccount?action=editPermission">
					<table class="tableForms">
						<tr>
							<td>
								<label class="labelForms" id="lfirstname" for="nome">Nome</label>
							</td>
						</tr>
						
						<tr>
							<td class="field">
								<input class="input" id="nome" name="nome" type="text" style="width:350px;" value="<%= request.getParameter("paramName") %>" maxlength="100" readonly="readonly" />
							</td>
							<td class="status"></td>
						</tr>

						<tr>
							<td>
								<label class="labelForms"  id="lemail" for="email">Email</label>
							</td>
						</tr>
						
						<tr>
							<td class="field">
								<input class="input" id="email" name="email" type="text" style="width:350px;" value="<%= request.getParameter("paramEmail") %>" maxlength="150" readonly="readonly"/>
							</td>
							<td class="status"></td>
						</tr>

						<tr>
							<td>
								<label class="labelForms" id="lpermissao" for="permissao">Permissão</label>
							</td>
						</tr>

						<tr>
							<td class="field">
								<select name="permissao" class="inputLong" id="permissao" style="width:354px;" >
									<option value="">Selecione...</option>
									<% PanelWorker.listAllAvailableProfile(request, out); %>
								</select>
							</td>
							<td class="status"></td>
						</tr>

						<tr>
							<td class="tdForms">
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