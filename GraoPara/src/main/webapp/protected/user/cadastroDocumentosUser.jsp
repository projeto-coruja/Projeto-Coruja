<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Grão-Pará</title>

<!-- Import dos styles CSS -->
<link rel="stylesheet" type="text/css" href="/GraoPara/css/principal.css" />
<link rel="stylesheet" type="text/css" href="/GraoPara/css/tabs.css" />
<link rel="stylesheet" type="text/css" href="/GraoPara/css/controle.css" />

<!-- CSS das validações -->
<link rel="stylesheet" type="text/css" href="/GraoPara/css/validationEngine.jquery.css" />

<!-- Import dos javascripts -->
<script type="text/javascript" src="/GraoPara/javascript/ajax.js" charset="utf-8"></script>
<script type="text/javascript" src="/GraoPara/javascript/instrucao.js" charset="utf-8"></script>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js" charset="utf-8"></script>

<!-- Import dos scripts de validação de formulário -->
<script type="text/javascript" src="/GraoPara/javascript/jquery.validationEngine.js" charset="utf-8"></script>
<script type="text/javascript" src="/GraoPara/javascript/script.js" charset="utf-8"></script>
<script type="text/javascript" src="/GraoPara/javascript/languages/jquery.validationEngine-pt.js" charset="utf-8"></script>

