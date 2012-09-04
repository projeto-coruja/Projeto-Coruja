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
<script src="/GraoPara/javascript/validate_pesquisa.js"
	type="text/javascript" charset="utf-8"></script>
<script src="/GraoPara/javascript/utility.js"
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
			<h1>Pesquisa de Documento</h1>
			<form action="/GraoPara/protected/admin/listagemDocumentos.jsp" id="signupform" method="get" name="cadastro">
				<table class="tablePesquisa">
					<tr>
						<td colspan="3"><label class="labelForms"><strong>PREENCHA
									UM OU MAIS CAMPOS A SEGUIR:</strong></label></td>
					</tr>
					<tr>
						<td class="tdPesquisa"><label class="labelForms"
							id="lidentificacao" for="identificacao">Identifica��o:</label></td>
						<td class="field"><select name="identificacao" class="input"
							id="identificacao">
						<%= WebUtility.printSelectOrigem(request) %>
						</select></td>
						<td class="status"><a href="#"><img
								src="/GraoPara/images/icone_ajuda.png"
								alt="Todos os documentos do Arquivo P�blico do Par� que ser�o trabalhados aqui est�o organizados em C�DICE ou em CAIXAS. Portanto, se o documento est� em um c�dice ou em uma caixa faz uma enorme diferen�a, pois se tratam de cole��es diferentes. Tudo � organizado pelo fato de ser caixa ou c�dice e depois a informa��o de qual caixa ou c�dice est� se falando � muito importante, pois atrelada a cada uma dessas caixas ou c�dices est�, �s vezes, centenas de documentos."
								title="Todos os documentos do Arquivo P�blico do Par� que ser�o trabalhados aqui est�o organizados em C�DICE ou em CAIXAS. Portanto, se o documento est� em um c�dice ou em uma caixa faz uma enorme diferen�a, pois se tratam de cole��es diferentes. Tudo � organizado pelo fato de ser caixa ou c�dice e depois a informa��o de qual caixa ou c�dice est� se falando � muito importante, pois atrelada a cada uma dessas caixas ou c�dices est�, �s vezes, centenas de documentos." /></a>
						</td>
					</tr>
					<tr>
						<td class="tdPesquisa"><label class="labelForms" id="lcodigo"
							for="codigo">C�digo:</label></td>
						<td class="field"><input class="input" name="codigo"
							id="codigo" type="text" maxlength="5"></td>
						<td class="status"><a href="#"><img
								src="/GraoPara/images/icone_ajuda.png" alt="C�digo do documento"
								title="Informe o c�digo do documento que deseja pesquisar" /></a></td>
					</tr>
					<tr>
						<td class="tdPesquisa"><label class="labelForms" id="ltitulo"
							for="titulo">T�tulo:</label></td>
						<td class="field"><input class="input" name="titulo"
							id="titulo" type="text" size="20" maxlength="500"></td>
						<td class="status"><a href="#"><img
								src="/GraoPara/images/icone_ajuda.png"
								alt="Cada caixa ou c�dice tem um t�tulo, geralmente longo."
								title="Cada caixa ou c�dice tem um t�tulo, geralmente longo." /></a></td>
					</tr>
					<tr>
						<td class="tdPesquisa"><label class="labelForms" id="lnumero"
							for="numero">N�mero APEP ou Sequencial:</label></td>
						<td class="field"><input class="input" name="numero"
							id="numero" type="text" maxlength="4"></td>
						<td class="status"><a href="#"><img
								src="/GraoPara/images/icone_ajuda.png"
								alt="O n�mero APEP � o n�mero do documento dentro da caixa ou c�dice que o arquivista atribuiu. Muitos documentos possuem j� essa numera��o que facilita encontrar o documento dentro do conjunto. Quando existir esse n�mero ser� com esse que identificaremos o documento. Em alguns casos, por�m, o documento n�o est� identificado. A� voc� tem, �s vezes, duzentos documentos sem nenhum tipo de numera��o, o que torna imposs�vel para o pesquisador que ler os verbetes saber rapidamente de que texto est� se falando. Nestes casos, usaremos o que estamos chamando de n�mero sequencial."
								title="O n�mero APEP � o n�mero do documento dentro da caixa ou c�dice que o arquivista atribuiu. Muitos documentos possuem j� essa numera��o que facilita encontrar o documento dentro do conjunto. Quando existir esse n�mero ser� com esse que identificaremos o documento. Em alguns casos, por�m, o documento n�o est� identificado. A� voc� tem, �s vezes, duzentos documentos sem nenhum tipo de numera��o, o que torna imposs�vel para o pesquisador que ler os verbetes saber rapidamente de que texto est� se falando. Nestes casos, usaremos o que estamos chamando de n�mero sequencial." /></a></td>
					</tr>
					<tr>
						<td class="tdPesquisa"><label class="labelForms" id="lautor"
							for="autor">Autor do Documento:</label></td>
						<td class="field"><input class="input" name="autor"
							id="autor" type="text" size="20" maxlength="48"></td>
						<td class="status"><a href="#"><img
								src="/GraoPara/images/icone_ajuda.png"
								alt="Autor do Documento que deseja pesquisar"
								title="Autor do Documento que deseja pesquisar" /></a></td>
					</tr>
					<tr>
						<td class="tdPesquisa"><label class="labelForms"
							id="ldestinatario" for="destinatario">Destinat�rio do
								Documento:</label></td>
						<td class="field"><input class="input" name="destinatario"
							id="destinatario" type="text" size="20" maxlength="48"></td>
						<td class="status"><a href="#"><img
								src="/GraoPara/images/icone_ajuda.png"
								alt="Esse campo descreve para quem era destinado o documento. Por exemplo, o governo no Rio de Janeiro, a autoridade fulano de tal. Trata-se de um campo textual, assim como autor ou verbete."
								title="Esse campo descreve para quem era destinado o documento. Por exemplo, o governo no Rio de Janeiro, a autoridade fulano de tal. Trata-se de um campo textual, assim como autor ou verbete." /></a></td>
					</tr>
					<tr>
						<td class="tdPesquisa"><label class="labelForms" id="llocal"
							for="local">Local:</label></td>
						<td class="field"><input class="input" name="local"
							id="local" type="text" maxlength="48"></td>
						<td class="status"><a href="#"><img
								src="/GraoPara/images/icone_ajuda.png"
								alt="Trata-se do local em que foi escrito o documento, normalmente a cidade. Por exemplo, Bel�m."
								title="Trata-se do local em que foi escrito o documento, normalmente a cidade. Por exemplo, Bel�m." /></a></td>
					</tr>
					<tr>
						<td class="tdPesquisa"><label class="labelForms" id="ldata"
							for="data">Ano:</label></td>
						<td class="field"><input class="input"
							type="text" name="ano" id="ano" maxlength="4" /></td>
						<td class="status"><a href="#"><img
								src="/GraoPara/images/icone_ajuda.png"
								alt="Informe somente o ano se quiser filtrar a pesquisa por per�odo."
								title="Informe somente o ano se quiser filtrar a pesquisa por per�odo." /></a></td>
					</tr>
					<tr>
						<td class="tdPesquisa"><label class="labelForms" id="ltipoDoc"
							for="tipoDoc">Tipo do Documento:</label></td>
						<td class="field"><select class="input" name="tipoDoc"
							id="tipoDoc">
								<!-- Pegar do Banco de dados os tipos e, caso o usuário selecione outro, exibir campo para cadastrar outro tipo -->
								<%=WebUtility.printSelectTipoDoc(request) %>
						</select></td>
						<td class="status"><a href="#"><img
								src="/GraoPara/images/icone_ajuda.png"
								alt="Selecione um dos tipos de documentos para filtrar resultados"
								title="Selecione um dos tipos de documentos para filtrar resultados" /></a></td>
					</tr>
					<tr>
						<td colspan="3"><label for="palavrasChaves"
							class="labelForms">Palavra Chaves:</label></td>
					</tr>
					<tr>
						<td class="field" colspan="2">
							<select class="input" name="chave1" id="chave1" style="width: 120px">
								<option value = "">Nenhuma</option>
								<%= WebUtility.printSelectKeyWords(request, "chave1") %>
							</select>
							<select class="input" name="chave2" id="chave2" style="width: 120px">
								<option value = "">Nenhuma</option>
								<%= WebUtility.printSelectKeyWords(request, "chave2") %>
							</select>
							<select  class="input" name="chave3" id="chave3" style="width: 120px">
								<option value = "">Nenhuma</option>
								<%= WebUtility.printSelectKeyWords(request, "chave3") %>
							</select>
						</td>
						<td class="status"><a href="#"><img
								src="/GraoPara/images/icone_ajuda.png"
								alt="Informe de uma a tr�s palavras chaves para filtrar sua pesquisa"
								title="Informe de uma a tr�s palavras chaves para filtrar sua pesquisa" /></a></td>
					</tr>
					<tr>
						<td colspan="3">
							<p></p> <input class="buttonLimpar" name="limpar" type="reset"
							value="Limpar" /><input class="buttonRegistrar" name="inserir"
							type="submit" value="Enviar" id="signupsubmit" style="FONT-FAMILY: 'Bitstream Charter';"/>
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


