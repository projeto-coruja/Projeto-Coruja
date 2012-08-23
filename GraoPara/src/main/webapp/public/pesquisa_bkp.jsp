<!doctype html>
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
<link rel="stylesheet" type="text/css"
	href="/GraoPara/css/validationEngine.jquery.css" />

<!-- Import dos javascripts -->
<script type="text/javascript" src="/GraoPara/javascript/ajax.js"
	charset="utf-8"></script>
<script type="text/javascript" src="/GraoPara/javascript/instrucao.js"
	charset="utf-8"></script>
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"
	charset="utf-8"></script>

<!-- Import dos scripts de valida��o de formul�rio -->
<script type="text/javascript"
	src="/GraoPara/javascript/jquery.validationEngine.js" charset="utf-8"></script>
<script type="text/javascript" src="/GraoPara/javascript/script.js"
	charset="utf-8"></script>
<script type="text/javascript"
	src="/GraoPara/javascript/languages/jquery.validationEngine-pt.js"
	charset="utf-8"></script>

</head>

<body>

	<div class="container">
		<div class="header"></div>
		
		<!-- Come�o do menu lateral -->
		<div class="sidebar1">

			<!--Come�o da �rea de login -->
			<div class="LoginArea" id="LoginArea">
				<form method="post" action="/GraoPara/doLogin">
					<fieldset>
						<label for="login">Login:</label> <input class="inputLogin"
							type="text" name="login" height="30px" size="auto"
							placeholder="Seu login" required> <label for="senha">Senha:</label>
						<input class="inputLogin" type="password" name="senha"
							height="30px" size="auto" placeholder="Sua senha" required>
					</fieldset>
					<fieldset>
						<input class="buttonEntrar" type="submit" name="Entrar"
							value="Entrar" />
					</fieldset>
				</form>
			</div>
			<fieldset>
				<a href="/GraoPara/public/CadUsuario.jsp"><input type="button"
					class="buttonRegistrar" name="Registrar" value="Registrar"></a>
			</fieldset>
			<!-- Fim da �rea de login -->

			<article class="menuLateral">
				<ul class="nav" id="menu">
					<li><a href="/GraoPara/public/index.jsp">Home</a></li>
					<li><a href="/GraoPara/public/pesquisa.jsp">Pesquisar</a></li>
					<li><a href="/GraoPara/public/sobre.jsp">Sobre</a></li>
				</ul>
			</article>
		</div>
		<!-- Fim do Menu Lateral -->
		<div class="content" id="content">
			<h2>Pesquisa de Documento</h2>
			<form action="/GraoPara/doSearch" method="POST" name="cadastro">
				<table class="tableForms">
								<tr>
						<td height="20">
							<label for="identificacao" class="labelForms">Identifi��o:</label>
						</td>
						<td height="20">
						 	<select name="identificacao" class="input">
									<option value="">Selecione...</option>
									<option value="codice">N�mero de C�dice</option>
									<option value="caixa">N�mero da Caixa</option>
							</select>
						</td>
					</tr>
					<tr>
						<td height="20">
							<label for="codigo" class="labelForms">C�digo:</label>
						</td>
						<td width="377" height="20">
								<input class="input" name="codigo" type="text" size="10" maxlength="5">
						</td>
					</tr>
					<tr>
						<td height="20">
							<label for="tipoAPEP_SEQ" class="labelForms">Tipo APEP ou Sequencial:</label>
						</td>
						<td height="20">
						 	<select name="tipoAPEP_SEQ" class="input">
						 			<option value="">Selecione...</option>
									<option value="APEP">APEP</option>
									<option value="SEQ">Sequencial</option>
							</select>
						</td>
					</tr>
					<tr>
						<td height="20">
							<label for="numeroAPEP" class="labelForms">N�mero APEP ou Sequencial:</label>
						</td>
						<td>
								<input class="input" name="numeroAPEP" type="text" size="10" maxlength="4">
						</td>
					</tr>
					<tr>
						<td>
							<label for="autor" class="labelForms">Autor do Documento:</label>
						</td>
						<td>
						 		<input class="input" name="autor" type="text" size="20" maxlength="48">
						</td>
					</tr>
					<tr>
						<td>
							<label for="destinario" class="labelForms">Destinat�rio do Documento:</label>
						</td>
						<td>
						     
						    	<input class="input" name="destinatario" type="text" size="20" maxlength="48">
						</td>
					</tr>
		            <tr>
		            	<td>
							<label for="local" class="labelForms">Cidade:</label>
								
						</td>
		                <td>
		                <input class="input" name="local" type="text" size="15" maxlength="43">
		                </td>
		            </tr>
					<tr>
						<td>
							<label for="dataDocumento" class="labelForms">Data do Documento:</label>
						</td>
						<td>
						<input class="input validate[custom[date]]" type="text" name="data" id="data" maxlength="10"/>
						</td>
					</tr>
					<tr>
						<td height="20">
							<label for="dataDocumento" class="labelForms">Tipo do Documento:</label>
						</td>
						<td height="20">
						 	<select name="tipoDoc" id="tipoDoc"> <!-- Pegar do Banco de dados os tipos e, caso o usuário selecione outro, exibir campo para cadastrar outro tipo -->
									<option value="">Selecione...</option>
									<option value="oficio">Of�cios</option>
									<option value="relatorio">Relat�rios</option>
									<option value="impresso">Impressos</option>
									<option value="processo">Processos</option>
									<option value="carta">Cartas</option>
									<option value="carta">Outros</option>
							</select>
						</td>
					</tr>			
					
					<tr>
						<td  colspan="2">
							<div align="left"> </br>
								<label for="palavrasChaves" class="labelForms">Palavra Chaves:<font color="#990000"></font></label>
							</div>
						</td>
					</tr>
					<tr>
						<td colspan="2">
								<input class="inputPalavraChave" name="chave1" type="text" size="15" maxlength="32"> - 
								<input class="inputPalavraChave" name="chave2" type="text" size="15" maxlength="32"> - 
								<input class="inputPalavraChave" name="chave3" type="text" size="15" maxlength="32"> 
						</td>
					</tr>
					<tr>
						<td><p></p><input class="buttonPesquisa" type="submit" name="inserir" value="Enviar"></td>
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

	</div>
	<!-- end .container -->

</body>
</html>

