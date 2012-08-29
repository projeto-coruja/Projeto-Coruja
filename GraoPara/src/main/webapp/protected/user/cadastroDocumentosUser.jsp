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
<body onloadstart="checkCookie()">
	<div class="container">
		<div class="header"></div>
		
		<!-- Come�o do menu lateral -->
		<div class="sidebar1">

			<!--Depois de logado-->
			<div class="LoginArea" id="logado" style="display:block;">
				<form method="post" action="/GraoPara/doLogout">
					<fieldset>
						<label for="login">Bem vindo</label>
						<%
							WebUtility.printName(request, out);
						%>
					</fieldset>
					<fieldset>
						<input class="buttonSair" type="submit" name="Sair" value="Sair" />
					</fieldset>
				</form>
			</div>
			<!-- ----------------------------------------------------------------------- -->

			<article class="menuLateral">  
				<ul class="nav" id="menu">
					<li><a href="/GraoPara/protected/user/indexUser.jsp">Home</a></li>
					<li><a href="/GraoPara/protected/user/pesquisaUser.jsp">Pesquisar</a></li>
					<li><a href="/GraoPara/protected/user/cadastroDocumentosUser.jsp">Cadastrar Documento</a></li>
					<li><a href="/GraoPara/protected/user/painelUser.jsp">Painel User</a></li>
					<li><a href="/GraoPara/protected/user/sobreUser.jsp">Sobre</a></li>
					<li><a href="#">Cr�ditos</a></li>
				</ul>
			</article>
		</div>
		<!-- Fim do Menu Lateral -->
		<div class="content" id="content">
				
			<h1>Cadastro de Documentos</h1>
			<form id="signupform" autocomplete="off" method="POST" action="/GraoPara/addDoc">
				<table class="tableForms">
					<tr>
						<td colspan="3">
							<label class="labelForms"><strong>PREENCHA TODOS OS CAMPOS COM ASTER�SCO<span class="asterisco">*</span></strong></label>
						</td>
					</tr>
					<tr>
						<td class="tdForms">
							<label class="labelForms" id="lidentificacao" for="identificacao">Identifica��o<span class="asterisco">*</span></label>
						</td>
						<td class="field">
							<select name="identificacao" class="input" id="identificacao">
									<option value="">Selecione...</option>
									<option value="codice">N�mero de C�dice</option>
									<option value="caixa">N�mero da Caixa</option>
							</select>
						</td>
						<td class="status"></td>
					</tr>
					<tr>
						<td class="tdForms">
							<label class="labelForms" id="lcodigo" for="codigo">C�digo:<span class="asterisco">*</span></label>
						</td>
						<td class="field">
							<input class="inputShort" name="codigo" size="10" id="codigo" type="text" maxlength="5">
						</td>
						<td class="status"></td>
					</tr>
					<tr>
						<td class="tdForms">
							<label class="labelForms" id="ltitulo" for="titulo">T�tulo:<span class="asterisco">*</span></label>
						</td>
						<td class="field"><input class="input" name="titulo" id="titulo" type="text" size="20" maxlength="48"></td>
						<td class="status"></td>
					</tr>
					<tr>
						<td class="tdForms">
							<label class="labelForms" id="lnumero" for="numero">N�mero APEP ou Sequencial:<span class="asterisco">*</span></label>
						</td>
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
						<td class="tdForms">
							<label class="labelForms" id="lautor" for="autor">Autor do Documento:<span class="asterisco">*</span></label>
						</td>
						<td class="field">
							<input class="input" name="autor" id="autor" type="text" size="20" maxlength="48">
						</td>
						<td class="status"></td>
					</tr>
					<tr>
						<td class="tdForms">
							<label class="labelForms" id="ldestinatario" for="destinatario">Destinat�rio do Documento:<span class="asterisco">*</span></label>
						</td>
						<td class="field">
							<input class="input" name="destinatario" id="destinatario" type="text" size="20" maxlength="48">
						</td>
						<td class="status"></td>
					</tr>
					<tr>
						<td class="tdForms">
							<label class="labelForms" id="llocal" for="local">Local:<span class="asterisco">*</span></label>
						</td>
						<td class="field">
							<input class="input" name="local" id="local" type="text" maxlength="48">
						</td>
						<td class="status"></td>
					</tr>
					<tr>
						<td class="tdForms">
							<label class="labelForms" id="ldata" for="data">Data do Documento:<span class="asterisco">*</span></label>
						</td>
						<td class="field">
							<select name="dia" id="dia" class="inputShort"><option value="" selected="selected">Dia:</option><option value="1">1</option><option value="2">2</option><option value="3">3</option><option value="4">4</option><option value="5">5</option><option value="6">6</option><option value="7">7</option><option value="8">8</option><option value="9">9</option><option value="10">10</option><option value="11">11</option><option value="12">12</option><option value="13">13</option><option value="14">14</option><option value="15">15</option><option value="16">16</option><option value="17">17</option><option value="18">18</option><option value="19">19</option><option value="20">20</option><option value="21">21</option><option value="22">22</option><option value="23">23</option><option value="24">24</option><option value="25">25</option><option value="26">26</option><option value="27">27</option><option value="28">28</option><option value="29">29</option><option value="30">30</option><option value="31">31</option></select>
							<select name="mes" id="mes" class="inputShort"><option value="" selected="selected">M�s:</option><option value="1">Jan</option><option value="2">Fev</option><option value="3">Mar</option><option value="4">Abr</option><option value="5">Mai</option><option value="6">Jun</option><option value="7">Jul</option><option value="8">Ago</option><option value="9">Set</option><option value="10">Out</option><option value="11">Nov</option><option value="12">Dez</option></select> 
							<label class="labelForms" id="ldata" for="data">Ano:</label><input class="inputShort" type="text" name="ano" id="ano" maxlength="4"/>
						</td>
						<td class="status"></td>
					</tr>
					<tr>
						<td class="tdForms">
							<label class="labelForms" id="ltipoDoc" for="tipoDoc">Tipo do Documento:<span class="asterisco">*</span></label>
						</td>
						<td class="field">
							<select class="input" name="tipoDoc" id="tipoDoc"> <!-- Pegar do Banco de dados os tipos e, caso o usuário selecione outro, exibir campo para cadastrar outro tipo -->
									<option value="">Selecione...</option>
									<option value="of�cios">Of�cios</option>
									<option value="relat�rios">Relat�rios</option>
									<option value="impressos">Impressos</option>
									<option value="processos">Processos</option>
									<option value="cartas">Cartas</option>
							</select>
						</td>
						<td class="status"></td>
					</tr>		
					<tr>
						<td colspan="3">
							<label class="labelForms"><strong>RESUMO OU VERBETE DO DOCUMENTO:<span class="asterisco">*</span></strong></label>
						</td>
					</tr>
					<tr>						
						<td class="field" colspan="2">
							<textarea class="inputResumo" id="resumo" name="resumo" rows="7" cols="40" maxlength="2048"></textarea>
						</td>
						<td class="status"></td>
					</tr>								
					<tr>
						<td colspan="3">
							<label for="palavrasChaves" class="labelForms">Palavra Chaves:<span class="asterisco">(Obrigat�rio pelo menos uma)</span></label>
						</td>
					</tr>
					<tr>
						<td class="field" colspan="2">
								<input class="inputPalavraChave" id="chave1" name="chave1" type="text" size="15" maxlength="32"> - 
								<input class="inputPalavraChave" id="chave2" name="chave2" type="text" size="15" maxlength="32"> - 
								<input class="inputPalavraChave" id="chave3" name="chave3" type="text" size="15" maxlength="32"> 
						</td>
						<td class="status"></td>
					</tr>
					<tr>
						<td class="tdForms">
							<p></p>
							<input class="buttonRegistrar" id="signupsubmit" name="inserir" type="submit" value="Enviar" />
						</td>
					</tr>
				</table>
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
