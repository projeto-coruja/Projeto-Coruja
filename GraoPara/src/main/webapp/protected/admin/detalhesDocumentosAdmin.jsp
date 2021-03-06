<!doctype html>
<%@page import="webview.WebUtility"%>
<html>
<head>
<meta charset="utf-8">
<title>Gr�o-Par�</title>

<!-- Import dos styles CSS -->
<link rel="stylesheet" type="text/css"
	href="/GraoPara/css/principal.css" />
<link rel="stylesheet" type="text/css" href="/GraoPara/css/tabs.css" />
<link rel="stylesheet" type="text/css" href="/GraoPara/css/controle.css" />

<!-- CSS das valida��es -->
<link rel="stylesheet" type="text/css" media="screen"
	href="/GraoPara/css/styleValidation.css" />

<!-- Import dos javascripts -->
<script type="text/javascript" src="/GraoPara/javascript/cookie.js"
	charset="utf-8"></script>
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"
	charset="utf-8"></script>
<script src="/GraoPara/javascript/chili-1.7.pack.js"
	type="text/javascript"></script>

<!-- Import dos scripts de valida��o de formul�rio -->
<script src="/GraoPara/javascript/jquery.js" type="text/javascript"
	charset="utf-8"></script>
<script src="/GraoPara/javascript/validate.js" type="text/javascript"
	charset="utf-8"></script>
<script src="/GraoPara/javascript/validate_pt_br.js"
	type="text/javascript" charset="utf-8"></script>
	
	
</head>

