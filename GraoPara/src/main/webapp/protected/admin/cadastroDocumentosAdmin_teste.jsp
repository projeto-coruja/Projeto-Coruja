<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Grão-Pará</title>

<!-- Import dos styles CSS -->
<link rel="stylesheet" type="text/css"
	href="/GraoPara/css/principal.css" />
<link rel="stylesheet" type="text/css" href="/GraoPara/css/tabs.css" />
<link rel="stylesheet" type="text/css" href="/GraoPara/css/controle.css" />

<!-- CSS das validações -->
<link rel="stylesheet" type="text/css" media="screen"
	href="/GraoPara/css/styleValidation.css" />

<!-- Import dos javascripts -->
<script type="text/javascript" src="/GraoPara/javascript/ajax.js"
	charset="utf-8"></script>
<script type="text/javascript" src="/GraoPara/javascript/instrucao.js"
	charset="utf-8"></script>
<script src="/GraoPara/javascript/chili-1.7.pack.js"
	type="text/javascript"></script>
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"
	charset="utf-8"></script>

<!-- Import dos scripts de validação de formulário -->
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

		<!-- Começo do menu lateral -->
		<div class="sidebar1">

			<!--Depois de logado-->
			<div class="LoginArea" id="logado" style="display:block;">
				<form method="post" action="/GraoPara/doLogout">
					<fieldset>
						<label for="login">Bem vindo</label>
						<label onload="getName()"></label>
					</fieldset>
					<fieldset>
						<input class="buttonSair" type="submit" name="Sair" value="Sair" />
					</fieldset>
				</form>
			</div>
			<!-- ----------------------------------------------------------------------- -->

			<article class="menuLateral">  
			<ul class="nav" id="menu">
				<li><a href="/GraoPara/protected/admin/indexAdmin.jsp">Home</a></li>
				<li><a href="/GraoPara/protected/admin/pesquisaAdmin.jsp">Pesquisar</a></li>
				<li><a href="/GraoPara/protected/admin/cadastroDocumentosAdmin.jsp">Cadastrar Documento</a></li>
				<li><a href="/GraoPara/protected/admin/painelAdmin.jsp">Painel Admin</a></li>
				<li><a href="/GraoPara/protected/admin/sobreAdmin.jsp">Sobre</a></li>
			</ul>
			</article>			
		</div>
		<!-- Fim do Menu Lateral -->
		<div class="content" id="content">
				
			<h2>Cadastro de Documentos</h2>
		<form id="signupform" autocomplete="off" method="POST" action="/GraoPara/addDoc">
				<table class="tableForms">
					<tr>
						<td class="labelForms" colspan="3">
							<div align="left">
								<font size="1" face="Verdana, Arial, Helvetica, sans-serif">
									<b>PREENCHA TODOS OS CAMPOS COM ASTERÍSCO <font
										color="#FF0000">*</font></b>
								</font>
							</div>
						</td>
					</tr>
					<tr>
						<td class="labelForms"><label id="lidentificacao" for="identificacao">Identificação<font color="#FF0000">*</font>
						</label></td>
						<td class="field">
							<select name="identificacao" class="input" id="identificacao">
									<option value="">Selecione...</option>
									<option value="codice">Número de Códice</option>
									<option value="caixa">Número da Caixa</option>
							</select></td>
						<td class="status"></td>
					</tr>
					<tr>
						<td class="labelForms"><label id="lcodigo" for="codigo">Código:<font color="#FF0000">*</font>
						</label></td>
						<td class="field"><input class="inputShort" name="codigo" size="10" id="codigo" type="text" maxlength="5"></td>
						<td class="status"></td>
					</tr>
					<tr>
						<td class="labelForms"><label id="ltitulo" for="titulo">Título:<font color="#FF0000">*</font>
						</label></td>
						<td class="field"><input class="input" name="titulo" id="titulo" type="text" size="20" maxlength="48"></td>
						<td class="status"></td>
					</tr>
					<tr>
						<td class="labelForms"><label id="lnumero" for="numero">Número APEP ou Sequencial:<font color="#FF0000">*</font>
						</label></td>
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
						<td class="labelForms"><label id="lautor" for="autor">Autor do Documento:<font color="#FF0000">*</font>
						</label></td>
						<td class="field"><input class="input" name="autor" id="autor" type="text" size="20" maxlength="48"></td>
						<td class="status"></td>
					</tr>
					<tr>
						<td class="labelForms"><label id="ldestinatario" for="destinatario">Destinatário do Documento:<font color="#FF0000">*</font>
						</label></td>
						<td class="field"><input class="input" name="destinatario" id="destinatario" type="text" size="20" maxlength="48"></td>
						<td class="status"></td>
					</tr>
					<tr>
						<td class="labelForms"><label id="llocal" for="local">Local:<font color="#FF0000">*</font>
						</label></td>
						<td class="field"><input class="input" name="local" id="local" type="text" maxlength="48"></td>
						<td class="status"></td>
					</tr>
					<tr>
						<td class="labelForms"><label id="ldata" for="data">Data do Documento:<font
								color="#FF0000">*</font></label></td>
						<td class="field"><input class="input" type="text" name="data" id="data" maxlength="10"/></td>
						<td class="status"></td>
					</tr>
					<tr>
						<td class="labelForms"><label id="ltipoDoc" for="tipoDoc">Tipo do Documento:<font
								color="#FF0000">*</font></label></td>
						<td class="field">
							<select class="input" name="tipoDoc" id="tipoDoc"> <!-- Pegar do Banco de dados os tipos e, caso o usuÃ¡rio selecione outro, exibir campo para cadastrar outro tipo -->
									<option value="">Selecione...</option>
									<option value="ofícios">Ofícios</option>
									<option value="relatórios">Relatórios</option>
									<option value="impressos">Impressos</option>
									<option value="processos">Processos</option>
									<option value="cartas">Cartas</option>
							</select></td>
						<td class="status"></td>
					</tr>		
					<tr>
						<td class="labelForms" colspan="2">
							<div align="left"> </br>
								<font size="1" face="Verdana, Arial, Helvetica, sans-serif"><b>RESUMO OU VERBETE DO DOCUMENTO:</b><font color="#FF0000">*</font></font>
							</div>
						</td>
					</tr>
					<tr>						
						<td class="field" colspan="2"><textarea class="inputResumo" id="resumo" name="resumo" rows="7" cols="40" maxlength="2048"></textarea></td>
						<td class="status"></td>
					</tr>								
					<tr>
						<td class="labelForms" colspan="2">
							<div align="left">
								<label for="palavrasChaves" class="labelForms">Palavra Chaves:<font color="#990000">(Obrigatório pelo menos uma)</font></label>
							</div>
						</td>
					</tr>
					<tr>
					<tr>
						<td class="field" colspan="2">
								<input class="inputPalavraChave" id="chave1" name="chave1" type="text" size="15" maxlength="32"> - 
								<input class="inputPalavraChave" id="chave2" name="chave2" type="text" size="15" maxlength="32"> - 
								<input class="inputPalavraChave" id="chave3" name="chave3" type="text" size="15" maxlength="32"> 
						</td>
						<td class="status"></td>
					</tr>
					<tr>
						<td></br> </br><input class="buttonRegistrar"
							id="signupsubmit" name="inserir" type="submit" value="Enviar" /></td>
						<td></td>
					</tr>
				</table>
			</form>
		
		</div>
		<!-- Começo do Rodapé -->
		<div class="footer">
			<p>Copyright © - Universidade Federal de São Paulo - UNIFESP 2012</p>
			<p>Desenvolvido pelo grupo Coruja</p>
			<a href="/GraoPara/protected/admin/sobre.jsp">- Sobre -</a>
		</div>
		<!-- Fim do Rodapé -->
		<!-- end .container -->
	</div>
</body>
</html>
