<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Gr�o-Par�</title>


<!-- Import dos styles CSS -->
<link rel="stylesheet" type="text/css" href="/GraoPara/css/principal.css" />
<link rel="stylesheet" type="text/css" href="/GraoPara/css/tabs.css" />
<link rel="stylesheet" type="text/css" href="/GraoPara/css/controle.css" />

<!-- CSS das valida��es -->
<link rel="stylesheet" type="text/css" href="/GraoPara/css/validationEngine.jquery.css" />

<!-- Import dos javascripts -->
<script type="text/javascript" src="/GraoPara/javascript/ajax.js" charset="utf-8"></script>
<script type="text/javascript" src="/GraoPara/javascript/instrucao.js" charset="utf-8"></script>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js" charset="utf-8"></script>

<!-- Import dos scripts de valida��o de formul�rio -->
<script type="text/javascript" src="/GraoPara/javascript/jquery.validationEngine.js" charset="utf-8"></script>
<script type="text/javascript" src="/GraoPara/javascript/script.js" charset="utf-8"></script>
<script type="text/javascript" src="/GraoPara/javascript/languages/jquery.validationEngine-pt.js" charset="utf-8"></script>

</head>

<body>

	<div class="container">
		<div class="header"></div>
		
		<!-- Come�o do menu lateral -->
		<div class="sidebar1">

			<!--Depois de logado-->
			<div class="LoginArea" id="logado" style="display:block;">
				<form method="post" action="/GraoPara/doLogout">
					<fieldset>
						<label for="login">Bem vindo</label>
						<label onload="getName()"></label>
					</fieldset>
					<fieldset>
						<input class="buttonSair" type="submit" name="Sair" value="Sair" /></a>
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
				</ul>
			</article>
		</div>
		<!-- Fim do Menu Lateral -->
		<div class="content" id="content">
			<h2>Pesquisa de Documento</h2>
			<form action="#" method="POST" name="cadastro" onSubmit="return valida();">
				<table class="tableForms" width="600" border="0" align="center" cellpadding="0" cellspacing="0">
								<tr>
						<td height="20">
							<label for="identificacao" class="labelForms">Identifi��o:</label>
						</td>
						<td height="20">
						 	<select name="identificacao" class="input">
									<option selected>Selecione...</option>
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
							<label for="titulo" class="labelForms">T�tulo:</label>
						</td>
						<td width="377" height="20">
								<input class="input" name="titulo" type="text" size="20" maxlength="48">
						</td> 
					</tr>
					<tr>
						<td height="20">
							<label for="numeroAPEP" class="labelForms">N�mero APEP ou Sequencial:</label>
						</td>
						<td width="377" height="20">
								<input class="input" name="numero" type="text" size="10" maxlength="4">
						</td>
					</tr>
					<tr>
						<td height="20">
							<label for="autor" class="labelForms">Autor do Documento:</label>
						</td>
						<td width="377" height="20">
						 		<input class="input" name="autor" type="text" size="20" maxlength="48">
						</td>
					</tr>
					<tr>
						<td height="20">
							<label for="destinario" class="labelForms">Destinat�rio do Documento:</label>
						</td>
						<td width="377" height="20">
						     
						    	<input class="input" name="destinatario" type="text" size="20" maxlength="48">
						</td>
					</tr>
					<tr>
						<td height="20">
							<label for="estado" class="labelForms">Estado:</label>
		                
						</td>
		                <td>
		                    <select class="inputEstado" name="estado" id="estado">
									<option selected>---</option>
									<option value="AC">AC</option>
									<option value="AL">AL</option>
									<option value="AP">AP</option>
									<option value="AM">AM</option>
									<option value="BA">BA</option>
									<option value="CE">CE</option>
									<option value="ES">ES</option>
									<option value="DF">DF</option>
									<option value="MA">MA</option>
									<option value="MT">MT</option>
									<option value="MS">MS</option>
									<option value="MG">MG</option>
									<option value="PA">PA</option>
									<option value="PB">PB</option>
									<option value="PR">PR</option>
									<option value="PE">PE</option>
									<option value="PI">PI</option>
									<option value="RJ">RJ</option>
									<option value="RN">RN</option>
									<option value="RS">RS</option>
									<option value="RO">RO</option>
									<option value="RR">RR</option>
									<option value="SC">SC</option>
									<option value="SP">SP</option>
									<option value="SE">SE</option>
									<option value="TO">TO</option>
							</select>
		                </td>
						
					</tr>
		            <tr>
		            	<td height="20">
							<label for="cidade" class="labelForms">Cidade:</label>
								
						</td>
		                <td>
		                <input class="input" name="cidade" type="text" size="15" maxlength="43">
		                </td>
		            </tr>
					<tr>
						<td height="20">
							<label for="dataDocumento" class="labelForms">Data do Documento:</label>
						</td>
						<td height="20">
						<input class="input validate[custom[date]]" type="text" name="data" id="data" maxlength="10"/>
						</td>
					</tr>
					<tr>
						<td height="20">
							<label for="dataDocumento" class="labelForms">Tipo do Documento:</label>
						</td>
						<td height="20">
						 	<select class="input" name="tipoDoc"> <!-- Pegar do Banco de dados os tipos e, caso o usuário selecione outro, exibir campo para cadastrar outro tipo -->
									<option selected>Selecione...</option>
									<option value="codice">Of�cios</option>
									<option value="caixa">Relat�rios</option>
									<option value="caixa">Impressos</option>
									<option value="caixa">Processos</option>
									<option value="caixa">Outro</option>
							</select>
						</td>
					</tr>			
					
					<tr>
						<td height="20" colspan="2">
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
						<td colspan="2" height="20"><input class="buttonPesquisa" type="submit" name="inserir" value="Enviar"></td>
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


