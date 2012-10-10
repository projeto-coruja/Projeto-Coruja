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
		<link rel="stylesheet" type="text/css" href="/GraoPara/css/validationEngine.jquery.css" />

		<!-- Import dos javascripts -->
		<script type="text/javascript" src="/GraoPara/javascript/cookie.js"	charset="utf-8"></script>
	</head>

	<body onloadstart="checkCookie()">
		<div class="container">
			<div class="header"></div>

			<!-- Menu lateral -->
			<div class="sidebar1">
				<!-- Area de login -->
				<%@include file="/templates/login.jsp" %>

				<!-- Area de menu -->
				<%@include file="/templates/adminMenu.jsp"%>
			</div>

			<div class="content" id="content">
				<h1>Editar Documentos</h1>

				<form action="/GraoPara/doSearch" method="POST" name="cadastro" autocomplete="off">
					<table class="tableForms">
						<tr>
							<td><label class="labelForms" id="lidentificacao" for="identificacao">Identificação</label></td>

							<td class="field">
								<select name="identificacao" class="input" id="identificacao">
										<%=WebUtility.printTituloCodiceCaixa(request)%>
								</select>
							</td>

							<td class="status"></td>
						</tr>

						<tr>
							<td><label class="labelForms" id="lcodigo" for="codigo">Código:</label></td>

							<td class="field">
								<input class="input" name="codigo" id="codigo" type="text" maxlength="5">
							</td>

							<td class="status"></td>
						</tr>

						<tr>
							<td><label class="labelForms" id="ltitulo" for="titulo" >Título:</label></td>

							<td class="field"><input class="input" name="titulo" id="titulo" type="text" size="20" maxlength="500"></td>

							<td class="status"></td>
						</tr>

						<tr>
							<td><label class="labelForms" id="lnumero" for="numero">Número APEP ou Sequencial:</label></td>

							<td class="field">
								<input class="input" name="numero" id="numero" type="text" maxlength="4">
							</td>

							<td class="status"></td>
						</tr>

						<tr>
							<td><label class="labelForms" id="lautor" for="autor">Autor do Documento:</label></td>

							<td class="field">
								<input class="input" name="autor" id="autor" type="text" size="20" maxlength="48">
							</td>

							<td class="status"></td>
						</tr>

						<tr>
							<td><label class="labelForms" id="ldestinatario" for="destinatario">Destinatário do Documento:</label></td>

							<td class="field">
								<input class="input" name="destinatario" id="destinatario" type="text" size="20" maxlength="48">
							</td>

							<td class="status"></td>
						</tr>

						<tr>
							<td><label class="labelForms" id="llocal" for="local">Local:</label></td>

							<td class="field">
								<input class="input" name="local" id="local" type="text" maxlength="48">
							</td>

							<td class="status"></td>
						</tr>

						<tr>
							<td><label class="labelForms" id="ldata" for="data">Data do Documento:</label></td>

							<td class="field">
								<select name="dia" id="dia" class="inputShort">
									<option value="" selected="selected">Dia...</option>
									<option value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="4">4</option>
									<option value="5">5</option>
									<option value="6">6</option>
									<option value="7">7</option>
									<option value="8">8</option>
									<option value="9">9</option>
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
									<option value="31">31</option>
								</select>

								<select name="mes" id="mes" class="inputShort">
									<option value="" selected="selected">Mês...</option>
									<option value="1">Janeiro</option>
									<option value="2">Fevereiro</option>
									<option value="3">Março</option>
									<option value="4">Abril</option>
									<option value="5">Maio</option>
									<option value="6">Junho</option>
									<option value="7">Julho</option>
									<option value="8">Agosto</option>
									<option value="9">Setembro</option>
									<option value="10">Outubro</option>
									<option value="11">Novembro</option>
									<option value="12">Dezembro</option>
								</select>

								<label class="labelForms" id="ldata" for="data">Ano:</label>
								<input class="inputShort" type="text" name="ano" id="ano" maxlength="4"/>
							</td>

							<td class="status"></td>
						</tr>

						<tr>
							<td><label class="labelForms" id="ltipoDoc" for="tipoDoc">Tipo do Documento:</label></td>

							<td class="field">
								<!-- Pegar do Banco de dados os tipos e, caso o usuario selecione outro, exibir campo para cadastrar outro tipo -->
								<select class="input" name="tipoDoc" id="tipoDoc">
									<%= WebUtility.printSelectTipoDoc(request) %>
								</select>
							</td>

							<td class="status"></td>
						</tr>

						<tr>
							<td colspan="3">
								<label for="palavrasChaves" class="labelForms">Palavra Chaves:</label>
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