<body>

	<div class="container">
		<div class="header"></div>

		<!-- Come�o do menu lateral -->
		<div class="sidebar1">

			<!--Depois de logado-->
			<div class="bordaBox">
				<b class="b1"></b><b class="b2"></b><b class="b3"></b><b class="b4"></b>
				<div class="conteudo">
			<div class="LoginArea" id="logado" style="display:block;">
				<form method="post" action="/GraoPara/doLogout">
					<fieldset>
						<label class="sidebar" for="login">Bem vindo
						<%
							WebUtility.printName(request, out);
						%>
						</label>
					</fieldset>
					<fieldset>
						<input class="buttonSair" type="submit" name="Sair" value="Sair" />
					</fieldset>
				</form>
			</div>
			</div>
				<b class="b4"></b><b class="b3"></b><b class="b2"></b><b class="b1"></b>
			</div>	
			<!-- ----------------------------------------------------------------------- -->

			<div class="bordaBox">
				<b class="b1"></b><b class="b2"></b><b class="b3"></b><b class="b4"></b>
				<div class="conteudo">
					<article class="menuLateral">
						<ul class="nav" id="menu">
							<li><a href="/GraoPara/protected/admin/indexAdmin.jsp">Home</a></li>
							<li><a href="/GraoPara/protected/admin/pesquisaAdmin.jsp">Pesquisar</a></li>
							<li><a href="/GraoPara/protected/admin/painelAdmin.jsp">Painel Admin</a></li>					
							<li><a href="/GraoPara/protected/admin/gerarSenha.jsp">Gerar Senha</a></li>					
						</ul>
					</article>
				</div>
				<b class="b4"></b><b class="b3"></b><b class="b2"></b><b class="b1"></b>
			</div>	
			<div class="bordaBox">
				<b class="b1"></b><b class="b2"></b><b class="b3"></b><b class="b4"></b>
				<div class="conteudo">
					<article class="menuLateral">
						<ul class="nav" id="menu">
							<li><a href="/GraoPara/protected/admin/cadastroDocumentosAdmin.jsp">Cadastrar Documento</a></li>					
							<li><a href="/GraoPara/protected/admin/cadastrarPalavrasChave.jsp">Cadastrar Palavras-Chave</a></li>									
							<li><a href="/GraoPara/protected/admin/cadastrarOrigem.jsp">Cadastrar C�dices/Caixas</a></li>					
							<li><a href="/GraoPara/protected/admin/cadastrarTipoDocumento.jsp">Cadastrar Tipo de Documento</a></li>	
							<li><a href="/GraoPara/protected/admin/cadUserAdmin.jsp">Cadastrar Usu�rio</a></li>
						</ul>
					</article>
				</div>
				<b class="b4"></b><b class="b3"></b><b class="b2"></b><b class="b1"></b>
			</div>	
			<div class="bordaBox">
				<b class="b1"></b><b class="b2"></b><b class="b3"></b><b class="b4"></b>
				<div class="conteudo">
					<article class="menuLateral">
						<ul class="nav" id="menu">	
							<li><a href="/GraoPara/protected/admin/tutorialPesquisaAdmin.jsp">Como pesquisar no acervo</a></li>					
							<li><a href="/GraoPara/protected/admin/sobreAdmin.jsp">Sobre</a></li>		
							<li><a href="/GraoPara/protected/admin/creditosAdmin.jsp">Cr�ditos</a></li>								
						</ul>
					</article>
					</div>
					<b class="b4"></b><b class="b3"></b><b class="b2"></b><b class="b1"></b>
				</div>
		</div>
		<!-- Fim do Menu Lateral -->
		<div class="content" id="content">
			<h2>Edi��o de Documentos</h2>
			<form id="signupform" autocomplete="off" method="POST"
				action="/GraoPara/protected/admin/updateDoc">
				<table class="tableForms">
					<tr>
						<td class="tdForms">
							<label class="labelForms" id="lidentificacao" for="identificacao">Identifica��o<span class="asterisco">*</span></label>
						</td>
						<td class="field">
							<select name="identificacao" class="inputLong" id="identificacao">
								<%= WebUtility.printCadastroOrigem(request) %>
							</select>
						</td>
						<td class="status"></td>
					</tr>
					<tr>
					<tr>
						<td class="tdForms"><label class="labelForms" id="lnumero" for="numero">N�mero
								APEP ou Sequencial:<span class="asterisco">*</span>
						</label></td>
						<td class="field"><select name="tipo_num"
							class="inputTipoNum" id="tipo_num">
								<%= WebUtility.printSelectId(request)%>
						</select> <input class="inputShort" name="numero" id="numero" type="text"
							maxlength="4" value=<%=WebUtility.printLabel(request, "numeroAPEP")%>></td>
						<td class="status"></td>
					</tr>
					
					<tr>
						<td class="tdForms"><label class="labelForms" id="lautor" for="autor">Autor
								do Documento:<span class="asterisco">*</span>
						</label></td>
						<td class="field"><input class="input" name="autor"
							id="autor" type="text" size="20" maxlength="48"
							value="<%=WebUtility.printLabel(request, "autor")%>"></td>
						<td class="status"></td>
					</tr>
					<tr>
						<td class="tdForms"><label class="labelForms" id="ldestinatario"
							for="destinatario">Destinat�rio do Documento:<span
								class="asterisco">*</span></label></td>
						<td class="field"><input class="input" name="destinatario"
							id="destinatario" type="text" size="20" maxlength="48"
							value="<%=WebUtility.printLabel(request, "destinatario")%>">
						</td>
						<td class="status"></td>
					</tr>
					<tr>
						<td class="tdForms"><label class="labelForms" id="llocal" for="local">Local:<span
								class="asterisco">*</span></label></td>
						<td class="field"><input class="input" name="local"
							id="local" type="text" maxlength="48"
							value="<%=WebUtility.printLabel(request, "local")%>"></td>
						<td class="status"></td>
					</tr>
					<tr>
						<td class="tdForms"><label class="labelForms" id="ldata" for="data">Data do Documento:<span class="asterisco">*</span></label></td>
						<td class="field"><select name="dia" id="dia"
							class="inputShort">
								<%=WebUtility.printSelectDia(request) %>
								<option value="01">1</option>
								<option value="02">2</option>
								<option value="03">3</option>
								<option value="04">4</option>
								<option value="05">5</option>
								<option value="06">6</option>
								<option value="07">7</option>
								<option value="08">8</option>
								<option value="09">9</option>
								<option value="10">10</option>
								<option value="11">11</option>
								<option value="12">12</option>
								<option value="13">13</option>
								<option value="14">14</option>
								<option value="15">15</option>
								<option value="16">16</option>
								<option value="17">17</option>
								<option value="18">18</option>
								<option value="19">19</option>
								<option value="20">20</option>
								<option value="21">21</option>
								<option value="22">22</option>
								<option value="23">23</option>
								<option value="24">24</option>
								<option value="25">25</option>
								<option value="26">26</option>
								<option value="27">27</option>
								<option value="28">28</option>
								<option value="29">29</option>
								<option value="30">30</option>
								<option value="31">31</option></select> <select name="mes" id="mes"
							class="inputShort">
								<%= WebUtility.printSelectMes(request) %>
								<option value="01">Jan</option>
								<option value="02">Fev</option>
								<option value="03">Mar</option>
								<option value="04">Abr</option>
								<option value="05">Mai</option>
								<option value="06">Jun</option>
								<option value="07">Jul</option>
								<option value="08">Ago</option>
								<option value="09">Set</option>
								<option value="10">Out</option>
								<option value="11">Nov</option>
								<option value="12">Dez</option></select> <label class="labelForms"
							id="ldata" for="data">Ano:</label><input class="inputShort"
							type="text" name="ano" id="ano" maxlength="4" value="<%=WebUtility.printLabel(request, "ano")%>"/></td>
						<td class="status"></td>
					</tr>
					<tr>
						<td class="tdForms"><label class="labelForms" id="ltipoDoc" for="tipoDoc">Tipo
								do Documento:<span class="asterisco">*</span>
						</label></td>
						<td class="field"><select class="input" name="tipoDoc" id="tipoDoc">
								<!-- Pegar do Banco de dados os tipos e, caso o usuário selecione outro, exibir campo para cadastrar outro tipo -->
								<%= WebUtility.printSelectTipoDoc(request) %>
						</select></td>
						<td class="status"></td>
					</tr>
					<tr>
						<td colspan="3"><label class="labelForms">
							<strong>RESUMO OU VERBETE DO DOCUMENTO:<span class="asterisco">*</span></strong></label>
						</td>
					</tr>
					<tr>
						<td class="field" colspan="2">
							<textarea class="inputResumo" id="resumo" name="resumo" rows="7" cols="40" maxlength="2048" ><%=WebUtility.printLabel(request, "resumo")%></textarea>
						</td>
						<td class="status"></td>
					</tr>
					<tr>
						<td colspan="3">
							<label for="palavrasChaves"class="labelForms">Palavra Chaves:<span class="asterisco">(Obrigat�rio pelo menos uma)</span></label>
						</td>
					</tr>
				
					<tr>
						<td class="field" colspan="2">
							<%=WebUtility.printInputKeyWords(request, "chave1")%>
							<%=WebUtility.printInputKeyWords(request, "chave2")%>
							<%=WebUtility.printInputKeyWords(request, "chave3")%>
						</td>
					</tr>
					
					<tr>
						<td class="tdControle" colspan="3">
						<p></p>
							<input class="buttonCancelar" type="button" value="Cancelar" onClick="history.go(-1)"> <input class="buttonRegistrar" id="signupsubmit" name="Enviar" type="submit" value="Enviar" />
						</td>
					</tr>
				</table>
				<input class="inputShort" name="pesquisa_APEP_SEQ" id="numero" type="hidden" value=<%= WebUtility.printLabel(request, "tipoAPEP_SEQ") %>>
				<input class="inputShort" name="pesquisa_num_APEP_SEQ" id="numero" type="hidden" value=<%= WebUtility.printLabel(request, "numeroAPEP")%>>
			</form>
		</div>
		<!-- Come�o do Rodap� -->
		<div class="footer">
			<p>Copyright � - Universidade Federal de S�o Paulo - UNIFESP 2012</p>
			<p>Desenvolvido pelo grupo Coruja</p>
		</div>
		<!-- Fim do Rodap� -->
		<!-- end .container -->
	</div>
</body>
</html>
