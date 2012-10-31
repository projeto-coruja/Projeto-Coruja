<!doctype html>
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
		<script type="text/javascript" src="/GraoPara/javascript/cookie.js" charset="utf-8"></script>
		<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js" charset="utf-8"></script>
		<script src="/GraoPara/javascript/chili-1.7.pack.js" type="text/javascript"></script>

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
				<%@include file="/WEB-INF/templates/loginReception.jsp" %>

				<!-- Area de menu -->
				<%@include file="/WEB-INF/templates/adminMenu.jsp"%>
			</div>

			<div class="content" id="content">
				<h1>Editar C�dice/Caixa</h1>

				<form id="editOriginForm" autocomplete="off" method="post" action="/GraoPara/protected/admin/editOrigin">
					<table class="tableControle">
						<tr>
							<td class="tdForms"><label class="labelForms" id="lcodigo" for="codigo">Editando:</label></td>
							<td class="field"><input readonly="readonly" name= "codigo" id="codigo" value=<%=request.getParameter("codigo")%> /></td>
						</tr>
						
						<tr>
							<td class="tdForms"><label class="labelForms" id="ltitulo" for="titulo">T�tulo <span class="asterisco">*</span></label></td>
							<td class="field">
								<textarea class="inputResumo" name="titulo" id="titulo" rows="5" cols="40" maxlength="512"><%=WebUtility.printTituloCodCaixa(request)%></textarea>
							</td>
							<td class="status"></td>
						</tr>
						
						<tr>
							<td class="tdForms"><label class="labelForms" id="lanoIni" for="anoIni">Ano de In�cio</label></td>
							<td class="field"><input class="inputShort" name="anoIni" size="10" id="anoIni" type="text" maxlength="4" value=<%=request.getParameter("anoIni")%>></td>
							<td class="status"></td>
						</tr>
						
						<tr>
							<td class="tdForms"><label class="labelForms" id="lanoFim" for="anoFim">Ano de Fim</label></td>
							<td class="field"><input class="inputShort" name="anoFim" size="10" id="anoFim" type="text" maxlength="4" value=<%=request.getParameter("anoFim")%>></td>
							<td class="status"></td>
						</tr>

						<tr>
							<td class="tdControle" colspan="3">
								<input class="buttonCancelar" type="button" value="Cancelar" onClick="history.go(-1)">
								<input class="buttonRegistrar" id="signupsubmit" name="Atualizar" type="submit" value="Atualizar" />
							</td>
						</tr>
					</table>
				</form>
			</div>

			<!-- Rodape -->
			<div class="footer">
				<p>Copyright � - Universidade Federal de S�o Paulo - UNIFESP 2012</p>
				<p>Desenvolvido pelo grupo Coruja</p>
			</div>
		</div>
	</body>
</html>