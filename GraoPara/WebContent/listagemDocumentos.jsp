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
<link rel="stylesheet" type="text/css"
	href="/GraoPara/css/validationEngine.jquery.css" />

<!-- Import dos javascripts -->
<script type="text/javascript" src="/GraoPara/javascript/cookie.js"
	charset="utf-8"></script>
<script type="text/javascript" src="/GraoPara/javascript/ajax.js"
	charset="utf-8"></script>
<script type="text/javascript" src="/GraoPara/javascript/instrucao.js"
	charset="utf-8"></script>
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"
	charset="utf-8"></script>

<!-- Import dos scripts de validação de formulário -->
<script type="text/javascript"
	src="/GraoPara/javascript/jquery.validationEngine.js" charset="utf-8"></script>
<script type="text/javascript" src="/GraoPara/javascript/script.js"
	charset="utf-8"></script>
<script type="text/javascript"
	src="/GraoPara/javascript/languages/jquery.validationEngine-pt.js"
	charset="utf-8"></script>

</head>
<body onloadstart="checkCookie()">
	<div class="container">
		<div class="header"></div>
		<!-- Fim do Banner -->
		<!-- Começo do menu lateral -->
		<div class="sidebar1">

			<!-- ----------------------------------------------------------------------- começa-->

			<!--Começo da área de login -->
			<div class="LoginArea" id="loginDefault">
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


			<!-- ----------------------------------------------------------------------- -->

			<!--Depois de logado, sendo permissão tipo USER-->
			<!-- <div class="LoginArea" id="loginUser">
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
			</div> -->

			<!-- ----------------------------------------------------------------------- -->

			<!--Depois de logado, sendo permissão tipo ADMIN-->
			<!-- 	<div class="LoginArea" id="loginAdmin">
				<form method="post" action="/GraoPara/doLogin">
					<fieldset>
						<label for="login">Bem vindo</label>
					</fieldset>
					<fieldset><input class="buttonSair" type="submit" name="Sair"
							value="Sair" />
					</fieldset>
				</form>
			</div> -->

			<!-- ----------------------------------------------------------------------- termina-->

			<div class="AfterLogin" id="AfterLogin" hidden="0">
				<form method="post" action="/GraoPara/doLogout">
					Bem vindo #UserName <input class="buttonEntrar" type="submit"
						name="Sair" value="Sair" />
				</form>
			</div>
			<fieldset>
				<a href="/GraoPara/CadUsuario.jsp"><input type="button"
					class="buttonRegistrar" name="Registrar" value="Registrar"></a>
			</fieldset>
			<!-- Fim da área de login -->

			<article class="menuLateral">
				<ul class="nav" id="menu">
					<li><a href="/GraoPara/index.jsp"><span>H</span>ome</a></li>
					<li><a href="/GraoPara/pesquisa.jsp"><span>P</span>esquisar</a></li>
					<li><a href="/GraoPara/sobre.jsp"><span>S</span>obre</a></li>
				</ul>
			</article>

			<!-- Área para texto na barra lateral, a barra cresce ao inserir conteudo... -->
			<p></p>
			<p></p>
			<p></p>
			<p></p>
		</div>
		<!-- Fim do Menu Lateral -->
		<div class="contentListagem" id="content">
		<h2>Listagem de Documentos</h2>
			<table width="100%" border="1" align="center" cellpadding="0" cellspacing="0">
				<tr><td>
						<label class="labelExibe">Identificação</label>
					</td>
					<td>
						<label class="labelExibe">Código</label>
					</td>
					<td>
						<label class="labelExibe">Título</label>
					</td>
					<td>
						<label class="labelExibe">Tipo de Número</label>
					</td>
					<td>
						<label class="labelExibe">Número</label>
					</td>
					<td>
						<label class="labelExibe">Autor</label>
					</td>
					<td>
						<label class="labelExibe">Destinatário</label>
					</td>
					<td>
						<label class="labelExibe">Local</label>
					</td>
					<td>
						<label class="labelExibe">Data</label>
					</td>
					<td>
						<label class="labelExibe" style="FONT-FAMILY: 'Bitstream Charter';">Documento</label>
					</td>
					<td>
						<label class="labelExibe">Ações</label>
					</td>
				</tr>
				<!-- Exemplo de Documento inserido -->
				<tr>
					<td>
						<label class="labelExibe">Códice</label>
					</td>
					<td>
						<label class="labelExibe">1234</label>
					</td>
					<td>
						<label class="labelExibe">Documento de Exemplo</label>
					</td>
					<td>
						<label class="labelExibe">APEP</label>
					</td>
					<td>
						<label class="labelExibe">2531</label>
					</td>
					<td>
						<label class="labelExibe">José Maria</label>
					</td>
					<td>
						<label class="labelExibe">Maria João</label>
					</td>
					<td>
						<label class="labelExibe">São Paulo - SP</label>
					</td>
					<td>
						<label class="labelExibe">11/10/1900</label>
					</td>
					<td>
						<label class="labelExibe">Carta</label>
					</td>
					<td>
						<a href="#"><img src="/GraoPara/images/approve.png" title="Aprovar" alt="Aprovarr"/></a> 
						<a href="#"><img src="/GraoPara/images/edit.png" title="Editar" alt="Editar"/></a> 
						<a href="#"><img src="/GraoPara/images/remove.png" title="Remover" alt="Remover"/></a>
					</td>
				</tr>
			</table>
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
