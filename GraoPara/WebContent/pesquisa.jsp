<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Grão-Pará</title>

<!-- Import dos styles CSS -->
<link rel="stylesheet" type="text/css" href="/GraoPara/css/principal.css" />
<link rel="stylesheet" type="text/css" href="/GraoPara/css/tabs.css" />
<link rel="stylesheet" type="text/css" href="/GraoPara/css/controle.css" />

<!-- Import dos javascripts -->
<script type="text/javascript" src="/GraoPara/javascript/ajax.js"></script>
<script type="text/javascript" src="/GraoPara/javascript/instrucao.js"></script>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>

</head>

<body>

	<div class="container">
		<div class="header">
			<!-- Começo do banner -->
			<a href="/GraoPara/index.jsp" class="banner"></a>
		</div>
		<!-- Fim do Banner -->
		<!-- Começo do menu lateral -->
		<div class="sidebar1">

			<!--Começo da área de login -->
			<div class="LoginArea" id="LoginArea">
			<form method="post" action = "LoginServlet">
				<fieldset>
					<label for="login">Login:</label>
						<input class="inputLogin"
							type="text" name="login" height="30px" size="auto"
							placeholder="Seu login" required>
					<label for="senha">Senha:</label>
						<input class="inputLogin"
							type="password" name="senha" height="30px" size="auto"
							placeholder="Sua senha" required>
				</fieldset>
				<fieldset>
					<input class="buttonEntrar" type="submit" name="Entrar" value="Entrar"/>
				</fieldset>
			</form>
			</div>
			<div class="AfterLogin" id="AfterLogin" hidden="0">
			Bem vindo #UserName
			<input class="buttonEntrar" type="submit" name="Entrar" value="Entrar"/>
			</div>
			<fieldset>
				<a href="/GraoPara/CadUsuario.jsp"><input type="button" class="buttonRegistrar" name="Registrar" value="Registrar"></a>
			</fieldset>
			<!-- Fim da área de login -->

			<article class="menuLateral">  
			<ul class="nav" id="menu">
				<li><a href="/GraoPara/index.jsp"><span>H</span>ome</a></li>
				<li><a href="/GraoPara/pesquisa.jsp"><span>P</span>esquisar</a></li>
				<li><a href="/GraoPara/sobre.jsp"><span>S</span>obre</a></li>
				
				<!-- Botão que precisa, ou não, ser escondido para visitantes -->
				<li><a href="/GraoPara/protected/user/cadastroDocumentos.jsp">Cadastrar Documento</a></li>
				
				<!-- Botões temporários para testes -->
				<li><a href="/GraoPara/protected/user/UserControle.jsp">Painel User</a></li>
				<li><a href="/GraoPara/protected/admin/AdminControle.jsp">Painel Admin</a></li>
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
			<h2>Pesquisa de Documento</h2>
			<form action="#" method="POST" name="cadastro" onSubmit="return valida();">
				<table class="tableForms" width="600" border="0" align="center" cellpadding="0" cellspacing="0">
								<tr>
						<td height="20">
							<label for="identificacao" class="labelForms">Identifição:</label>
						</td>
						<td height="20">
						 	<select name="identificacao" class="input">
									<option selected>Selecione...</option>
									<option value="codice">Número de Códice</option>
									<option value="caixa">Número da Caixa</option>
							</select>
						</td>
					</tr>
					<tr>
						<td height="20">
							<label for="codigo" class="labelForms">Código:</label>
						</td>
						<td width="377" height="20">
								<input class="input" name="codigo" type="text" size="10" maxlength="5">
		                        <label for="maxDigitos" class="labelForms">(máx. 5 digitos)</label>
						</td>
					</tr>
					<tr>
						<td height="20">
							<label for="nomeDocumento" class="labelForms">Nome do Documento:</label>
						</td>
						<td width="377" height="20">
								<input class="input" name="nome" type="text" size="20" maxlength="100">
		                        <label for="maxDigitos" class="labelForms">(máx.100 digitos)</label> 
						</td>
					</tr>
					<tr>
						<td height="20">
							<label for="numeroAPEP" class="labelForms">Número APEP ou Sequencial:</label>
						</td>
						<td width="377" height="20">
								<input class="input" name="numero" type="text" size="10" maxlength="4">
		                        <label for="maxDigitos" class="labelForms">(máx. 4 digitos)</label>
						</td>
					</tr>
					<tr>
						<td height="20">
							<label for="autor" class="labelForms">Autor do Documento:</label>
						</td>
						<td width="377" height="20">
						 		<input class="input" name="autor" type="text" size="20" maxlength="100">
		                        <label for="maxDigitos" class="labelForms">(máx. 100 digitos)</label>
						</td>
					</tr>
					<tr>
						<td height="20">
							<label for="destinario" class="labelForms">Destinatário do Documento:</label>
						</td>
						<td width="377" height="20">
						     
						    	<input class="input" name="destinatario" type="text" size="20" maxlength="100">
		                        <label for="maxDigitos" class="labelForms">(máx. 100 digitos)</label>
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
		                <input class="input" name="cidade" type="text" size="15" maxlength="8">
		                </td>
		            </tr>
					<tr>
						<td height="20">
							<label for="dataDocumento" class="labelForms">Data do Documento:</label>
						</td>
						<td height="20">
							<input class="input" type="text" name="data" maxlength="10" onkeyup="Formatadata(this,event)" />
						</td>
					</tr>
					<tr>
						<td height="20">
							<label for="dataDocumento" class="labelForms">Tipo do Documento:</label>
						</td>
						<td height="20">
						 	<select class="input" name="tipoDoc"> <!-- Pegar do Banco de dados os tipos e, caso o usuÃ¡rio selecione outro, exibir campo para cadastrar outro tipo -->
									<option selected>Selecione...</option>
									<option value="codice">Ofí­cios</option>
									<option value="caixa">Relatórios</option>
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
								<input class="inputPalavraChave" name="chave1" type="text" size="15" maxlength="30"> - 
								<input class="inputPalavraChave" name="chave2" type="text" size="15" maxlength="30"> - 
								<input class="inputPalavraChave" name="chave3" type="text" size="15" maxlength="30"> 
						</td>
					</tr>
					<tr>
						<td colspan="2" height="20"><input class="buttonPesquisa" type="submit" name="inserir" value="Enviar"></td>
					</tr>
				</table>
			</form>
		</div>
		<!-- Começo do Rodapé -->
		<div class="footer">
			<p>Copyright © - Universidade Federal de São Paulo - UNIFESP 2012</p>
			<p>Desenvolvido pelo grupo Coruja</p>
			<a href="/GraoPara/sobre.jsp">- Sobre -</a>
		</div>
		<!-- Fim do Rodapé -->
		<!-- end .container -->
	</div>
</body>
</html>


