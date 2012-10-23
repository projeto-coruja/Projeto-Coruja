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
		<script type="text/javascript" src="/GraoPara/javascript/cookie.js"	charset="utf-8"></script>
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
				<%@include file="/templates/loginReception.jsp" %>

				<!-- Area de menu -->
				<%@include file="/templates/adminMenu.jsp"%>
			</div>

			<div class="content" id="content">
				<h2>Detalhes do Documento</h2>

				<form id="signupform" autocomplete="off" method="POST" action="/GraoPara/protected/admin/updateDoc">
					<table class="tableForms">
						<tr>
							<td class="tdForms"><label class="labelForms" id="lidentificacao" for="identificacao">Códice/Caixa <span class="asterisco">*</span></label></td>
							<td class="field"><select name="identificacao" class="inputLong" id="identificacao"><%=WebUtility.printTituloCodiceCaixa(true)%></select></td>
							<td class="status"></td>
						</tr>
						
						<tr>
							<td class="tdForms"><label class="labelForms" id="lanoInicioCodiceCaixa" for="anoInicioCodiceCaixa">Início de Ano do Códice/Caixa <span class="asterisco">*</span></label></td>
							<td class="field"><input class="input" name="anoInicioCodiceCaixa" id="anoInicioCodiceCaixa" type="text" size="20" maxlength="4"></td>
							<td class="status"></td>
						</tr>
						
						<tr>
							<td class="tdForms"><label class="labelForms" id="lanoFimCodiceCaixa" for="anoFimCodiceCaixa">Fim de Ano do Códice/Caixa <span class="asterisco">*</span></label></td>
							<td class="field"><input class="input" name="anoFimCodiceCaixa" id="anoFimCodiceCaixa" type="text" size="20" maxlength="4"></td>
							<td class="status"></td>
						</tr>

						<tr>
							<td class="tdForms"><label class="labelForms" id="lnumero" for="numero">Número APEP ou Sequencial <span class="asterisco">*</span></label></td>
							<td class="field">
								<select name="tipo_num" class="inputTipoNum" id="tipo_num">
									<option value="" selected>Selecione...</option>
									<option value="APEP">APEP</option>
									<option value="SEQ">Sequencial</option>
								</select>
								<input class="inputShort" name="numero" id="numero" type="text" maxlength="4">
							</td>
							<td class="status"></td>
						</tr>

						<tr>
							<td class="tdForms"><label class="labelForms" id="ltituloDocumento" for="tituloDocumento">Título do Documento <span class="asterisco">*</span></label></td>
							<td class="field"><input class="input" name="tituloDocumento" id="tituloDocumento" type="text" size="20" maxlength="1024"></td>
							<td class="status"></td>
						</tr>
						
						<tr>
							<td class="tdForms"><label class="labelForms" id="lautor" for="autor">Autor do Documento <span class="asterisco">*</span></label></td>
							<td class="field"><input class="input" name="autor" id="autor" type="text" size="20" maxlength="1024"></td>
							<td class="status"></td>
						</tr>
						
						<tr>
							<td class="tdPesquisa"><label class="labelForms" id="lautorOcupacao" for="autorOcupacao">Ocupação do Autor do Documento <span class="asterisco">*</span></label></td>
							<td class="field"><input class="input" name="autorOcupacao" id="autorOcupacao" type="text" size="20" maxlength="48"></td>
							<td class="status"></td>
						</tr>

						<tr>
							<td class="tdForms"><label class="labelForms" id="ldestinatario" for="destinatario">Destinatário do Documento <span class="asterisco">*</span></label></td>
							<td class="field"><input class="input" name="destinatario" id="destinatario" type="text" size="20" maxlength="1024"></td>
							<td class="status"></td>
						</tr>
						
						<tr>
							<td class="tdPesquisa"><label class="labelForms" id="lautorOcupacao" for="autorOcupacao">Ocupação do Destinatário do Documento <span class="asterisco">*</span></label></td>
							<td class="field"><input class="input" name="destinatarioOcupacao" id="autorOcupacao" type="text" size="20" maxlength="48"></td>
							<td class="status"></td>
						</tr>

						<tr>
							<td class="tdForms"><label class="labelForms" id="llocal" for="local">Local <span class="asterisco">*</span></label></td>
							<td class="field"><input class="input" name="local" id="local" type="text" maxlength="1024"></td>
							<td class="status"></td>
						</tr>

						<tr>
							<td class="tdForms">
								<label class="labelForms" id="ldata" for="data">
									Data do Documento 
									<span class="asterisco">*</span>
								</label>
							</td>
							<%@include file="/templates/datesCadastre.jsp" %>
							<td class="status"></td>
						</tr>

						<tr>
							<td class="tdForms"><label class="labelForms" id="ltipoDoc" for="tipoDoc">Tipo do Documento <span class="asterisco">*</span></label></td>
							<td class="field">
								<!-- Pegar do Banco de dados os tipos e, caso o usuario selecione outro, exibir campo para cadastrar outro tipo -->
								<select class="input" name="tipoDoc" id="tipoDoc">
									<%= WebUtility.printSelectTipoDoc(request) %>
								</select>
							</td>
							<td class="status"></td>
						</tr>

						<tr>
							<td class="tdForms"><label class="labelForms" id="ldescricaoTipoDocumento" for="descricaoTipoDocumento">Descrição do Tipo de Documento <span class="asterisco">*</span></label></td>
							<td class="field"><input class="input" name="descricaoTipoDocumento" id="descricaoTipoDocumento" type="text" size="20" maxlength="1024"></td>
							<td class="status"></td>
						</tr>

						<tr>
							<td colspan="3"><label class="labelForms">Resumo ou Veberbete do Documento <span class="asterisco">*</span></label></td>
						</tr>

						<tr>
							<td class="field" colspan="2"><textarea class="inputResumo" id="resumo" name="resumo" rows="7" cols="40" maxlength="2048"></textarea></td>
							<td class="status"></td>
						</tr>

						<tr>
							<td colspan="3"><label for="palavrasChaves" class="labelForms">Palavra Chaves <span class="asterisco">(Obrigatório Pelo Menos Uma)</span></label></td>
						</tr>

						<tr>
							<td class="field" colspan="2">
								 <select class="input" name="chave1" id="chave1" style="width: 120px" onchange="changeToInput(this);">
									<option value = "">Nenhuma</option>
									<%= WebUtility.printSelectKeyWords(request, "chave1") %>
									<option value = "">Nova...</option>
								</select>

								<select class="input" name="chave2" id="chave2" style="width: 120px" onchange="changeToInput(this);">
									<option value = "">Nenhuma</option>
									<%= WebUtility.printSelectKeyWords(request, "chave2") %>
									<option value = "">Novo...</option>
								</select>

								<select  class="input" name="chave3" id="chave3" style="width: 120px" onchange="changeToInput(this);">
									<option value = "">Nenhuma</option>
									<%= WebUtility.printSelectKeyWords(request, "chave3") %>
									<option value = "">Novo...</option>
								</select>
							</td>

							<td class="status"></td>
						</tr>

						<tr>
							<td class="tdControle" colspan="3">
								<input class="buttonCancelar" type="button" value="Cancelar" onClick="history.go(-1)" />
								<input class="buttonRegistrar" id="signupsubmit" name="Enviar" type="submit" value="Atualizar" />
							</td>
						</tr>
					</table>

					<input class="inputShort" name="pesquisa_APEP_SEQ" id="numero" type="hidden" value=<%=WebUtility.printLabel(request, "tipoAPEP_SEQ")%>>
					<input class="inputShort" name="pesquisa_num_APEP_SEQ" id="numero" type="hidden" value=<%=WebUtility.printLabel(request, "numeroAPEP")%>>
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