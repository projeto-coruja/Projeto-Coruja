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
<script type="text/javascript" src="/GraoPara/javascript/cookie.js"
	charset="utf-8"></script>
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
<body onloadstart="checkCookie()">
	<div class="container">
		<div class="header"></div>
		<!-- Fim do Banner -->
		
		<!-- Come�o do menu lateral -->
		<div class="sidebar1">

			<!-- ----------------------------------------------------------------------- come�a-->

			<!--Come�o da �rea de login -->
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
		<div class="contentListagem" id="content">
		<h2>Listagem de Documentos</h2>
			<table width="100%" border="1" align="center" cellpadding="0" cellspacing="0">
				<tr><td>
						<label class="labelExibe">Identifica��o</label>
					</td>
					<td>
						<label class="labelExibe">C�digo</label>
					</td>
					<td>
						<label class="labelExibe">T�tulo</label>
					</td>
					<td>
						<label class="labelExibe">Tipo de N�mero</label>
					</td>
					<td>
						<label class="labelExibe">N�mero</label>
					</td>
					<td>
						<label class="labelExibe">Autor</label>
					</td>
					<td>
						<label class="labelExibe">Destinat�rio</label>
					</td>
					<td>
						<label class="labelExibe">Local</label>
					</td>
					<td>
						<label class="labelExibe">Data</label>
					</td>
					<td>
						<label class="labelExibe">Documento</label>
					</td>
					<td>
						<label class="labelExibe">A��es</label>
					</td>
				</tr>
				<!-- Exemplo de Documento inserido -->
				<tr>
					<td>
						<label class="labelExibe">C�dice</label>
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
						<label class="labelExibe">Jos� Maria</label>
					</td>
					<td>
						<label class="labelExibe">Maria Jo�o</label>
					</td>
					<td>
						<label class="labelExibe">S�o Paulo - SP</label>
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