</head>
<body onloadstart="checkCookie()">
	<div class="container">
		<div class="header"></div>
		
		<!-- Começo do menu lateral -->
		<div class="sidebar1">
			
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

			<!-- Área para texto na barra lateral, a barra cresce ao inserir conteudo... -->
			<p></p>
			<p></p>
			<p></p>
			<p></p>
		</div>
		<!-- Fim do Menu Lateral -->
		<div class="content" id="content">
				
			<h2>Cadastro de Documentos</h2>
			<form action="/GraoPara/addDoc" method="POST" name="cadastro">
				<table class="tableForms" width="600" border="0" align="center" cellpadding="0" cellspacing="0">
					<tr>
						<td height="20" colspan="2">
							<div align="left">
								<font size="1" face="Verdana, Arial, Helvetica, sans-serif">
									<b>PREENCHA TODOS OS CAMPOS COM ASTERÍSCO <font
										color="#FF0000">*</font></b>
								</font>
							</div>
						</td>
					</tr>
					<tr>
						<td height="20">
							<label for="identificaÃ§Ã£o" class="labelForms">Identificação:<font color="#FF0000">*</font></label>
						</td>
						<td height="20">
						 	<select name="identificacao" class="input validate[required] smallInput" id="identificacao">
									<option value="">Selecione...</option>
									<option value="codice">Número de Códice</option>
									<option value="caixa">Número da Caixa</option>
							</select>
						</td>
					</tr>
					<tr>
						<td height="20">
							<label for="codigo" class="labelForms">Código:<font color="#FF0000">*</font></label>
						</td>
						<td width="377" height="20">
								<input class="inputShort validate[required]" name="codigo" size="10" id="codigo" type="text" maxlength="5">
						</td>
					</tr>
					 <tr>
						<td height="20">
							<label for="titulo" class="labelForms">Título:<font color="#FF0000">*</font></label>
						</td>
						<td width="377" height="20">
								<input class="input validate[required]" name="titulo" id="titulo" type="text" size="20" maxlength="48">
		                        
						</td>
					</tr>
					<tr>
						<td height="20">
							<label for="numeroAPEP" class="labelForms">Número APEP ou Sequencial:<font color="#FF0000">*</font></label>
						</td>
						<td width="377" height="20">
								<select name="tipo_num" class="inputTipoNum validate[required] smallInput" id="tipo_num">
									<option value="" selected>Selecione...</option>
									<option value="APEP">APEP</option>
									<option value="SEQ">Sequencial</option>
								</select>
								<input class="inputShort validate[required,custom[onlyNumberSp]]" name="numero" id="numero" type="text" maxlength="4"> 
						</td>
					</tr>
					<tr>
						<td height="20">
							<label for="autor" class="labelForms">Autor do Documento:<font color="#FF0000">*</font></label>
						</td>
						<td width="377" height="20">
						 		<input class="input validate[required]" name="autor" id="autor" type="text" size="20" maxlength="48">
						</td>
					</tr>
					<tr>
						<td height="20">
							<label for="destinario" class="labelForms">Destinatário do Documento:<font color="#FF0000">*</font></label>
						</td>
						<td width="377" height="20">
						     
						    	<input class="input validate[required]" name="destinatario" id="destinatario" type="text" size="20" maxlength="48">
						</td>
					</tr>
					<!-- <tr>
						<td height="20">
							<label for="estado" class="labelForms">Estado:<font color="#FF0000">*</font></label>
		                
						</td>
		                <td>
		                    <select class="inputEstado validate[required] smallInput" name="estado" id="estado">
									<option value="">---</option>
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
						
					</tr> -->
		            <tr>
		            	<td height="20">
							<label for="local" class="labelForms">Local:<font color="#FF0000">*</font></label>
								
						</td>
		                <td>
		                <input class="input validate[required]" name="local" id="local" type="text" maxlength="43">
		            </tr>
					<tr>
						<td height="20">
							<label for="dataDocumento" class="labelForms">Data do Documento:<font color="#FF0000">*</font></label>
						</td>
						<td height="20">
							<input class="input validate[required,custom[date]]" type="text" name="data" id="data" maxlength="10"/> <label for="maxDigitos" class="labelForms">(Ex.: 12/02/1993)</label>
						</td>
					</tr>
					<tr>
						<td height="20">
							<label for="dataDocumento" class="labelForms">Tipo do Documento:<font color="#FF0000">*</font></label>
						</td>
						<td height="20">
						 	<select class="input validate[required] smallInput" name="tipoDoc" id="tipoDoc"> <!-- Pegar do Banco de dados os tipos e, caso o usuÃ¡rio selecione outro, exibir campo para cadastrar outro tipo -->
									<option value="">Selecione...</option>
									<option value="ofícios">Ofícios</option>
									<option value="relatórios">Relatórios</option>
									<option value="impressos">Impressos</option>
									<option value="processos">Processos</option>
									<option value="cartas">Cartas</option>
							</select>
						</td>
					</tr>			
					<tr>
						<td height="20" colspan="2">
							<div align="left"> </br>
								<font size="1" face="Verdana, Arial, Helvetica, sans-serif"><b>RESUMO OU VERBETE DO DOCUMENTO:</b><font color="#FF0000">*</font></font>
							</div>
						</td>
					</tr>
					<td height="20" colspan="2">
						<font class="labelForms">
							<textarea class="inputResumo" id="resumo" name="resumo" rows="7" cols="40" maxlength="2048"></textarea>
						</font>
					</td>			
					<tr>
						<td height="20" colspan="2">
							<div align="left"> </br>
								<label for="palavrasChaves" class="labelForms">Palavra Chaves:<font color="#990000">(Obrigatório pelo menos uma)</font></label>
							</div>
						</td>
					</tr>
					<tr>
						<td colspan="2">
								<input class="inputPalavraChave validate[groupRequired[chaves]]" id="chave1" name="chave1" type="text" size="15" maxlength="32"> - 
								<input class="inputPalavraChave validate[groupRequired[chaves]]" id="chave2" name="chave2" type="text" size="15" maxlength="32"> - 
								<input class="inputPalavraChave validate[groupRequired[chaves]]" id="chave3" name="chave3" type="text" size="15" maxlength="32"> 
						</td>
					</tr>
					<tr>
						<td height="20"></br> </br><input class="buttonEntrar" type="submit" name="inserir" value="Enviar"></td>
						<td height="20"></td>
					</tr>
				</table>
			</form>	
		
		</div>
		<!-- Começo do Rodapé -->
		<div class="footer">
			<p>Copyright © - Universidade Federal de São Paulo - UNIFESP 2012</p>
			<p>Desenvolvido pelo grupo Coruja</p>
		</div>
		<!-- Fim do Rodapé -->
		<!-- end .container -->
	</div>
</body>
</html>
